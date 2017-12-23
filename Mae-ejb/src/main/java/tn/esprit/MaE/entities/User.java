package tn.esprit.MaE.entities;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Table(name = "t_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "typeD")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_u;
	private String cin;
	private Boolean validé;
	private String nom;
	private String prenom;
	private Date naissance;
	private String telephone;
	private String email;
	private String pwd;
	private static final long serialVersionUID = 1L;
		
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String cin, String nom, String prenom, Date naissance,
			String telephone, String email, String pwd) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = naissance;
		this.telephone = telephone;
		this.email = email;
		this.pwd = pwd;
	}
	public User(String cin, String nom, String prenom,
			String telephone, String email, String pwd) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;
		this.pwd = pwd;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
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
	
	
	public int getId_u() {
		return id_u;
	}
	public void setId_u(int id_u) {
		this.id_u = id_u;
	}
	@Override
	public String toString() {
		return "User [cin=" + cin + ", nom=" + nom + ", prenom=" + prenom
				+ ", naissance=" + naissance + ", telephone=" + telephone
				+ ", email=" + email + ", pwd=" + pwd + "]";
	}
	public Boolean getValidé() {
		return validé;
	}
	public void setValidé(Boolean validé) {
		this.validé = validé;
	}

	
}
