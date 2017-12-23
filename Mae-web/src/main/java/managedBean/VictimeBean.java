package managedBean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.MaE.Interface.BeneficiaireServiceLocal;
import tn.esprit.MaE.Interface.GestionnaireSinistreServiceLocal;
import tn.esprit.MaE.Interface.SinistreServiceLocal;
import tn.esprit.MaE.Interface.VictimeServiceLocal;
import tn.esprit.MaE.entities.Beneficiaire;
import tn.esprit.MaE.entities.GestionnaireSinistre;
import tn.esprit.MaE.entities.Sinistre;
import tn.esprit.MaE.entities.Victime;

@ManagedBean
@SessionScoped
public class VictimeBean {
	
	@ManagedProperty("#{identityB.identifieduser}")
	private GestionnaireSinistre gestionnaire;
	
	
	@EJB
	VictimeServiceLocal local;
	
	@EJB
	BeneficiaireServiceLocal blocal;
	
	@EJB
	SinistreServiceLocal slocal;
	
	@EJB
	GestionnaireSinistreServiceLocal glocal;
	
	
	
	
	static private  int id_vi;
	static int idgs ;
	// VICTIME
	
	private String cin_v;
	private String nom_v;
	private String prenom_v;
	private String profession;
	private int revenu;
	private Date naissance_v;
	private Date deces;
	private int nb_b;
	static private  int id_s;


	public static int getId_vi() {
		return id_vi;
	}

	public static void setId_vi(int id_vi) {
		VictimeBean.id_vi = id_vi;
	}

	public static double getSmig() {
		return SMIG;
	}



	public GestionnaireSinistre getGestionnaire() {
		return gestionnaire;
	}

	public void setGestionnaire(GestionnaireSinistre gestionnaire) {
		this.gestionnaire = gestionnaire;
	}

	public static int getIdgs() {
		return idgs;
	}

	public static void setIdgs(int idgs) {
		VictimeBean.idgs = idgs;
	}



	private List<Victime>victimesFiltred;
	private List<Victime>victimes=new ArrayList<>();
	private Victime victime=new Victime();
	
	private List<Beneficiaire>beneficiairesFiltred;
	private List<Beneficiaire>beneficiares=new ArrayList<>();
	private Beneficiaire beneficiaire=new Beneficiaire();
	private List<Sinistre>sinistresFiltred;

	private List<Sinistre>sinistres=new ArrayList<>();
	private List<Sinistre>sinistres1=new ArrayList<>();
	private List<Sinistre>sinistresV=new ArrayList<>();
	private Sinistre sinistre=new Sinistre();

	
	
			//BENEF


	private String cinb;
	private String nom;
	private String prenom;
	private Date naissance;
	private Date DatePriseRente;
	private String etat;
	private int nbfamille;
	private int conjoint;
	private float age;
	
	private double PE;
	private double PM;
	private double FF;
	private final static double SMIG = 500;
	
	
	
	
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

	public String getCin_v() {
		return cin_v;
	}

	public void setCin_v(String cin_v) {
		this.cin_v = cin_v;
	}

	public String getNom_v() {
		return nom_v;
	}

	public void setNom_v(String nom_v) {
		this.nom_v = nom_v;
	}

	public String getPrenom_v() {
		return prenom_v;
	}

