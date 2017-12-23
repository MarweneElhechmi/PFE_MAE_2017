package tn.esprit.MaE.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class QuittanceDePrime implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private int id_q;
	private Date debut_effet;
	private Date fin_effet;
	private int duree_couverture;
	
	@OneToMany(mappedBy="quittance")
	private List<Police>policesP;
	
	@OneToMany(mappedBy="quittanceS")
	private List<Sinistre>sinistresQ;
	
	public QuittanceDePrime() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId_q() {
		return id_q;
	}

	public void setId_q(int id_q) {
		this.id_q = id_q;
	}

	public Date getDebut_effet() {
		return debut_effet;
	}

	public void setDebut_effet(Date debut_effet) {
		this.debut_effet = debut_effet;
	}

	public Date getFin_effet() {
		return fin_effet;
	}

	public void setFin_effet(Date fin_effet) {
		this.fin_effet = fin_effet;
	}

	public int getDuree_couverture() {
		return duree_couverture;
	}

	public void setDuree_couverture(int duree_couverture) {
		this.duree_couverture = duree_couverture;
	}

	public List<Police> getPolicesP() {
		return policesP;
	}

	public void setPolicesP(List<Police> policesP) {
		this.policesP = policesP;
	}

	
	
}
