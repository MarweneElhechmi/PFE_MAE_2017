package managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.MaE.entities.Admin;
import tn.esprit.MaE.entities.AgentGeneral;
import tn.esprit.MaE.entities.Financier;
import tn.esprit.MaE.entities.GestionnaireSinistre;
import tn.esprit.MaE.entities.User;

@ManagedBean(name="identityB")
@SessionScoped
public class identityBean {
	
	
	
	private User identifieduser;
	
	public identityBean()
	{
		
	}
	public User getIdentifieduser() {
		return identifieduser;
	}
	public void setIdentifieduser(User identifieduser) {
		this.identifieduser = identifieduser;
	}

	public Boolean hasRole(String role) {
		Boolean response = false;
		switch (role) {
		case "admin":
			response = identifieduser instanceof Admin;
			break;
		case "financier":
			response = identifieduser instanceof Financier;
			break;
		case "gestionnaire":
			response = identifieduser instanceof GestionnaireSinistre;
			break;
		case "agent":
			response = identifieduser instanceof AgentGeneral;
			break;
		
		}
		return response;
	}
	

}
