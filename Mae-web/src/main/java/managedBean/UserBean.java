package managedBean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import tn.esprit.MaE.Interface.BeneficiaireServiceLocal;
import tn.esprit.MaE.Interface.GestionnaireSinistreServiceLocal;
import tn.esprit.MaE.Interface.SinistreServiceLocal;
import tn.esprit.MaE.Interface.VictimeServiceLocal;
import tn.esprit.MaE.entities.Beneficiaire;
import tn.esprit.MaE.entities.Sinistre;
import tn.esprit.MaE.entities.Victime;

@ManagedBean
@ViewScoped
public class UserBean {

	@EJB
	GestionnaireSinistreServiceLocal gssl;
	
	@EJB
	SinistreServiceLocal local;
	
	@EJB
	VictimeServiceLocal vlocal;

	@EJB
	BeneficiaireServiceLocal blocal;

	//BENEF
	private Beneficiaire beneficiaire=new Beneficiaire();

		private String cinb;
		private String nom;
		private String prenom;
		private Date naissance;
		private Date DatePriseRente;
		private String etat;
		private int nbfamille;
		private int conjoint;
		private float age;
		static private  int id_vi;


	private List<Sinistre>sinistresFiltred;

	private List<Sinistre>sinistres=new ArrayList<>();
	private List<Sinistre>sinistres1=new ArrayList<>();
	private List<Sinistre>sinistresV=new ArrayList<>();
	private Sinistre sinistre=new Sinistre();
	
	private List<Victime>victimesFiltred;
	private List<Victime>victimes=new ArrayList<>();
	private Victime victime=new Victime();
	
		
	
