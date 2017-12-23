package tn.esprit.MaE.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="t_admin")
@DiscriminatorValue(value="admin")
public class Admin extends User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Admin(String cin, String nom, String prenom, Date naissance,
			String telephone, String email, String pwd) {
		super(cin, nom, prenom, naissance, telephone, email, pwd);
		// TODO Auto-generated constructor stub
	}
	


	
	
	
}