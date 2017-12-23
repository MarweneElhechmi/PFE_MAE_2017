package tn.esprit.MaE.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RenteU {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_rente;
	private float rente ;
	private Date debut;
	private Date fin;
	private Boolean valider;
	private Date DatePriseRente;
	private float PM;
	private Boolean bool;
	private String etat;
	private String motif;

	
	public RenteU() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RenteU(Beneficiaire beneficiaire, float rente2, Date debut2, Date fin2,String etat) {

		this.beneficiairesR=beneficiaire;
		this.rente=rente2;
		this.debut=debut2;
		this.fin=fin2;
		this.etat=etat;
		
	
	}
	
	public RenteU(int idRenteu ,String etat,String motif) {

		this.id_rente=idRenteu;
		this.etat=etat;
		this.motif=motif;
		
	
	}
	
	
	public RenteU(Beneficiaire beneficiaire, float rente, Date debut, Date fin,Boolean valider) {

		this.beneficiairesR=beneficiaire;
		this.rente=rente;
		this.debut=debut;
		this.fin=fin;
		this.valider=valider;
	
	}

	public RenteU(float renteb) {
		this.rente=renteb;
	}



	public RenteU(Beneficiaire beneficiaire, float rente2, float pM2, Boolean rf2, Date debut2, Date fin2) {
		this.beneficiairesR=beneficiaire;
		this.rente=rente2;
		this.debut=debut2;
		this.fin=fin2;
		this.PM=pM2;
		this.bool=rf2;
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
	
	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
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

	public float getRente() {
		return rente;
	}

	public void setRente(float rente) {
		this.rente = rente;
	}

	public float getPM() {
		return PM;
	}

	public void setPM(float pM) {
		PM = pM;
	}

	public Boolean getBool() {
		return bool;
	}

	public void setBool(Boolean bool) {
		this.bool = bool;
	}

	
	
	
	
	
}
