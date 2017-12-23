package managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import tn.esprit.MaE.Interface.BeneficiaireServiceLocal;
import tn.esprit.MaE.Interface.CoefficientServiceLocal;
import tn.esprit.MaE.Interface.RenteServiceLocal;
import tn.esprit.MaE.Interface.VictimeServiceLocal;
import tn.esprit.MaE.entities.Coefficient;
import tn.esprit.MaE.entities.Victime;

@ManagedBean
@ViewScoped
public class CoefficientBean {


	@EJB
	BeneficiaireServiceLocal local;
	
	
	@EJB
	RenteServiceLocal rlocal;
	
	@EJB
	VictimeServiceLocal vlocal;
	
	@EJB
	CoefficientServiceLocal clocal;
	
	private Victime victime = new Victime();
		
	private List<Coefficient>coefficientsFiltred;
	private List<Coefficient>coefficients=new ArrayList<>();
	private Coefficient coef = new Coefficient();
	
	public Victime getVictime() {
		return victime;
	}


	public void setVictime(Victime victime) {
		this.victime = victime;
	}
	
	
	public List<Coefficient> getCoefficientsFiltred() {
		return coefficientsFiltred;
	}


	public void setCoefficientsFiltred(List<Coefficient> coefficientsFiltred) {
		this.coefficientsFiltred = coefficientsFiltred;
	}


	public List<Coefficient> getCoefficients() {
		return coefficients;
	}


	public void setCoefficients(List<Coefficient> coefficients) {
		this.coefficients = coefficients;
	}


	public Coefficient getCoef() {
		return coef;
	}


	public void setCoef(Coefficient coef) {
		this.coef = coef;
	}


	@PostConstruct
	public void init(){
	
	coefficients=clocal.findAll();
	coef=new Coefficient();

	
	}
	
	public void deleteListe(){
 	   System.out.println("bienvenue");
 	   
			System.out.println("rente moglga"+coefficients. size());
			
					clocal.Delete();
 	   for(int i=0;i<coefficients.size();i++){
				System.out.println("rente moglga"+coefficients.get(1));

					coefficients.remove(coefficients.get(i));
					System.out.println("rente moglga"+coefficients. size());

    }

		coefficients.clear();
	 	   coefficients.remove(coefficients);
    }
    
	
	
	public String doUp(){
		FacesMessage message;
		
		clocal.update(coef);
		message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Opération effectué avec Succés",null);
		FacesContext.getCurrentInstance().addMessage(null, message);
		init();
		return null;
		
	}
}
