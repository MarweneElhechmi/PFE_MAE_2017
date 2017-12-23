package managedBean;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.MaE.Interface.AuthentificationServiceLocal;
import tn.esprit.MaE.entities.Admin;
import tn.esprit.MaE.entities.AgentGeneral;
import tn.esprit.MaE.entities.Financier;
import tn.esprit.MaE.entities.GestionnaireSinistre;
import tn.esprit.MaE.entities.User;


@ManagedBean(name="authBean")
@SessionScoped
 public class AuthentificationBean {

	@EJB
	private AuthentificationServiceLocal authentificationCrudServicesLocal;
	@ManagedProperty("#{identityB}")
	private identityBean identityBean;
	private String email;
	private String pwd;
	private boolean loggedIn;
	public boolean rememberMe;

	


	public AuthentificationBean() {
	}


	public String doLogin() {
		String authenticationResult = null;
		User user = authentificationCrudServicesLocal.authentifier(email, pwd);
		if (user != null) {
			identityBean.setIdentifieduser(user);
			if (user instanceof Admin) {
				loggedIn = true;
				authenticationResult = "/pages/Admin/index?faces-redirect=true";
			} else if (user instanceof Financier) {
				loggedIn = true;
				authenticationResult = "/pages/Financier/index?faces-redirect=true";
			}
			else if (user instanceof AgentGeneral) {
				loggedIn = true;
				authenticationResult = "/pages/AgentGeneral/index?faces-redirect=true";
			}
			else if (user instanceof GestionnaireSinistre) {
				loggedIn = true;
				authenticationResult = "/pages/GestionnaireSinistre/index?faces-redirect=true";
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Verifier vos données", null));
		}
		return authenticationResult;
	}

	public identityBean getIdentityBean() {
		return identityBean;
	}


	public void setIdentityBean(identityBean identityBean) {
		this.identityBean = identityBean;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public boolean isLoggedIn() {
		return loggedIn;
	}


	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	public boolean isRememberMe() {
		return rememberMe;
	}


	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	public String dologout() {
		
		System.out.println(" BYE auth");
		String authenticationResult = null;
		// FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		
		authenticationResult = "/pages/login?faces-redirect=true";
		/*
		 * try {
		 * FacesContext.getCurrentInstance().getExternalContext().redirect(
		 * "login.jsf"); } catch (IOException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); }
		 */
	
		
		return authenticationResult;

	}
	
public String page_Inscri(){

		return "/pages/Inscription?faces-redirect=true"; 
	
}

	
}
