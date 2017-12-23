package tn.esprit.MaE.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Beneficiaire implements Serializable{

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_b;
	private String cinb;
	private String nom;
	private String prenom;
	private Date naissance;
	private float Age ;
	private String etat;
	private int nbfamille;
	private int conjoint;
	private double rente;
	
	
	@ManyToOne
	private Victime victime;
	
	@OneToMany(mappedBy="beneficiairesR")
	private List<Rente> renteR;
	
	public Beneficiaire() {
		super();
	}

	

	public Beneficiaire(Victime victime, float age,String cin,String nom,String prenom,Date naissance,String etat, int conjoint) {
		this.Age=age;
		this.cinb=cin;
		this.nom=nom;
		this.prenom=prenom;
		this.naissance=naissance;
		this.etat=etat;
		this.conjoint=conjoint;
		this.victime=victime;
	}



	public String getCinb() {
		return cinb;
	}


	public void setCinb(String cinb) {
		this.cinb = cinb;
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
	



	public float getAge() {
		return Age;
	}



	public void setAge(float age) {
		Age = age;
	}



	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}



	public double getRente() {
		return rente;
	}



	public void setRente(double rente) {
		this.rente = rente;
	}



	public Victime getVictime() {
		return victime;
	}

	public void setVictime(Victime victime) {
		this.victime = victime;
	}

	

	
	
	public List<Rente> getRenteR() {
		return renteR;
	}



	public void setRenteR(List<Rente> renteR) {
		this.renteR = renteR;
	}



	public int getId_b() {
		return id_b;
	}

	public void setId_b(int id_b) {
		this.id_b = id_b;
	}


	public int getNbfamille() {
		return nbfamille;
	}



	public void setNbfamille(int nbfamille) {
		this.nbfamille = nbfamille;
	}



	public int getConjoint() {
		return conjoint;
	}



	public void setConjoint(int conjoint) {
		this.conjoint = conjoint;
	}




	@Override
	public String toString() {
		return "Beneficiaire [Etat=" + etat + ",cin_b=" + cinb + ", etat=" + etat + ", nbf=" + nbfamille + ", conj=" + conjoint + "]";
	}
	
	
	
	
	
}
