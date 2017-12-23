package validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
@FacesValidator(value="dateValidator")
public class DateValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
		    if (value == null || component.getAttributes().get("fromDate") == null) return;
           
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		   Date date= (Date) component.getAttributes().get("fromDate");
		      int year1 =date.getYear();
		      int Year = LocalDate.now().getYear();
		    if (Year-year1<18) {
		        FacesMessage message = new FacesMessage("minimum age 18!");
		        message.setSeverity(FacesMessage.SEVERITY_ERROR);
		        
		        throw new ValidatorException(message);
		    }
		
	}

}
