package tn.esprit.MaE.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Police {

	@Id
	private int num_police;
	private String garantie;
	private float prime;
	
	@ManyToOne
	private AgentGeneral agentP;
	
	@ManyToOne
	private QuittanceDePrime quittance;
	
	public Police() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNum_police() {
		return num_police;
	}

	public void setNum_police(int num_police) {
		this.num_police = num_police;
	}

	public String getGarantie() {
		return garantie;
	}

	public void setGarantie(String garantie) {
		this.garantie = garantie;
	}

	public float getPrime() {
		return prime;
	}

	public void setPrime(float prime) {
		this.prime = prime;
	}

	public AgentGeneral getAgentP() {
		return agentP;
	}

	public void setAgentP(AgentGeneral agentP) {
		this.agentP = agentP;
	}

	public QuittanceDePrime getQuittance() {
		return quittance;
	}

	public void setQuittance(QuittanceDePrime quittance) {
		this.quittance = quittance;
	}
	
	
	
}
