package tn.esprit.MaE.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_GestionSinis")
@DiscriminatorValue(value="gestionnaire")
public class GestionnaireSinistre  extends User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="GestionnaireSinistre")
	private List<Victime>victimes;
	
	public GestionnaireSinistre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Victime> getVictimes() {
		return victimes;
	}

	public void setVictimes(List<Victime> victimes) {
		this.victimes = victimes;
	}

	

}