		// SINISTRE
	private int numero;
	private String nom_assure;
	private Date dateDeclaration;
	private int N_Police;
	

	
	public Beneficiaire getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(Beneficiaire beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

	public String getCinb() {
		return cinb;
	}

	public void setCinb(String cinb) {
		this.cinb = cinb;
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

	public float getAge() {
		return age;
	}

	public void setAge(float age) {
		this.age = age;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNom_assure() {
		return nom_assure;
	}

	public void setNom_assure(String nom_assure) {
		this.nom_assure = nom_assure;
	}

	

	public Date getDateDeclaration() {
		return dateDeclaration;
	}

	public void setDateDeclaration(Date dateDeclaration) {
		this.dateDeclaration = dateDeclaration;
	}

	public int getN_Police() {
		return N_Police;
	}

	public void setN_Police(int n_Police) {
		N_Police = n_Police;
	}

	public List<Sinistre> getSinistresV() {
		return sinistresV;
	}

	public void setSinistresV(List<Sinistre> sinistresV) {
		this.sinistresV = sinistresV;
	}

	 


	public GestionnaireSinistreServiceLocal getGssl() {
		return gssl;
	}

	public void setGssl(GestionnaireSinistreServiceLocal gssl) {
		this.gssl = gssl;
	}

	public List<Victime> getVictimesFiltred() {
		return victimesFiltred;
	}

	public void setVictimesFiltred(List<Victime> victimesFiltred) {
		this.victimesFiltred = victimesFiltred;
	}

	public List<Victime> getVictimes() {
		return victimes;
	}

	public void setVictimes(List<Victime> victimes) {
		this.victimes = victimes;
	}

	public Victime getVictime() {
		return victime;
	}

	public void setVictime(Victime victime) {
		this.victime = victime;
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

	 

	
	public List<Sinistre> getSinistres1() {
		return sinistres1;
	}

	public void setSinistres1(List<Sinistre> sinistres1) {
		this.sinistres1 = sinistres1;
	}

	public List<Sinistre> getSinistresFiltred() {
		return sinistresFiltred;
	}

	public void setSinistresFiltred(List<Sinistre> sinistresFiltred) {
		this.sinistresFiltred = sinistresFiltred;
	}

	

	public List<Sinistre> getSinistres() {
		return sinistres;
	}

	public void setSinistres(List<Sinistre> sinistres) {
		this.sinistres = sinistres;
	}

	public Sinistre getSinistre() {
		return sinistre;
	}

	public void setSinistre(Sinistre sinistre) {
		this.sinistre = sinistre;
	}

	@PostConstruct
	public void init(){
	sinistre=new Sinistre();
	sinistres=local.findAll();
	sinistres1=local.findS();
	sinistresV=local.findSV();
	 victime=new Victime();
		victimes=vlocal.findAll();
	}
	
	
	 public String doValidate(Sinistre sinistre){
		 sinistre.setValider(1);
		 local.update(sinistre);
		 init();
		 
		 return null;
	 }
	 
	public String doAdd(){
		
		local.addSinistre(sinistre);
		
		return null;
		
	}
	
public String doAdd1(){
		
		local.addSinistre(sinistre);
		
		return null;
		
	}
	
	 
public String doUp(){
	FacesMessage message;
	
	local.update(sinistre);
	message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Opération effectué avec Succés",null);
	FacesContext.getCurrentInstance().addMessage(null, message);
	init();
	return null;
	
}
	
	public String doUpdate(){
		FacesMessage message;
		sinistre = new Sinistre();
		
		sinistre.setNumero(numero);
		sinistre.setNom_assure(nom_assure);
		sinistre.setDateDeclaration(dateDeclaration);
		sinistre.setN_Police(N_Police);
		//local.ajoutSinistre(idag, numero, nom_assure, dateDeclaration, N_Police);
		message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Opération effectué avec Succés",null);
		FacesContext.getCurrentInstance().addMessage(null, message);
		init();
		return null;
		
	}
	
	public void addBeneficiaire() {
		beneficiaire = new Beneficiaire();
		
	

		beneficiaire.setCinb(cinb);
		beneficiaire.setPrenom(prenom);
		beneficiaire.setNom(nom);
		beneficiaire.setNaissance(naissance);
		beneficiaire.setEtat(etat);
		beneficiaire.setNbfamille(nbfamille);
		beneficiaire.setConjoint(conjoint);
		
		// ******************* AGE ***********************
		Calendar cal = Calendar.getInstance();

		int Year = cal.get(Calendar.YEAR);
		int Day = cal.get(Calendar.DATE);
		int Month = cal.get(Calendar.MONTH);
		
		//cal.add(Calendar.MONTH, 1);

		
		
		System.out.println("Current Date Time Year : " + Year);
		System.out.println("Current Date Time Day : " + Day);
		System.out.println("Current Date Time Month : " + cal.getTime());

		
		
		Calendar c = Calendar.getInstance();
		c.setTime(naissance);
		int YearB = c.get(Calendar.YEAR);
		System.out.println("Date Time Benef : " + YearB);
		
		
	age = Year - YearB;
	
		beneficiaire.setAge(age);
	// ******************* FIN AGE ***********************
		
		beneficiaire.setVictime(vlocal.readByid(id_vi));

		System.out.println("gggggg "+beneficiaire.toString());
		System.out.println("bene "+beneficiaire.getEtat());
				
		blocal.ajoutBeneficiaire(id_vi, age, cinb, nom,prenom,naissance,etat, conjoint);
		FacesMessage msg = new FacesMessage("Successful","Une nouvelle sous garantie a été ajoutée");
		//.addToControl("ffsCompanyForm:test", "Billing Address cannot be removed")
		FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
			init();

				}
	
	public void IdV(Victime v){
		id_vi=v.getId_v();
		System.out.println(id_vi);
		
	}
	
	/*
	public void addvictime() {
		victime = new Victime();
		
		victime.setCin_v(cin_v);
		victime.setPrenom(prenom);
		victime.setNom(nom);
		victime.setNaissance(naissance);
		victime.setDeces(deces);
		victime.setNb_b(nb_b);
		victime.setProfession(profession);
		victime.setRevenu(revenu);
		victime.setSinistreV(local.RecupereIdSinistre(id_s));
		vlocal.ajoutVictime(id_s ,cin_v, nom, prenom,profession, naissance,  deces,nb_b, revenu) ;
		init();
	}*/
	
	
	 public String doDelete(Sinistre sinistre){
		 local.deleteSinistre(sinistre);
		 init();
		 return null;
	 }
	 
	 public String doDeleteV(Victime v){
		 vlocal.deleteVictime(v);
		 init();
		 return null;
	 }
	 
	
	 
	
	 
	 }

