package tn.esprit.MaE.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_financier")
@DiscriminatorValue(value="financier")
public class Financier  extends User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="financier")
	private List<Rente>rentes;
	
	public Financier() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Rente> getRentes() {
		return rentes;
	}

	public void setRentes(List<Rente> rentes) {
		this.rentes = rentes;
	}
	
	

}
