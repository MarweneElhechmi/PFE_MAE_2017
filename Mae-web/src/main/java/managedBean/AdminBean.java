package managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import tn.esprit.MaE.Interface.AdminServiceLocal;
import tn.esprit.MaE.entities.Admin;
import tn.esprit.MaE.entities.AgentGeneral;

@ManagedBean
@ViewScoped
public class AdminBean {


	@EJB
	AdminServiceLocal local;
	private List<AgentGeneral>agentsFiltred;
	
	

	private List<AgentGeneral>agents=new ArrayList<>();
	private AgentGeneral agent=new AgentGeneral();
	private Admin admin=new Admin();

	
	
	
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<AgentGeneral> getAgentsFiltred() {
		return agentsFiltred;
	}

	public void setAgentsFiltred(List<AgentGeneral> agentsFiltred) {
		this.agentsFiltred = agentsFiltred;
	}

	public List<AgentGeneral> getAgents() {
		return agents;
	}

	public void setAgents(List<AgentGeneral> agents) {
		this.agents = agents;
	}

	public AgentGeneral getAgent() {
		return agent;
	}

	public void setAgent(AgentGeneral agent) {
		this.agent = agent;
	}

	@PostConstruct
	public void init(){
	agent=new AgentGeneral();
	//agents=local.findAll();
	}
	
	/*public String doAdd(){
		local.addAgentGeneral(agent);
		return null;
		
	}*/
	public String doUpdate(){
		FacesMessage message;
		local.updateAdmin(admin);
		message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Opération effectué avec Succés",null);
		FacesContext.getCurrentInstance().addMessage(null, message);
		init();
		return null;
		
	}
	 /*public String doDelete(AgentGeneral agent){
		 local.deleteAgentGeneral(agent);
		 init();
		 return null;
	 }
	 
	 */
	 public String initialiser(){
		 agent=new AgentGeneral();
		 return null;
	 }
	 /*
	 public void Valider_AG(AgentGeneral agent){
		 agent.setValidé(true);
		 local.update(agent);
		 
	 }
	 
	 
	*/
}