	public void setPrenom_v(String prenom_v) {
		this.prenom_v = prenom_v;
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

	public Date getNaissance_v() {
		return naissance_v;
	}

	public void setNaissance_v(Date naissance_v) {
		this.naissance_v = naissance_v;
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


	public List<Sinistre> getSinistres1() {
		return sinistres1;
	}

	public void setSinistres1(List<Sinistre> sinistres1) {
		this.sinistres1 = sinistres1;
	}

	public List<Sinistre> getSinistresV() {
		return sinistresV;
	}

	public void setSinistresV(List<Sinistre> sinistresV) {
		this.sinistresV = sinistresV;
	}

	public Sinistre getSinistre() {
		return sinistre;
	}

	public void setSinistre(Sinistre sinistre) {
		this.sinistre = sinistre;
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

	public List<Beneficiaire> getBeneficiairesFiltred() {
		return beneficiairesFiltred;
	}

	public void setBeneficiairesFiltred(List<Beneficiaire> beneficiairesFiltred) {
		this.beneficiairesFiltred = beneficiairesFiltred;
	}

	public List<Beneficiaire> getBeneficiares() {
		return beneficiares;
	}

	public void setBeneficiares(List<Beneficiaire> beneficiares) {
		this.beneficiares = beneficiares;
	}

	
	public Beneficiaire getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(Beneficiaire beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

	public float getAge() {
		return age;
	}

	public void setAge(float age) {
		this.age = age;
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

	
	
	public double getPE() {
		return PE;
	}

	public void setPE(double pE) {
		PE = pE;
	}

	public double getPM() {
		return PM;
	}

	public void setPM(double pM) {
		PM = pM;
	}

	public double getFF() {
		return FF;
	}

	public void setFF(double fF) {
		FF = fF;
	}

	@PostConstruct
	public void init(){
	victime=new Victime();
	victimes=local.findAll();
	
	sinistres1=slocal.findS();
	sinistresV=slocal.findSV();
	
	sinistre=new Sinistre();
	sinistres=slocal.findAll();
	}
	
	
	public String doValidate(Sinistre sinistre){
		 sinistre.setValider(1);
		 slocal.update(sinistre);
		 init();
		 
		 return null;
	 }
	
	public String doAdd(){
		
		local.addVictime(victime);
		
		return null;
		
	}
	
	public String doUpdate1(){
		FacesMessage message;
		slocal.update(sinistre);
		message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Opération effectué avec Succés",null);
		FacesContext.getCurrentInstance().addMessage(null, message);
		init();
		return null;
		
	}
	public String doUpdate(){
		FacesMessage message;
		local.update(victime);
		message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Opération effectué avec Succés",null);
		FacesContext.getCurrentInstance().addMessage(null, message);
		init();
		return null;
		
	}
	
	public String Page_benef(Victime v){
		id_vi=v.getId_v();
		System.out.println(id_vi);
		return "/pages/GestionnaireSinistre/Beneficiaire?faces-redirect=true"; 
	}
	
	public String Page_Lvictime(){
		
		return "/pages/GestionnaireSinistre/ListeVictimes?faces-redirect=true"; 
	}

	public void IdV(Victime v){
		id_vi=v.getId_v();
		System.out.println(id_vi);
		
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
		
		System.out.println("Year B"+" "+YearB);
	age = Year - YearB;
	System.out.println("AGE "+" "+age);
	
		beneficiaire.setAge(age);
	// ******************* FIN AGE ***********************
		
		beneficiaire.setVictime(local.readByid(id_vi));

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
	

	 public String doDelete(Victime victime){
		 local.deleteVictime(victime);
		 init();
		 return null;
	 }
	 
	 public String initialiser(){
		 victime=new Victime();
		 return null;
	 }
	 

	 public void addvictime() {
		 FacesMessage message;
			victime = new Victime();
			victime.setCin_v(cin_v);
			victime.setPrenom(prenom_v);
			victime.setNom(nom_v);
			victime.setNaissance(naissance_v);
			victime.setDeces(deces);
			victime.setNb_b(nb_b);
			victime.setProfession(profession);
			victime.setRevenu(revenu);
			victime.setSinistreV(slocal.RecupereIdSinistre(id_s));
			
			System.out.println(" Id "+" "+" BIENVENUE ");
			//System.out.println("id"+" "+gestionnaire.getId_u());
			 idgs = gestionnaire.getId_u();
				System.out.println(" Id "+" "+" BIENVENUE "+idgs);

			local.ajoutVictime(idgs,id_s ,cin_v, nom_v, prenom_v,profession, naissance_v,  deces,nb_b, revenu) ;
			message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Opération effectué avec Succés",null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			init();
		}
		
	 public String doUpV(){
			FacesMessage message;
			
			local.update(victime);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Opération effectué avec Succés",null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			init();
			return null;
			
		}
		
		 public String doDelete(Sinistre sinistre){
			 slocal.deleteSinistre(sinistre);
			 init();
			 return null;
		 }
		 
		
		 
		 public String Page(Sinistre s){
			 id_s=s.getId();
				System.out.println("gs"+idgs+" ");
				System.out.println(id_s);
			return "/pages/GestionnaireSinistre/Victime?faces-redirect=true"; 
		 }
		 
		 public void IdS(Sinistre s){
			 id_s=s.getId();
			 idgs=gestionnaire.getId_u();
				System.out.println("gs"+idgs+" ");
				System.out.println(id_s);
		 }
	
	 
	
}
