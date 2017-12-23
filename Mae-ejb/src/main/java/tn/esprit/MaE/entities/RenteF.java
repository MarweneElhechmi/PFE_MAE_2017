package tn.esprit.MaE.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RenteF {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_rente;
	private float rente ;
	private Date debut;
	private Date fin;
	private Boolean valider;
	private Date DatePriseRente;
	private float PM;


	
	public RenteF() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RenteF(Beneficiaire beneficiaire, float rente2, Date debut2, Date fin2) {

		this.beneficiairesR=beneficiaire;
		this.rente=rente2;
		this.debut=debut2;
		this.fin=fin2;
		
	
	}
	
	public RenteF(Beneficiaire beneficiaire, float rente, float PM,Date debut, Date fin,Boolean valider) {

		this.beneficiairesR=beneficiaire;
		this.rente=rente;
		this.PM=PM;
		this.debut=debut;
		this.fin=fin;
		this.valider=valider;
	
	}

	public RenteF(float renteb) {
		this.rente=renteb;
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
	
	
	
}
