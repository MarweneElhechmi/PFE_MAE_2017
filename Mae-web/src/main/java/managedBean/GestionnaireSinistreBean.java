package managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import tn.esprit.MaE.Interface.GestionnaireSinistreServiceLocal;
import tn.esprit.MaE.entities.GestionnaireSinistre;

@ManagedBean
@ViewScoped
public class GestionnaireSinistreBean {


	@EJB
	GestionnaireSinistreServiceLocal local;
	private List<GestionnaireSinistre>gestionnairesFiltred;
	
	

	private List<GestionnaireSinistre>gestionnaires=new ArrayList<>();
	private GestionnaireSinistre gestionnaire=new GestionnaireSinistre();
	
	
	
	public List<GestionnaireSinistre> getgestionnairesFiltred() {
		return gestionnairesFiltred;
	}

	public void setgestionnairesFiltred(List<GestionnaireSinistre> gestionnairesFiltred) {
		this.gestionnairesFiltred = gestionnairesFiltred;
	}

	public List<GestionnaireSinistre> getgestionnaires() {
		return gestionnaires;
	}

	public void setgestionnaires(List<GestionnaireSinistre> gestionnaires) {
		this.gestionnaires = gestionnaires;
	}

	public GestionnaireSinistre getgestionnaire() {
		return gestionnaire;
	}

	public void setgestionnaire(GestionnaireSinistre gestionnaire) {
		this.gestionnaire = gestionnaire;
	}

	@PostConstruct
	public void init(){
	gestionnaire=new GestionnaireSinistre();
	gestionnaires=local.findAll();
	}
	
	public String doAdd(){
		local.addGS(gestionnaire);
		return null;
		
	}
	public String doUpdate(){
		FacesMessage message;
		local.update(gestionnaire);
		message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Opération effectué avec Succés",null);
		FacesContext.getCurrentInstance().addMessage(null, message);
		init();
		return null;
		
	}
	 public String doDelete(GestionnaireSinistre gestionnaire){
		 local.deleteGS(gestionnaire);
		 init();
		 return null;
	 }
	 
	 public String initialiser(){
		 gestionnaire=new GestionnaireSinistre();
		 return null;
	 }
	 
	 public void Valider_AG(GestionnaireSinistre gestionnaire){
		 gestionnaire.setValidé(true);
		 local.update(gestionnaire);
		 
	 }
}
