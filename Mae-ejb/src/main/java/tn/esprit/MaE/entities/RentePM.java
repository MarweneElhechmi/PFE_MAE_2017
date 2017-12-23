package tn.esprit.MaE.entities;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RentePM {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_rente;
	private float rente ;
	private Date debut;
	private Date fin;
	private Boolean valider;
	private Date DatePriseRente;
	private BigInteger PM;
	private Boolean bool;
	private float age;
	private String etat;
	private String FerOuv ;



	
	public RentePM() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RentePM(Beneficiaire beneficiaire, float rente2, Date debut2, Date fin2) {

		this.beneficiairesR=beneficiaire;
		this.rente=rente2;
		this.debut=debut2;
		this.fin=fin2;
		
	
	}
	
	public RentePM(Beneficiaire beneficiaire, float rente, Date debut, Date fin,Boolean valider) {

		this.beneficiairesR=beneficiaire;
		this.rente=rente;
		this.debut=debut;
		this.fin=fin;
		this.valider=valider;
	
	}

	public RentePM(float renteb) {
		this.rente=renteb;
	}



	public RentePM(Beneficiaire beneficiaire, float rente2,float age, BigInteger pM2, Boolean rf2, Date debut2, Date fin2) {
		this.beneficiairesR=beneficiaire;
		this.rente=rente2;
		this.debut=debut2;
		this.fin=fin2;
		this.age=age;
		this.PM=pM2;
		this.bool=rf2;
	}



	
	public RentePM(Beneficiaire beneficiaire, BigInteger pM2, Date debut2, Date fin2, Boolean valid) {
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

	public float getAge() {
		return age;
	}

	public void setAge(float age) {
		this.age = age;
	}

	public Date getDatePriseRente() {
		return DatePriseRente;
	}

	public void setDatePriseRente(Date datePriseRente) {
		DatePriseRente = datePriseRente;
	}	

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
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

	public String getFerOuv() {
		return FerOuv;
	}

	public void setFerOuv(String ferOuv) {
		FerOuv = ferOuv;
	}

	
}
