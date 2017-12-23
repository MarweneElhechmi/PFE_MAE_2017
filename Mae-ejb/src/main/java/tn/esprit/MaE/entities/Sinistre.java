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
public class Sinistre implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_s;
	private int numero;
	private String nom_assure;
	private Date dateSurvenance;
	private Date dateDeclaration;
	private int N_Police;
	private int valider;
	private String etat;
	
	@ManyToOne
	private AgentGeneral agent;

	@OneToMany(mappedBy="sinistreV")
	private List<Victime> victimesS;
	
	@ManyToOne
	private QuittanceDePrime quittanceS;
	
	public Sinistre() {
		super();
	}
	
	
	public Sinistre(int numero, int npolice, int valider) {
		super();
		this.numero = numero;
		this.N_Police = npolice;
		this.valider = valider;
	}


	public Sinistre( AgentGeneral agent,int numero2, String nom_assure2,String etat,Date dateSurvenance, Date dateDeclaration2, int n_Police2) {

	
	this.numero=numero2;
	this.nom_assure=nom_assure2;
	this.etat=etat;
	this.dateSurvenance=dateSurvenance;
	this.dateDeclaration=dateDeclaration2;
	this.N_Police = n_Police2;
	this.agent=agent;
	}


	@Override
	public String toString() {
		return "Sinistre [numero=" + numero + ", dateDeclaration=" + dateDeclaration 
				+ ", valider=" + valider + ", agent=" + agent + ", victimesS=" + victimesS
				+ ", quittanceS=" + quittanceS + "]";
	}


	public int getId() {
		return id_s;
	}
	public void setId(int id) {
		this.id_s = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getDateSurvenance() {
		return dateSurvenance;
	}


	public void setDateSurvenance(Date dateSurvenance) {
		this.dateSurvenance = dateSurvenance;
	}


	public Date getDateDeclaration() {
		return dateDeclaration;
	}


	public void setDateDeclaration(Date dateDeclaration) {
		this.dateDeclaration = dateDeclaration;
	}


	public int getId_s() {
		return id_s;
	}


	public void setId_s(int id_s) {
		this.id_s = id_s;
	}


	public String getNom_assure() {
		return nom_assure;
	}


	public void setNom_assure(String nom_assure) {
		this.nom_assure = nom_assure;
	}


	public int getValider() {
		return valider;
	}
	public void setValider(int valider) {
		this.valider = valider;
	}
	public AgentGeneral getAgent() {
		return agent;
	}
	public void setAgent(AgentGeneral agent) {
		this.agent = agent;
	}
	
	
	public List<Victime> getVictimesS() {
		return victimesS;
	}
	public void setVictimesS(List<Victime> victimesS) {
		this.victimesS = victimesS;
	}
	public QuittanceDePrime getQuittanceS() {
		return quittanceS;
	}
	public void setQuittanceS(QuittanceDePrime quittanceS) {
		this.quittanceS = quittanceS;
	}


	public int getN_Police() {
		return N_Police;
	}


	public void setN_Police(int n_Police) {
		N_Police = n_Police;
	}


	public String getEtat() {
		return etat;
	}


	public void setEtat(String etat) {
		this.etat = etat;
	}

	
}
