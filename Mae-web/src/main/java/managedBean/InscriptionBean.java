package managedBean;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.MaE.Interface.AgentGeneralServiceLocal;
import tn.esprit.MaE.Interface.FinancierServiceLocal;
import tn.esprit.MaE.Interface.GestionnaireSinistreServiceLocal;
import tn.esprit.MaE.entities.AgentGeneral;
import tn.esprit.MaE.entities.Financier;
import tn.esprit.MaE.entities.GestionnaireSinistre;

@ManagedBean
@SessionScoped
public class InscriptionBean implements Serializable {
    /**
	 * 
	 */
   @EJB
   AgentGeneralServiceLocal agsl;
   @EJB
   GestionnaireSinistreServiceLocal gssl;
   @EJB 
   FinancierServiceLocal fisl;
   
   
	private static final long serialVersionUID = 1L;
	private String cin;
	private AgentGeneral ag;
	private  GestionnaireSinistre gs;
	private  Financier fi;
    private String nom;
   
	private String prenom;
    private Date naissance;
    private String telephone;
    private String pwd;
    private String pwdConfirm;
    private String typeD;
	private String email;
	
	
	
    public String getCin() {
		return cin;
	}



	public void setCin(String cin) {
		this.cin = cin;
	}



	public AgentGeneral getAg() {
		return ag;
	}



	public void setAg(AgentGeneral ag) {
		this.ag = ag;
	}



	public GestionnaireSinistre getGs() {
		return gs;
	}



	public void setGs(GestionnaireSinistre gs) {
		this.gs = gs;
	}



	public Financier getFi() {
		return fi;
	}



	public void setFi(Financier fi) {
		this.fi = fi;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public Date getNaissance() {
		return naissance;
	}



	public void setNaissance(Date naissance) {
		this.naissance = naissance;
	}



	public String getTelephone() {
		return telephone;
	}



	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



	public String getPwd() {
		return pwd;
	}



	public void setPwd(String pwd) {
		this.pwd = pwd;
	}



	public String getPwdConfirm() {
		return pwdConfirm;
	}



	public void setPwdConfirm(String pwdConfirm) {
		this.pwdConfirm = pwdConfirm;
	}



	public String getTypeD() {
		return typeD;
	}



	public void setTypeD(String typeD) {
		this.typeD = typeD;
	}



	public InscriptionBean() {	}

	
     
    public String AddUser() {
    	
    if(pwd.equals(pwdConfirm))	{
	    if(typeD.equals("agent")){
	    	    ag=new AgentGeneral();   
	    	    ag.setCin(cin);
	    	    ag.setValidé(false);
	    	    ag.setNom(nom);
		  	    ag.setPrenom(prenom);
		  	    ag.setPwd(pwd);
		  	    ag.setTelephone(telephone);
		  	    ag.setNaissance(naissance);
		  	    ag.setEmail(email); 
		  	  FacesMessage msg = new FacesMessage("Succès de l'inscription !Attente de validation de l'administrateur");
				//.addToControl("ffsCompanyForm:test", "Billing Address cannot be removed")
				FacesContext.getCurrentInstance().addMessage(null, msg);
				FacesContext context = FacesContext.getCurrentInstance();
				context.getExternalContext().getFlash().setKeepMessages(true);
	  	        agsl.addAgentGeneral(ag);
	  	        init();

	  	      
	   }
	    else if (typeD.equals("gestionnaire")) {
	    	 gs=new GestionnaireSinistre();
	    	 
	    	 gs.setCin(cin);
	    	 gs.setValidé(false);
	    	 gs.setNom(nom);
	    	 gs.setPrenom(prenom);
	    	 gs.setPwd(pwd);
	    	 gs.setTelephone(telephone);
	    	 gs.setNaissance(naissance);
	    	 gs.setEmail(email); 
	  	        gssl.addGS(gs);
	  	        init();
	  	      FacesMessage msg = new FacesMessage("Succès de l'inscription !Attente de validation de l'administrateur");
				//.addToControl("ffsCompanyForm:test", "Billing Address cannot be removed")
				FacesContext.getCurrentInstance().addMessage(null, msg);
				FacesContext context = FacesContext.getCurrentInstance();
				context.getExternalContext().getFlash().setKeepMessages(true);
		}
         else if (typeD.equals("financier")) {
        	 fi=new Financier();   
        	 fi.setCin(cin);
        	 fi.setValidé(false);
        	 fi.setNom(nom);
        	 fi.setPrenom(prenom);
        	 fi.setPwd(pwd);
        	 fi.setTelephone(telephone);
        	 fi.setNaissance(naissance);
        	 fi.setEmail(email); 
	  	        init();
	  	        fisl.addFinancier(fi);
	  	      FacesMessage msg = new FacesMessage("Succès de l'inscription !Attente de validation de l'administrateur");
				//.addToControl("ffsCompanyForm:test", "Billing Address cannot be removed")
				FacesContext.getCurrentInstance().addMessage(null, msg);
				FacesContext context = FacesContext.getCurrentInstance();
				context.getExternalContext().getFlash().setKeepMessages(true);
				
		} else {  FacesMessage msg = new FacesMessage("Erreur de l'inscription !");
		//.addToControl("ffsCompanyForm:test", "Billing Address cannot be removed")
		FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true); 
              }}
	    else {  FacesMessage msg = new FacesMessage("Mot de passe non Conforme");
		//.addToControl("ffsCompanyForm:test", "Billing Address cannot be removed")
		FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);  }
    init();
    	return "/pages/login?faces-redirect=true";
    }
    @PostConstruct
	public void init(){
    	ag=new AgentGeneral();
    	fi=new Financier(); 
    	gs=new GestionnaireSinistre();
    	
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
