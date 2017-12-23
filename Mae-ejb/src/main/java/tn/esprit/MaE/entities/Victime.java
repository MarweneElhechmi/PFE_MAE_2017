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
public class Victime implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_v;
	private String cin_v;
	private String nom;
	private String prenom;
	private String profession;
	private int revenu;
	private Date naissance;
	private Date deces;
	private int nb_b;
	private int num_sinistre;
	
	@ManyToOne
	private GestionnaireSinistre GestionnaireSinistre;
	
	@OneToMany(mappedBy="victime")
	private List<Beneficiaire>beneficiaires;
	
	@ManyToOne
	private Sinistre sinistreV;
	
	public Victime() {
		super();
	}

	
	public Victime(GestionnaireSinistre gestionnaire,Sinistre sinistre,String cin, String nom2, String prenom2, String profession2, Date naissance2,
			Date deces2, int nb_b2, int revenu2) {
		
		this.cin_v=cin;
		this.nom=nom2;
		this.prenom=prenom2;
		this.profession=profession2;
		this.naissance=naissance2;
		this.deces=deces2;
		this.nb_b=nb_b2;
		this.revenu=revenu2;
		this.GestionnaireSinistre=gestionnaire;
		this.sinistreV=sinistre;
		
		
	}


	public int getId_v() {
		return id_v;
	}


	public void setId_v(int id_v) {
		this.id_v = id_v;
	}


	public String getCin_v() {
		return cin_v;
	}

	public void setCin_v(String cin_v) {
		this.cin_v = cin_v;
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

	public Date getDeces() {
		return deces;
	}

	public void setDeces(Date deces) {
		this.deces = deces;
	}

	public int getNb_b() {
		return nb_b;
	}

	public void setNb_b(int nb_b) {
		this.nb_b = nb_b;
	}
	

	public int getNum_sinistre() {
		return num_sinistre;
	}

	public void setNum_sinistre(int num_sinistre) {
		this.num_sinistre = num_sinistre;
	}

	public GestionnaireSinistre getGestionnaireSinistre() {
		return GestionnaireSinistre;
	}

	public void setGestionnaireSinistre(GestionnaireSinistre gestionnaireSinistre) {
		GestionnaireSinistre = gestionnaireSinistre;
	}

	public List<Beneficiaire> getBeneficiaires() {
		return beneficiaires;
	}

	public void setBeneficiaires(List<Beneficiaire> beneficiaires) {
		this.beneficiaires = beneficiaires;
	}

	public Sinistre getSinistreV() {
		return sinistreV;
	}

	public void setSinistreV(Sinistre sinistreV) {
		this.sinistreV = sinistreV;
	}


	public String getProfession() {
		return profession;
	}


	public void setProfession(String profession) {
		this.profession = profession;
	}


	public int getRevenu() {
		return revenu;
	}


	public void setRevenu(int revenu) {
		this.revenu = revenu;
	}
	
	
	
}
