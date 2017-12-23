package tn.esprit.MaE.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_agent")
@DiscriminatorValue(value="agent")
public class AgentGeneral extends User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="agent")
	private List<Sinistre>sinistres;
	
	@OneToMany(mappedBy="agentP")
	private List<Police>polices;
	
	public AgentGeneral() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Sinistre> getSinistres() {
		return sinistres;
	}

	public void setSinistres(List<Sinistre> sinistres) {
		this.sinistres = sinistres;
	}

	public List<Police> getPolices() {
		return polices;
	}

	public void setPolices(List<Police> polices) {
		this.polices = polices;
	}

	
	
}
