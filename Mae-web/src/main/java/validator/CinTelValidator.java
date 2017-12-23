package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value="CinTelValidator")
public class CinTelValidator implements Validator {
	 private final static String CIN_PATTERN = "^[0-9]*$";
     
	    private final static Pattern CIN_COMPILED_PATTERN = Pattern.compile(CIN_PATTERN);
	 public void validate(FacesContext fc, UIComponent c, Object o) throws ValidatorException {
	        // No value is not ok
	        if (o == null || "".equals((String)o)) {
	            FacesMessage msg = new FacesMessage("empty!!!", " Validation Error");
	            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
	            throw new ValidatorException(msg);
	        }
	         
	        // The email matcher
	        Matcher matcher = CIN_COMPILED_PATTERN.matcher((String)o);
	         
	        if (!matcher.matches()) {   // cin doesn't match
	            FacesMessage msg = new FacesMessage("Invalid !numbers only", " Validation Error");
	            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
	            throw new ValidatorException(msg);
	        }
	         
	    }
}
