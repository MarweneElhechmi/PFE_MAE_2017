package tn.esprit.MaE.entities;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Rente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_rente;
	private int rente ;
	private Date debut;
	private Date fin;
	private Boolean valider;
	private Date DatePriseRente;
	private BigInteger PM;
	private Boolean bool;
	private String etat;
	private String motif;
	private String reouverture;

	
	public Rente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Rente(Beneficiaire beneficiaire, int rente2, Date debut2, Date fin2,String etat) {

		this.beneficiairesR=beneficiaire;
		this.rente=rente2;
		this.debut=debut2;
		this.fin=fin2;
		this.etat=etat;
		
	}
	
	public Rente(Beneficiaire beneficiaire, int rente, Date debut, Date fin,Boolean valider) {

		this.beneficiairesR=beneficiaire;
		this.rente=rente;
		this.debut=debut;
		this.fin=fin;
		this.valider=valider;
	
	}

	public Rente(int renteb) {
		this.rente=renteb;
	}



	public Rente(Beneficiaire beneficiaire, int rente2, BigInteger pM2, Boolean rf2, Date debut2, Date fin2) {
		this.beneficiairesR=beneficiaire;
		this.rente=rente2;
		this.debut=debut2;
		this.fin=fin2;
		this.PM=pM2;
		this.bool=rf2;
	}



	
	public Rente(Beneficiaire beneficiaire, BigInteger pM2, Date debut2, Date fin2, Boolean valid) {
		
		this.beneficiairesR=beneficiaire;
		this.PM=pM2;
		this.debut=debut2;
		this.fin=fin2;
		this.valider=valid;
	}




	@ManyToOne
	private Financier financier;
	
	@ManyToOne
	private Beneficiaire beneficiairesR;

	public int getId_rente() {
		return id_rente;
	}

	public void setId_rente(int id_rente) {
		this.id_rente = id_rente;
	}

	
	
	public Financier getFinancier() {
		return financier;
	}

	public void setFinancier(Financier financier) {
		this.financier = financier;
	}


	public Date getDatePriseRente() {
		return DatePriseRente;
	}

	public void setDatePriseRente(Date datePriseRente) {
		DatePriseRente = datePriseRente;
	}

	

	public Beneficiaire getBeneficiairesR() {
		return beneficiairesR;
	}

	public void setBeneficiairesR(Beneficiaire beneficiairesR) {
		this.beneficiairesR = beneficiairesR;
	}
	
	public String getReouverture() {
		return reouverture;
	}

	public void setReouverture(String reouverture) {
		this.reouverture = reouverture;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Date getDebut() {
		return debut;
	}

	public void setDebut(Date debut) {
		this.debut = debut;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public Boolean getValider() {
		return valider;
	}

	public void setValider(Boolean valider) {
		this.valider = valider;
	}

	public int getRente() {
		return rente;
	}

	public void setRente(int rente) {
		this.rente = rente;
	}

	public BigInteger getPM() {
		return PM;
	}

	public void setPM(BigInteger pM) {
		PM = pM;
	}

	public Boolean getBool() {
		return bool;
	}

	public void setBool(Boolean bool) {
		this.bool = bool;
	}

	
	
	
	
	
}
