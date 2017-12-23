package managedBean;

import java.io.FileOutputStream;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import tn.esprit.MaE.Interface.BeneficiaireServiceLocal;
import tn.esprit.MaE.Interface.CoefficientServiceLocal;
import tn.esprit.MaE.Interface.RenteFServiceLocal;
import tn.esprit.MaE.Interface.RentePMServiceLocal;
import tn.esprit.MaE.Interface.RenteServiceLocal;
import tn.esprit.MaE.Interface.RenteUServiceLocal;
import tn.esprit.MaE.Interface.VictimeServiceLocal;
import tn.esprit.MaE.entities.Beneficiaire;
import tn.esprit.MaE.entities.Coefficient;
import tn.esprit.MaE.entities.Rente;
import tn.esprit.MaE.entities.RenteF;
import tn.esprit.MaE.entities.RentePM;
import tn.esprit.MaE.entities.RenteU;
import tn.esprit.MaE.entities.Victime;

@ManagedBean
@ViewScoped
public class RenteBean {

	
	
	@EJB
	BeneficiaireServiceLocal local;
	
	@EJB
	RenteUServiceLocal rulocal;
	
	@EJB
	RentePMServiceLocal rpmlocal;
	
	@EJB
	RenteServiceLocal rlocal;
	
	@EJB
	RenteFServiceLocal rflocal;
	
	@EJB
	VictimeServiceLocal vlocal;
	
	@EJB
	CoefficientServiceLocal clocal;
	
private Victime victime = new Victime();
private List<Beneficiaire>beneficiairesFiltred;

private List<Beneficiaire>beneficiaires=new ArrayList<>();

private Beneficiaire beneficiaire=new Beneficiaire();

private RenteU renteu=new RenteU();
private RenteF rente1=new RenteF();
private RenteF rentef=new RenteF();




static private  int id_benef;
	
	static private  int id_rente;
	static private  int id_rentef;

	private float age;
	private String motif;
	
	private final static double SMIG = 393248;
	
	private List<Coefficient>coefficientsFiltred;
	private List<Coefficient>coefficients=new ArrayList<>();
	private Coefficient coef = new Coefficient();
	  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd ");
	  static private int rentem;
	
	private List<Rente>rentesFiltred;
	private List<Rente>rentes=new ArrayList<>();
	private List<Rente>rentesTFiltred;
	private static List<Rente>rentesT=new ArrayList<>();
	private List<RentePM>rentesPM=new ArrayList<>();
	private List<RentePM>rentesPMFiltred;
	private List<RentePM>rentesPMT=new ArrayList<>();
	private List<RentePM>rentesPMTFiltred;
	private List<RentePM>rentesPMTotal=new ArrayList<>();
	private List<RentePM>rentesPMTotalFiltred;
	private List<Rente>rentesF=new ArrayList<>();
	private static List<Rente>rentesV=new ArrayList<>();
	private List<Rente>rentesNV=new ArrayList<>();
	private List<RenteF>rentesR=new ArrayList<>();
	private List<Rente>rentesRF=new ArrayList<>();
	private List<Rente>rentesuFiltred;
	private List<Rente>rentesu=new ArrayList<>();
	private List<Rente>rentesRech=new ArrayList<>();
	private List<RenteU>rentesRechFiltred;
	private List<RentePM>rentespm=new ArrayList<>();



	static ArrayList values = new ArrayList();
	
	public List<RentePM> getRentesPMTotal() {
		return rentesPMTotal;
	}

	public void setRentesPMTotal(List<RentePM> rentesPMTotal) {
		this.rentesPMTotal = rentesPMTotal;
	}

	public List<RentePM> getRentesPMTotalFiltred() {
		return rentesPMTotalFiltred;
	}

	public void setRentesPMTotalFiltred(List<RentePM> rentesPMTotalFiltred) {
		this.rentesPMTotalFiltred = rentesPMTotalFiltred;
	}

	public List<RentePM> getRentespm() {
		return rentespm;
	}

	public void setRentespm(List<RentePM> rentespm) {
		this.rentespm = rentespm;
	}

	public List<RenteU> getRentesRechFiltred() {
		return rentesRechFiltred;
	}

	public void setRentesRechFiltred(List<RenteU> rentesRechFiltred) {
		this.rentesRechFiltred = rentesRechFiltred;
	}

	private String cinbr;
	
	private BigInteger renteb ;
	private Date debut;
	private Date fin;
	private Rente rente=new Rente();
	
	private int renteP ;
	private int renteN ;
	private int renteC ;
	private int PM ;
	
	public List<RentePM> getRentesPMT() {
		return rentesPMT;
	}

	public void setRentesPMT(List<RentePM> rentesPMT) {
		this.rentesPMT = rentesPMT;
	}
	
	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	
	
	public int getRentem() {
		return rentem;
	}

	public void setRentem(int rentem) {
		this.rentem = rentem;
	}

	public List<RentePM> getRentesPMTFiltred() {
		return rentesPMTFiltred;
	}

	public void setRentesPMTFiltred(List<RentePM> rentesPMTFiltred) {
		this.rentesPMTFiltred = rentesPMTFiltred;
	}
	
	

	public String getCinbr() {
		return cinbr;
	}

	public void setCinbr(String cinbr) {
		this.cinbr = cinbr;
	}

	public List<Rente> getRentesRech() {
		return rentesRech;
	}

	public void setRentesRech(List<Rente> rentesRech) {
		this.rentesRech = rentesRech;
	}

	public List<Rente> getRentesTFiltred() {
		return rentesTFiltred;
	}

	public void setRentesTFiltred(List<Rente> rentesTFiltred) {
		this.rentesTFiltred = rentesTFiltred;
	}

	public List<Rente> getRentesT() {
		return rentesT;
	}

	public void setRentesT(List<Rente> rentesT) {
		this.rentesT = rentesT;
	}

	public List<RentePM> getRentesPMFiltred() {
		return rentesPMFiltred;
	}

	public void setRentesPMFiltred(List<RentePM> rentesPMFiltred) {
		this.rentesPMFiltred = rentesPMFiltred;
	}

	public List<RentePM> getRentesPM() {
		return rentesPM;
	}

	public void setRentesPM(List<RentePM> rentesPM) {
		this.rentesPM = rentesPM;
	}

	public float getAge() {
		return age;
	}

	public void setAge(float age) {
		this.age = age;
	}

	public RenteU getRenteu() {
		return renteu;
	}

	public void setRenteu(RenteU renteu) {
		this.renteu = renteu;
	}

	public List<Rente> getRentesRF() {
		return rentesRF;
	}

	public void setRentesRF(List<Rente> rentesRF) {
		this.rentesRF = rentesRF;
	}

	public RenteF getRente1() {
		return rente1;
	}

	public void setRente1(RenteF rente1) {
		this.rente1 = rente1;
	}

	public RenteF getRentef() {
		return rentef;
	}

	public void setRentef(RenteF rentef) {
		this.rentef = rentef;
	}



	public List<RenteF> getRentesR() {
		return rentesR;
	}

	public void setRentesR(List<RenteF> rentesR) {
		this.rentesR = rentesR;
	}

	

	public List<Rente> getRentesuFiltred() {
		return rentesuFiltred;
	}

	public void setRentesuFiltred(List<Rente> rentesuFiltred) {
		this.rentesuFiltred = rentesuFiltred;
	}

	public List<Rente> getRentesu() {
		return rentesu;
	}

	public void setRentesu(List<Rente> rentesu) {
		this.rentesu = rentesu;
	}

	public List<Rente> getRentesV() {
		return rentesV;
	}

	public void setRentesV(List<Rente> rentesV) {
		this.rentesV = rentesV;
	}

	public List<Rente> getRentesNV() {
		return rentesNV;
	}

	public void setRentesNV(List<Rente> rentesNV) {
		this.rentesNV = rentesNV;
	}

	

	public BigInteger getRenteb() {
		return renteb;
	}

	public void setRenteb(BigInteger renteb) {
		this.renteb = renteb;
	}

	public int getRenteP() {
		return renteP;
	}

	public void setRenteP(int renteP) {
		this.renteP = renteP;
	}

	public int getRenteN() {
		return renteN;
	}

	public void setRenteN(int renteN) {
		this.renteN = renteN;
	}

	public int getRenteC() {
		return renteC;
	}

	public void setRenteC(int renteC) {
		this.renteC = renteC;
	}

	public int getPM() {
		return PM;
	}

	public void setPM(int pM) {
		PM = pM;
	}

	public List<Rente> getRentesFiltred() {
		return rentesFiltred;
	}

	public void setRentesFiltred(List<Rente> rentesFiltred) {
		this.rentesFiltred = rentesFiltred;
	}

	public List<Rente> getRentes() {
		return rentes;
	}

	public void setRentes(List<Rente> rentes) {
		this.rentes = rentes;
	}

	public Rente getRente() {
		return rente;
	}

	public List<Rente> getRentesF() {
		return rentesF;
	}

	public void setRentesF(List<Rente> rentesF) {
		this.rentesF = rentesF;
	}

	public void setRente(Rente rente) {
		this.rente = rente;
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

	public List<Beneficiaire> getBeneficiaires() {
		return beneficiaires;
	}

	public void setBeneficiaires(List<Beneficiaire> beneficiaires) {
		this.beneficiaires = beneficiaires;
	}

	public Beneficiaire getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(Beneficiaire beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

	public List<Coefficient> getCoefficientsFiltred() {
		return coefficientsFiltred;
	}

	public void setCoefficientsFiltred(List<Coefficient> coefficientsFiltred) {
		this.coefficientsFiltred = coefficientsFiltred;
	}

	public List<Coefficient> getCoefficients() {
		return coefficients;
	}

	public void setCoefficients(List<Coefficient> coefficients) {
		this.coefficients = coefficients;
	}

	public Coefficient getCoef() {
		return coef;
	}

	public void setCoef(Coefficient coef) {
		this.coef = coef;
	}

	@PostConstruct
	public void init(){
	rente=new Rente();
	rentes=rlocal.findAll();
	
	
	rentesT=rlocal.findAllT();
	rentesPMTotal=rpmlocal.findAllTotal();
	
	rentesPM=rpmlocal.findAll();
	//rentesPMT=rpmlocal.findAllT();
	//rentesu=rlocal.findDossier();
	rentesF=rlocal.findF();
	rentesNV=rlocal.findRNV();
	rentesR=rflocal.findR();
	rentesRF=rlocal.findRF();
	
 
	}
	
	public String doValidate(Rente rente){
		 rente.setValider(true);
		 rlocal.update(rente);
		 init();
		 
		 return null;
	 }
	
	public String doUp(Rente r){
		FacesMessage message;
		r.setValider(true);
		Calendar cal = Calendar.getInstance();
		r.setDatePriseRente(cal.getTime());
		
		rlocal.update(r);
		//rflocal.ajoutRenteFP(rente.getBeneficiairesR().getId_b(), rente.getRente(),rente.getPM(), rente.getDebut(), rente.getFin(),rente.getValider());
		message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Opération effectué avec Succés",null);
		FacesContext.getCurrentInstance().addMessage(null, message);
		init();
		return null;
		
	}
	
	public String doRefus(Rente r){
		FacesMessage message;
		
		r.setValider(false);
		Calendar cal = Calendar.getInstance();
		r.setDatePriseRente(cal.getTime());
		rlocal.update(r);
		//rflocal.ajoutRenteFP(r.getBeneficiairesR().getId_b(), r.getRente(),r.getPM(), r.getDebut(), r.getFin(),r.getValider());

		message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Opération effectué avec Succés",null);
		FacesContext.getCurrentInstance().addMessage(null, message);
		init();
		return null;
		
	}
	
public String Page_Terminer(){
		
		return "/pages/GestionnaireSinistre/ListePMTotal2?faces-redirect=true"; 
	}

public String Page_Fin(){
	
	return "/pages/GestionnaireSinistre/ListeSinistre?faces-redirect=true"; 
}


public String Page_PM(){
	
	return "/pages/GestionnaireSinistre/PM?faces-redirect=true"; 
}

	
	public String doAdd(){
		
		rlocal.addRente(rente);
		
		return null;
		
	}
	
	public String doUpdate(){
		FacesMessage message;
		
		rlocal.update(rente);
		message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Opération effectué avec Succés",null);
		FacesContext.getCurrentInstance().addMessage(null, message);
		init();
		return null;
		
	}
	 public String doDelete(Rente rente){
		 rlocal.deleteRente(rente);
		 init();
		 return null;
	 }
	 
	 public String doDeleteF(RenteU renteu){
		 rulocal.deleteRenteU(renteu);
		 init();
		 return null;
	 }
	 
	 public String Fermeture(){
		 
		 System.out.println(" haaaFer "+renteu.getId_rente());
			renteu = rulocal.readByidu(id_rente);
			renteu.setEtat("FERME");
			renteu.setMotif(motif);
			renteu.setBeneficiairesR(renteu.getBeneficiairesR());
			renteu.setRente(renteu.getRente());
			
			
			//rentesV=rlocal.findRVide(renteu.getBeneficiairesR().getId_b());
			System.out.println(rentesV.toString());
			System.out.println(rentesV.size());
			System.out.println("rentteess"+" "+rentes);
			System.out.println("DEBUT");
			//System.out.println("chii"+" "+rentesV.remove(2));
			rentesT=rentesV;
			rentesT.clear();
			System.out.println("Rente Total"+" "+rentesT);
			System.out.println("hae"+" "+ rentesV.toString());
			
			
			values.clear();
			
			//Iterator<Rente> it = rentesV.iterator();
			/*for(int i=0;i<rentesV.size();i++){
				values.add(rentesV.get(i));
				System.out.println(rentesV.remove(i));


				//rlocal.deleteRente(rentesV.get(i));
				//rentesV.remove(i);
 			}
			/*for(int i=0;i<values.size() ;i++){
			System.out.println("valeur"+" "+values.get(i));
			}
			/*while (it.hasNext()) {
				rlocal.deleteRente(rlocal.selectRenteBenef(renteu.getBeneficiairesR().getId_b()));
				it.next();
			}*/
			System.out.println("FINISH");
			init();
 			//rulocal.updateR(id_rente,"FERME",motif);
			rulocal.update(renteu);
			return null;
	 }
	 
	 public void updateR(){
		 for(Rente f : rentesRech ){
				beneficiaire = local.readByid(f.getBeneficiairesR().getId_b());
				System.out.println(f.getId_rente());
				f.setBeneficiairesR(local.readByid(f.getBeneficiairesR().getId_b()));
				f.setRente(rentem);
				rlocal.update(f);

				
		 }
		 
		 FacesMessage msg = new FacesMessage("Successful ! Modifier Provision Mathématique","Rente Modifiée");
			//.addToControl("ffsCompanyForm:test", "Billing Address cannot be removed")
			FacesContext.getCurrentInstance().addMessage(null, msg);
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getFlash().setKeepMessages(true);
				init();
		 
	 }
	/* public void addRenteNew() {
		 
		 	System.out.println(" haaa "+renteu.getId_rente());
			renteu = rulocal.readByidu(id_rente);
			renteu.getBeneficiairesR();
			//beneficiaire = local.readByid(id_benef);
			
			System.out.println("benef"+renteu.getBeneficiairesR().getEtat());
			
	/* Calcul JIRAYA 
			
														//	PERE
			
			if(renteu.getBeneficiairesR().getEtat().equals("Pere") ) 
			{
				Calendar cal = Calendar.getInstance();
				Calendar calF = Calendar.getInstance();

				int Year = cal.get(Calendar.YEAR);
				int Day = cal.get(Calendar.DATE);
				int Month = cal.get(Calendar.MONTH);
				int Monthf = calF.get(Calendar.MONTH);
				
				//cal.add(Calendar.MONTH, 1);
				calF.add(Calendar.MONTH, 1);

				
				
				System.out.println("Current Date Time Year : " + Year);
				System.out.println("Current Date Time Day : " + Day);
				System.out.println("Current Date Time Month : " + cal.getTime());
				System.out.println("Current Date Time Month FIN : " + calF.getTime());

				
				
				Calendar c = Calendar.getInstance();
				c.setTime(renteu.getBeneficiairesR().getNaissance());
				int YearB = c.get(Calendar.YEAR);
				System.out.println("Date Time Benef : " + YearB);
				
				
			age = Year - YearB;
			
			renteu.getBeneficiairesR().setAge(age);
			System.out.println("aaaaage"+" "+age);
			System.out.println("age"+" "+renteu.getBeneficiairesR().getAge());
				
			while(age<100 || renteu.getBeneficiairesR().getNaissance().getMonth()!=calF.getTime().getMonth()){
				int YearR = cal.get(Calendar.YEAR);
				System.out.println("AGE REGLO"+" "+calF.getTime().getYear());
				System.out.println("AGE REGLO 1 "+" "+ YearR);
		
				age = YearR - YearB;
				System.out.println("aaaaage jdid"+" "+age);
				System.out.println("age jdiddd"+" "+renteu.getBeneficiairesR().getAge());
				
				System.out.println("AGE"+" " +renteu.getBeneficiairesR().getAge());
				renteb = renteC ;
				renteu.setPM(renteb);
				 renteu.setRente(renteb);
				 rulocal.update(renteu);
				rlocal.ajoutRentePN(renteu.getBeneficiairesR().getId_b(), renteu.getRente(), renteu.getPM(), true, cal.getTime(), calF.getTime());

				 
				//*****************DATE DEBUT***********************
					
					cal.add(Calendar.MONTH, 1);
					System.out.println("MOIS DEBUT " +cal.getTime().getMonth());

						
					//******************DATE FIN***********************
					
					calF.add(Calendar.MONTH, 1);

					System.out.println("MOIS FIN " +calF.getTime().getMonth());

					 
					//***********************************************
			}
			
			
			}
														// MERE
			
				else if (renteu.getBeneficiairesR().getEtat().equals("Mere") ) {
				
					Calendar cal = Calendar.getInstance();
					Calendar calF = Calendar.getInstance();

					int Year = cal.get(Calendar.YEAR);
					int Day = cal.get(Calendar.DATE);
					int Month = cal.get(Calendar.MONTH);
					int Monthf = calF.get(Calendar.MONTH);
					
					//cal.add(Calendar.MONTH, 1);
					calF.add(Calendar.MONTH, 1);

					
					
					System.out.println("Current Date Time Year : " + Year);
					System.out.println("Current Date Time Day : " + Day);
					System.out.println("Current Date Time Month : " + cal.getTime());
					System.out.println("Current Date Time Month FIN : " + calF.getTime());

					
					
					Calendar c = Calendar.getInstance();
					c.setTime(renteu.getBeneficiairesR().getNaissance());
					int YearB = c.get(Calendar.YEAR);
					System.out.println("Date Time Benef : " + YearB);
					
					
				age = Year - YearB;
				
				renteu.getBeneficiairesR().setAge(age);
				System.out.println("aaaaage"+" "+age);
				System.out.println("age"+" "+renteu.getBeneficiairesR().getAge());
					
				while(age<100 || renteu.getBeneficiairesR().getNaissance().getMonth()!=calF.getTime().getMonth()){
					int YearR = cal.get(Calendar.YEAR);
					System.out.println("AGE REGLO"+" "+calF.getTime().getYear());
					System.out.println("AGE REGLO 1 "+" "+ YearR);
			
					age = YearR - YearB;
					System.out.println("aaaaage jdid"+" "+age);
					System.out.println("age jdiddd"+" "+renteu.getBeneficiairesR().getAge());
					
					
				renteb = renteC ;
				renteu.setPM(renteb);
				 renteu.setRente(renteb);
				 rulocal.update(renteu);
					rlocal.ajoutRentePN(renteu.getBeneficiairesR().getId_b(), renteu.getRente(), renteu.getPM(), true, cal.getTime(), calF.getTime());

				 
				//*****************DATE DEBUT***********************
					
					cal.add(Calendar.MONTH, 1);
					System.out.println("MOIS DEBUT " +cal.getTime().getMonth());

						
					//******************DATE FIN***********************
					
					calF.add(Calendar.MONTH, 1);

					System.out.println("MOIS FIN " +calF.getTime().getMonth());

					 
					//***********************************************
					
				 } 
				}
				
								
														// Veuve
				
					else if (renteu.getBeneficiairesR().getEtat().equals("Veuve") ) {
				
						Calendar cal = Calendar.getInstance();
						Calendar calF = Calendar.getInstance();

						int Year = cal.get(Calendar.YEAR);
						int Day = cal.get(Calendar.DATE);
						int Month = cal.get(Calendar.MONTH);
						int Monthf = calF.get(Calendar.MONTH);
						
						//cal.add(Calendar.MONTH, 1);
						calF.add(Calendar.MONTH, 1);

						
						
						System.out.println("Current Date Time Year : " + Year);
						System.out.println("Current Date Time Day : " + Day);
						System.out.println("Current Date Time Month : " + cal.getTime());
						System.out.println("Current Date Time Month FIN : " + calF.getTime());

						
						
						Calendar c = Calendar.getInstance();
						c.setTime(renteu.getBeneficiairesR().getNaissance());
						int YearB = c.get(Calendar.YEAR);
						System.out.println("Date Time Benef : " + YearB);
						
						
					age = Year - YearB;
					
					renteu.getBeneficiairesR().setAge(age);
					System.out.println("aaaaage"+" "+age);
					System.out.println("age"+" "+renteu.getBeneficiairesR().getAge());
						
					while(age<100 || renteu.getBeneficiairesR().getNaissance().getMonth()!=calF.getTime().getMonth()){
						int YearR = cal.get(Calendar.YEAR);
						System.out.println("AGE REGLO"+" "+calF.getTime().getYear());
						System.out.println("AGE REGLO 1 "+" "+ YearR);
				
						age = YearR - YearB;
						System.out.println("aaaaage jdid"+" "+age);
						System.out.println("age jdiddd"+" "+renteu.getBeneficiairesR().getAge());
						
				if (local.calculBenefF(renteu.getBeneficiairesR().getVictime().getId_v())>1 ) {
				
				renteb = renteC   ;
				renteu.setPM(renteb);

				renteu.setRente(renteb);
				}
				else {
					
					renteb = renteC ;
					renteu.setPM(renteb);

					renteu.setRente(renteb);
				}
				rulocal.update(renteu);
				rlocal.ajoutRentePN(renteu.getBeneficiairesR().getId_b(), renteu.getRente(), renteu.getPM(), true, cal.getTime(), calF.getTime());

				
				//*****************DATE DEBUT***********************
				
				cal.add(Calendar.MONTH, 1);
				System.out.println("MOIS DEBUT " +cal.getTime().getMonth());

					
				//******************DATE FIN***********************
				
				calF.add(Calendar.MONTH, 1);

				System.out.println("MOIS FIN " +calF.getTime().getMonth());

				 
				//***********************************************
				
				}
					}
														
														// Fils
					
					
					else if (renteu.getBeneficiairesR().getEtat().equals("Fils") ) {
						Calendar cal = Calendar.getInstance();
						Calendar calF = Calendar.getInstance();

						int Year = cal.get(Calendar.YEAR);
						int Day = cal.get(Calendar.DATE);
						int Month = cal.get(Calendar.MONTH);
						int Monthf = calF.get(Calendar.MONTH);
						
						//cal.add(Calendar.MONTH, 1);
						calF.add(Calendar.MONTH, 1);

						
						
						System.out.println("Current Date Time Year : " + Year);
						System.out.println("Current Date Time Day : " + Day);
						System.out.println("Current Date Time Month : " + cal.getTime());
						System.out.println("Current Date Time Month FIN : " + calF.getTime());

						
						
						Calendar c = Calendar.getInstance();
						c.setTime(renteu.getBeneficiairesR().getNaissance());
						int YearB = c.get(Calendar.YEAR);
						System.out.println("Date Time Benef : " + YearB);
						
						
					age = Year - YearB;
					
					renteu.getBeneficiairesR().setAge(age);
					System.out.println("aaaaage"+" "+age);
					System.out.println("age"+" "+renteu.getBeneficiairesR().getAge());
						if(age<25){
					while(age<25 || renteu.getBeneficiairesR().getNaissance().getMonth()!=calF.getTime().getMonth()){
						int YearR = cal.get(Calendar.YEAR);
						System.out.println("AGE REGLO"+" "+calF.getTime().getYear());
						System.out.println("AGE REGLO 1 "+" "+ YearR);
				
						age = YearR - YearB;
						System.out.println("aaaaage jdid"+" "+age);
						System.out.println("age jdiddd"+" "+renteu.getBeneficiairesR().getAge());
						
					if (renteu.getBeneficiairesR().getConjoint()==1  ) {
					
						if (local.calculBenefF(renteu.getBeneficiairesR().getVictime().getId_v())>1 ) {
					renteb = renteC  ;
					renteu.setPM(renteb);

					renteu.setRente(renteb);
					} 
					}else if (renteu.getBeneficiairesR().getConjoint()==0  ) {
					
						if (local.calculBenefF(renteu.getBeneficiairesR().getVictime().getId_v())>1 ) {
							renteb = renteC ;
							renteu.setPM(renteb);

							renteu.setRente(renteb);
					
					}
					}
					
					rulocal.update(renteu);
					rlocal.ajoutRentePN(renteu.getBeneficiairesR().getId_b(), renteu.getRente(), renteu.getPM(), true, cal.getTime(), calF.getTime());

					
					//*****************DATE DEBUT***********************
					
					cal.add(Calendar.MONTH, 1);
					System.out.println("MOIS DEBUT " +cal.getTime().getMonth());

						
					//******************DATE FIN***********************
					
					calF.add(Calendar.MONTH, 1);

					System.out.println("MOIS FIN " +calF.getTime().getMonth());

					 
					//***********************************************
					
				}
						}
						
						rulocal.update(renteu);

					}
			
			
															
														// Fille
			
			
			
					else if (renteu.getBeneficiairesR().getEtat().equals("Fille") ) {
						Calendar cal = Calendar.getInstance();
						Calendar calF = Calendar.getInstance();

						int Year = cal.get(Calendar.YEAR);
						int Day = cal.get(Calendar.DATE);
						int Month = cal.get(Calendar.MONTH);
						int Monthf = calF.get(Calendar.MONTH);
						
						//cal.add(Calendar.MONTH, 1);
						calF.add(Calendar.MONTH, 1);

						
						
						System.out.println("Current Date Time Year : " + Year);
						System.out.println("Current Date Time Day : " + Day);
						System.out.println("Current Date Time Month : " + cal.getTime());
						System.out.println("Current Date Time Month FIN : " + calF.getTime());

						
						
						Calendar c = Calendar.getInstance();
						c.setTime(renteu.getBeneficiairesR().getNaissance());
						int YearB = c.get(Calendar.YEAR);
						System.out.println("Date Time Benef : " + YearB);
						
						
					age = Year - YearB;
					
					renteu.getBeneficiairesR().setAge(age);
					System.out.println("aaaaage"+" "+age);
					System.out.println("age"+" "+renteu.getBeneficiairesR().getAge());
						
					if(age<25){
					while(age<25 || renteu.getBeneficiairesR().getNaissance().getMonth()!=calF.getTime().getMonth()){
						
						int YearR = cal.get(Calendar.YEAR);
						System.out.println("AGE REGLO"+" "+calF.getTime().getYear());
						System.out.println("AGE REGLO 1 "+" "+ YearR);
				
						age = YearR - YearB;
						System.out.println("aaaaage jdid"+" "+age);
						System.out.println("age jdiddd"+" "+renteu.getBeneficiairesR().getAge());
						
					
					if (renteu.getBeneficiairesR().getConjoint()==1  ) {
						
							if (local.calculBenefF(renteu.getBeneficiairesR().getVictime().getId_v())>1 ) {
								renteb = renteC  ;
								renteu.setPM(renteb);

								renteu.setRente(renteb);
						} 
						}
					rulocal.update(renteu);
					rlocal.ajoutRentePN(renteu.getBeneficiairesR().getId_b(), renteu.getRente(), renteu.getPM(), true, cal.getTime(), calF.getTime());

					
					//*****************DATE DEBUT***********************
					
					cal.add(Calendar.MONTH, 1);
					System.out.println("MOIS DEBUT " +cal.getTime().getMonth());

						
					//******************DATE FIN***********************
					
					calF.add(Calendar.MONTH, 1);

					System.out.println("MOIS FIN " +calF.getTime().getMonth());

					 
					//***********************************************
					
					}
					}
					rulocal.update(renteu);
					}
				
					
			
			/* FIN CALCUL JIRAYA 
		
			
			
			
			FacesMessage msg = new FacesMessage("Rente modifiée et validée avec succés ! "," Succés");
			//.addToControl("ffsCompanyForm:test", "Billing Address cannot be removed")
			FacesContext.getCurrentInstance().addMessage(null, msg);
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getFlash().setKeepMessages(true);
				init();
					}
	 
	 
	 public void addRenteNEW() {
			rente = new Rente();
			rente1 = rflocal.readByid(id_rentef);
			System.out.println("Idbenef"+"  "+rente1.getBeneficiairesR().getId_b());
			System.out.println("RENTE BENEF"+" " +rulocal.getRenteU(rente1.getBeneficiairesR().getId_b()));
			//System.out.println("RENTE BENEF RENTE U"+" " +local.RecupereRente(rente1.getBeneficiairesR().getId_b()));
			//System.out.println("RENTE BENEF"+" " +local.RecupereRente(rente1.getBeneficiairesR().getId_b()));
			beneficiaire = local.readByid(rente1.getBeneficiairesR().getId_b());
			rente.setBeneficiairesR(local.readByid(rente1.getBeneficiairesR().getId_b()));
			rente.setDebut(debut);
			rente.setFin(fin);
			renteN = renteC;
			renteP= PM;
			System.out.println("RENTE BENEF"+" " +renteP+" "+renteN);
			System.out.println("ID BENEF"+" " +rente1.getBeneficiairesR().getId_b());
			
			System.out.println("benef"+beneficiaire.getEtat());
			
	/* Calcul JIRAYA 
			
														//	PERE
			
			if(beneficiaire.getEtat().equals("Pere") ) 
			{
				System.out.println("AGE"+" " +beneficiaire.getAge());
				//System.out.println("RENTE BENEF"+" " +local.RecupereRente(rente1.getBeneficiairesR().getId_b()));
				
				 rente.setRente(renteN);

				 rente.setPM(renteP);
					rente.setBool(true);

			} 
				
														// MERE
			
				else if (beneficiaire.getEtat().equals("Mere") ) {
				
					rente.setRente(renteN);

					 rente.setPM(renteP);
				 } 
				
				
								
														// Veuve
				
					else if (beneficiaire.getEtat().equals("Veuve") ) {
				
				if (local.calculBenefF(beneficiaire.getVictime().getId_v())==1 || local.calculBenefF(beneficiaire.getVictime().getId_v())==2 || local.calculBenefF(beneficiaire.getVictime().getId_v())==3 || local.calculBenefF(beneficiaire.getVictime().getId_v())==4  ) {
				
					rente.setRente(renteN);

					 rente.setPM(renteP);
				}
				else {
					
					rente.setRente(renteN);

					 rente.setPM(renteP);
				}
				}
														
														// Fils
					
					
					else if (beneficiaire.getEtat().equals("Fils") ) {
					
					if (beneficiaire.getConjoint()==1  ) {
					
						if (local.calculBenefF(beneficiaire.getVictime().getId_v())==1 ) {
							rente.setRente(renteN);

							 rente.setPM(renteP);
					} else if (local.calculBenefF(beneficiaire.getVictime().getId_v())==2 ){
					
						rente.setRente(renteN);

						 rente.setPM(renteP);
					}else if (local.calculBenefF(beneficiaire.getVictime().getId_v())==3 ){
						
						rente.setRente(renteN);

						 rente.setPM(renteP);
						}
					}else if (beneficiaire.getConjoint()==0  ) {
					
						if (local.calculBenefF(beneficiaire.getVictime().getId_v())==1 ) {
							rente.setRente(renteN);

							 rente.setPM(renteP);
					
					} else if (local.calculBenefF(beneficiaire.getVictime().getId_v())==2 ){
					
						rente.setRente(renteN);

						 rente.setPM(renteP);
					}else if (local.calculBenefF(beneficiaire.getVictime().getId_v())==3 ){
						
						rente.setRente(renteN);

						 rente.setPM(renteP);
						}else if (local.calculBenefF(beneficiaire.getVictime().getId_v())==4 ){
							
							rente.setRente(renteN);

							 rente.setPM(renteP);
							}
					}
				}
			
			
															
														// Fille
			
			
			
					else if (beneficiaire.getEtat().equals("Fille") ) {
						
						if (beneficiaire.getConjoint()==1  ) {
						
							if (local.calculBenefF(beneficiaire.getVictime().getId_v())==1 ) {
								rente.setRente(renteN);

								 rente.setPM(renteP);
						} else if (local.calculBenefF(beneficiaire.getVictime().getId_v())==2 ){
						
							rente.setRente(renteN);

							 rente.setPM(renteP);
						}else if (local.calculBenefF(beneficiaire.getVictime().getId_v())==3 ){
							
							rente.setRente(renteN);

							 rente.setPM(renteP);
							}
						}else if (beneficiaire.getConjoint()==0  ) {
						
							if (local.calculBenefF(beneficiaire.getVictime().getId_v())==1 ) {
								rente.setRente(renteN);

								 rente.setPM(renteP);
						
						} else if (local.calculBenefF(beneficiaire.getVictime().getId_v())==2 ){
						
							rente.setRente(renteN);

							 rente.setPM(renteP);
						}else if (local.calculBenefF(beneficiaire.getVictime().getId_v())==3 ){
							
							rente.setRente(renteN);

							 rente.setPM(renteP);
							}else if (local.calculBenefF(beneficiaire.getVictime().getId_v())==4 ){
								
								rente.setRente(renteN);

								 rente.setPM(renteP);
								}
						}
					}
					
				
					
			
			/* FIN CALCUL JIRAYA 
		
			System.out.println("Rente"+renteb);
			System.out.println("Id Victime"+beneficiaire.getVictime().getId_v());
			System.out.println("Revenu"+vlocal.getRevenuAnnu(beneficiaire.getVictime().getId_v()));
			System.out.println("nbbenfParents"+local.calculBenefP(beneficiaire.getVictime().getId_v()));
			System.out.println("nbbenfFils"+local.calculBenefF(beneficiaire.getVictime().getId_v()));
			rlocal.ajoutRentePN(rente1.getBeneficiairesR().getId_b(), renteN,renteP ,true,debut, fin);
			rflocal.deleteRenteF(rente1);
			
			FacesMessage msg = new FacesMessage("Successful","Une nouvelle sous garantie a été ajoutée");
			//.addToControl("ffsCompanyForm:test", "Billing Address cannot be removed")
			FacesContext.getCurrentInstance().addMessage(null, msg);
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getFlash().setKeepMessages(true);
				init();

					}
		
		
	 
	 
	 public void addRentePM() {
		 
			renteu = rulocal.readByidu(id_rente);
			renteu.getBeneficiairesR();
			//beneficiaire = local.readByid(id_benef);
			
			System.out.println("benef"+renteu.getBeneficiairesR().getEtat());
			
	/* Calcul JIRAYA 
			
														//	PERE
			
			if(renteu.getBeneficiairesR().getEtat().equals("Pere") ) 
			{
				Calendar cal = Calendar.getInstance();
				Calendar calF = Calendar.getInstance();

				int Year = cal.get(Calendar.YEAR);
				int Day = cal.get(Calendar.DATE);
				int Month = cal.get(Calendar.MONTH);
				int Monthf = calF.get(Calendar.MONTH);
				
				//cal.add(Calendar.MONTH, 1);
				calF.add(Calendar.MONTH, 1);

				
				
				System.out.println("Current Date Time Year : " + Year);
				System.out.println("Current Date Time Day : " + Day);
				System.out.println("Current Date Time Month : " + cal.getTime());
				System.out.println("Current Date Time Month FIN : " + calF.getTime());

				
				
				Calendar c = Calendar.getInstance();
				c.setTime(renteu.getBeneficiairesR().getNaissance());
				int YearB = c.get(Calendar.YEAR);
				System.out.println("Date Time Benef : " + YearB);
				
				
			age = Year - YearB;
			
			renteu.getBeneficiairesR().setAge(age);
			System.out.println("aaaaage"+" "+age);
			System.out.println("age"+" "+renteu.getBeneficiairesR().getAge());
				
			
				System.out.println("AGE"+" " +renteu.getBeneficiairesR().getAge());
				
				while(age<100 ){
					
					int YearR = cal.get(Calendar.YEAR);
					 
					System.out.println("AGE REGLO"+" "+calF.getTime().getYear());
					System.out.println("AGE REGLO 1 "+" "+ YearR);
					 



					age = YearR - YearB;
					System.out.println("aaaaage jdid"+" "+age);
					System.out.println("age jdiddd"+" "+renteu.getBeneficiairesR().getAge());
					
				renteb = renteC *(clocal.getCoefP(age))*12  ;
				
				renteu.setPM(renteb);
				
				rulocal.update(renteu);
				rpmlocal.ajoutRentePMPN(renteu.getBeneficiairesR().getId_b(), renteu.getRente(), renteu.getPM(), true,  cal.getTime(), calF.getTime());
				
				//*****************ANNEE SUIVANTE***********************
				
				cal.add(Calendar.YEAR, 1);
				System.out.println("YEAR NEXT " +cal.getTime().getYear());
				System.out.println("YEAR NEXT 11" +" " +cal.get(Calendar.YEAR));


				 
				//***********************************************
			} 
				
			}
				
														// MERE
			
				else if (renteu.getBeneficiairesR().getEtat().equals("Mere") ) {
				
					Calendar cal = Calendar.getInstance();
					Calendar calF = Calendar.getInstance();

					int Year = cal.get(Calendar.YEAR);
					int Day = cal.get(Calendar.DATE);
					int Month = cal.get(Calendar.MONTH);
					int Monthf = calF.get(Calendar.MONTH);
					
					//cal.add(Calendar.MONTH, 1);
					calF.add(Calendar.MONTH, 1);

					
					
					System.out.println("Current Date Time Year : " + Year);
					System.out.println("Current Date Time Day : " + Day);
					System.out.println("Current Date Time Month : " + cal.getTime());
					System.out.println("Current Date Time Month FIN : " + calF.getTime());

					
					
					Calendar c = Calendar.getInstance();
					c.setTime(renteu.getBeneficiairesR().getNaissance());
					int YearB = c.get(Calendar.YEAR);
					System.out.println("Date Time Benef : " + YearB);
					
					
				age = Year - YearB;
				
				renteu.getBeneficiairesR().setAge(age);
				System.out.println("aaaaage"+" "+age);
				System.out.println("age"+" "+renteu.getBeneficiairesR().getAge());
				
				while(age<100 ){
					
					int YearR = cal.get(Calendar.YEAR);
					 
					System.out.println("AGE REGLO"+" "+calF.getTime().getYear());
					System.out.println("AGE REGLO 1 "+" "+ YearR);
					 



					age = YearR - YearB;
					System.out.println("aaaaage jdid"+" "+age);
					System.out.println("age jdiddd"+" "+renteu.getBeneficiairesR().getAge());
					
				renteb = renteC * (clocal.getCoefF(age))*12;
				renteu.setPM(renteb);
				
				rulocal.update(renteu);
				rpmlocal.ajoutRentePMPN(renteu.getBeneficiairesR().getId_b(), renteu.getRente(), renteu.getPM(), true,  cal.getTime(), calF.getTime());
				
				//*****************ANNEE SUIVANTE***********************
				
				cal.add(Calendar.YEAR, 1);
				System.out.println("YEAR NEXT " +cal.getTime().getYear());
				System.out.println("YEAR NEXT 11" +" " +cal.get(Calendar.YEAR));


				 
				//***********************************************
				
				 } 
				}
				
				
								
														// Veuve
				
					else if (renteu.getBeneficiairesR().getEtat().equals("Veuve") ) {
						
						Calendar cal = Calendar.getInstance();
						Calendar calF = Calendar.getInstance();

						int Year = cal.get(Calendar.YEAR);
						int Day = cal.get(Calendar.DATE);
						int Month = cal.get(Calendar.MONTH);
						int Monthf = calF.get(Calendar.MONTH);
						
						//cal.add(Calendar.MONTH, 1);
						calF.add(Calendar.MONTH, 1);

						
						
						System.out.println("Current Date Time Year : " + Year);
						System.out.println("Current Date Time Day : " + Day);
						System.out.println("Current Date Time Month : " + cal.getTime());
						System.out.println("Current Date Time Month FIN : " + calF.getTime());

						
						
						Calendar c = Calendar.getInstance();
						c.setTime(renteu.getBeneficiairesR().getNaissance());
						int YearB = c.get(Calendar.YEAR);
						System.out.println("Date Time Benef : " + YearB);
						
						
					age = Year - YearB;
					
					renteu.getBeneficiairesR().setAge(age);
					System.out.println("aaaaage"+" "+age);
					System.out.println("age"+" "+renteu.getBeneficiairesR().getAge());
					while(age<100 ){
						
						int YearR = cal.get(Calendar.YEAR);
						 
						System.out.println("AGE REGLO"+" "+calF.getTime().getYear());
						System.out.println("AGE REGLO 1 "+" "+ YearR);
						 



						age = YearR - YearB;
						System.out.println("aaaaage jdid"+" "+age);
						System.out.println("age jdiddd"+" "+renteu.getBeneficiairesR().getAge());
				
				if (local.calculBenefF(renteu.getBeneficiairesR().getVictime().getId_v())>1 ) {
				
				renteb = renteC * (clocal.getCoefF(age))*12  ;
				
				renteu.setPM(renteb);
				}
				else {
					
					renteb = renteC * (clocal.getCoefF(age))*12   ;
					
					renteu.setPM(renteb);
				}
				
				rulocal.update(renteu);
				rpmlocal.ajoutRentePMPN(renteu.getBeneficiairesR().getId_b(), renteu.getRente(), renteu.getPM(), true,  cal.getTime(), calF.getTime());
				
				//*****************ANNEE SUIVANTE***********************
				
				cal.add(Calendar.YEAR, 1);
				System.out.println("YEAR NEXT " +cal.getTime().getYear());
				System.out.println("YEAR NEXT 11" +" " +cal.get(Calendar.YEAR));


				 
				//***********************************************
				}
					
					}
														
														// Fils
					
					
					else if (renteu.getBeneficiairesR().getEtat().equals("Fils") ) {
						
						Calendar cal = Calendar.getInstance();
						Calendar calF = Calendar.getInstance();

						int Year = cal.get(Calendar.YEAR);
						int Day = cal.get(Calendar.DATE);
						int Month = cal.get(Calendar.MONTH);
						int Monthf = calF.get(Calendar.MONTH);
						
						//cal.add(Calendar.MONTH, 1);
						calF.add(Calendar.MONTH, 1);

						
						
						System.out.println("Current Date Time Year : " + Year);
						System.out.println("Current Date Time Day : " + Day);
						System.out.println("Current Date Time Month : " + cal.getTime());
						System.out.println("Current Date Time Month FIN : " + calF.getTime());

						
						
						Calendar c = Calendar.getInstance();
						c.setTime(renteu.getBeneficiairesR().getNaissance());
						int YearB = c.get(Calendar.YEAR);
						System.out.println("Date Time Benef : " + YearB);
						
						
					age = Year - YearB;
					
					renteu.getBeneficiairesR().setAge(age);
					System.out.println("aaaaage"+" "+age);
					System.out.println("age"+" "+renteu.getBeneficiairesR().getAge());
					
					while(age<25 ){
						int YearR = cal.get(Calendar.YEAR);
						 
						System.out.println("AGE REGLO"+" "+calF.getTime().getYear());
						System.out.println("AGE REGLO 1 "+" "+ YearR);
						 



						age = YearR - YearB;
						System.out.println("aaaaage jdid"+" "+age);
						System.out.println("age jdiddd"+" "+renteu.getBeneficiairesR().getAge());
						
					if (renteu.getBeneficiairesR().getConjoint()>1  ) {
					
						if (local.calculBenefF(renteu.getBeneficiairesR().getVictime().getId_v())==1 ) {
					renteb = renteC *(25-renteu.getBeneficiairesR().getAge())*12  ;
					
					renteu.setPM(renteb);
					} 
					}
					
					rulocal.update(renteu);
					rpmlocal.ajoutRentePMPN(renteu.getBeneficiairesR().getId_b(), renteu.getRente(), renteu.getPM(), true,  cal.getTime(), calF.getTime());
					
					//*****************ANNEE SUIVANTE***********************
					
					cal.add(Calendar.YEAR, 1);
					System.out.println("YEAR NEXT " +cal.getTime().getYear());
					System.out.println("YEAR NEXT 11" +" " +cal.get(Calendar.YEAR));


					 
					//***********************************************
				}
			
					}
															
														// Fille
			
			
			
					else if (renteu.getBeneficiairesR().getEtat().equals("Fille") ) {
						
						Calendar cal = Calendar.getInstance();
						Calendar calF = Calendar.getInstance();

						int Year = cal.get(Calendar.YEAR);
						int Day = cal.get(Calendar.DATE);
						int Month = cal.get(Calendar.MONTH);
						int Monthf = calF.get(Calendar.MONTH);
						
						//cal.add(Calendar.MONTH, 1);
						calF.add(Calendar.MONTH, 1);

						
						
						System.out.println("Current Date Time Year : " + Year);
						System.out.println("Current Date Time Day : " + Day);
						System.out.println("Current Date Time Month : " + cal.getTime());
						System.out.println("Current Date Time Month FIN : " + calF.getTime());

						
						
						Calendar c = Calendar.getInstance();
						c.setTime(renteu.getBeneficiairesR().getNaissance());
						int YearB = c.get(Calendar.YEAR);
						System.out.println("Date Time Benef : " + YearB);
						
						
					age = Year - YearB;
					
					renteu.getBeneficiairesR().setAge(age);
					System.out.println("aaaaage"+" "+age);
					System.out.println("age"+" "+renteu.getBeneficiairesR().getAge());
					
					while(age<25 ){
						int YearR = cal.get(Calendar.YEAR);
						 
						System.out.println("AGE REGLO"+" "+calF.getTime().getYear());
						System.out.println("AGE REGLO 1 "+" "+ YearR);
						 



						age = YearR - YearB;
						System.out.println("aaaaage jdid"+" "+age);
						System.out.println("age jdiddd"+" "+renteu.getBeneficiairesR().getAge());
					
						if (renteu.getBeneficiairesR().getConjoint()>1  ) {
						
							if (local.calculBenefF(renteu.getBeneficiairesR().getVictime().getId_v())==1 ) {
								renteb = renteC * (clocal.getCoefF(age))*12  ;
								
								renteu.setPM(renteb);
						} 
						}
						
						rulocal.update(renteu);
						rpmlocal.ajoutRentePMPN(renteu.getBeneficiairesR().getId_b(), renteu.getRente(), renteu.getPM(), true,  cal.getTime(), calF.getTime());
						
						//*****************ANNEE SUIVANTE***********************
						
						cal.add(Calendar.YEAR, 1);
						System.out.println("YEAR NEXT " +cal.getTime().getYear());
						System.out.println("YEAR NEXT 11" +" " +cal.get(Calendar.YEAR));


						 
						//***********************************************
					}
					
					}
					
			
			/* FIN CALCUL JIRAYA  
		
			

			
			
			FacesMessage msg = new FacesMessage("Provision Mathématique Calculée avec succés"," OK ");
			//.addToControl("ffsCompanyForm:test", "Billing Address cannot be removed")
			FacesContext.getCurrentInstance().addMessage(null, msg);
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getFlash().setKeepMessages(true);
				init();

					}
		*/
	 
	 public String initialiser(){
		 rente = new Rente();
		 return null;
	 }
	 
	 public void RecupereIdRenU(Rente r){
			id_rente=r.getId_rente();
			rente = rlocal.readByid(id_rente);
			renteC = (int) rente.getRente();
			System.out.println(id_rente+" "+"Rente"+renteC);

			
		}
	 
	 
	 
	 public void RecupereIdRenF(RenteF r){
		 System.out.println("Hello");
			id_rentef=r.getId_rente();
			System.out.println("Rente"+id_rentef+" ");
			rentef = rflocal.readByid(id_rentef);
			renteC = (int)rentef.getRente();
			PM = (int)rentef.getPM();
			System.out.println(id_rentef+" "+"Rente"+renteC+" "+"PM"+" "+PM);

			
		}
	
	 /*public void CalculeListe(){
			for(RenteF f : rentesR ){
				  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd ");
				int mois = f.getDebut().getMonth();
				
				//*****************DATE DEBUT***********************
				
				 Calendar calendar = Calendar.getInstance();
				 calendar.setTime(f.getDebut());
				 calendar.add(Calendar.MONTH, 1);
				 
			System.out.println(" DATE Calendar 1"+dateFormat.format(f.getDebut()));
			System.out.println(" **************** ");
			System.out.println(" DATE Calendar 2 "+dateFormat.format(calendar.getTime()));
			
				System.out.println(" DATE Calendar 4 "+f.getFin().getMonth());
				System.out.println(" DATE Calendar 5 "+calendar.getTime().getMonth());

					
				//******************DATE FIN***********************
				
				Calendar calendarF = Calendar.getInstance();
				 calendarF.setTime(f.getFin());
				 calendarF.add(Calendar.MONTH, 1);
				 
			System.out.println(" DATE Calendar 1"+dateFormat.format(f.getFin()));
			System.out.println(" **************** ");
			System.out.println(" DATE Calendar 2 "+dateFormat.format(calendarF.getTime()));
			
				System.out.println(" DATE Calendar 4 "+f.getDebut().getMonth());
				System.out.println(" DATE Calendar 5 "+calendarF.getTime().getMonth());

				//*******************FONCTION***********************


				//System.out.println("Idbenef"+"  "+f.getBeneficiairesR().getId_b());
				//System.out.println("RENTE BENEF"+" " +rulocal.getRenteU(f.getBeneficiairesR().getId_b()));
				//System.out.println("RENTE BENEF RENTE U"+" " +local.RecupereRente(rente1.getBeneficiairesR().getId_b()));
				//System.out.println("RENTE BENEF"+" " +local.RecupereRente(rente1.getBeneficiairesR().getId_b()));
				beneficiaire = local.readByid(f.getBeneficiairesR().getId_b());
				rente.setBeneficiairesR(local.readByid(f.getBeneficiairesR().getId_b()));
				rente.setDebut(calendar.getTime());
				rente.setFin(calendarF.getTime());
				renteN = renteC;
				renteP= PM;
				//System.out.println("RENTE BENEF"+" " +renteP+" "+renteN);
				//System.out.println("ID BENEF"+" " +f.getBeneficiairesR().getId_b());
				
				//System.out.println("benef"+beneficiaire.getEtat());
				
		/* Calcul JIRAYA 
				
															//	PERE
				
				if(beneficiaire.getEtat().equals("Pere") ) 
				{
					//System.out.println("AGE"+" " +beneficiaire.getAge());
					//System.out.println("RENTE BENEF"+" " +local.RecupereRente(rente1.getBeneficiairesR().getId_b()));
					
					 rente.setRente(renteN);

					 rente.setPM(renteP);
						rente.setBool(true);

				} 
					
															// MERE
				
					else if (beneficiaire.getEtat().equals("Mere") ) {
					
						rente.setRente(renteN);

						 rente.setPM(renteP);
					 } 
					
					
									
															// Veuve
					
						else if (beneficiaire.getEtat().equals("Veuve") ) {
					
					if (local.calculBenefF(beneficiaire.getVictime().getId_v())==1 || local.calculBenefF(beneficiaire.getVictime().getId_v())==2 || local.calculBenefF(beneficiaire.getVictime().getId_v())==3 || local.calculBenefF(beneficiaire.getVictime().getId_v())==4  ) {
					
						rente.setRente(renteN);

						 rente.setPM(renteP);
					}
					else {
						
						rente.setRente(renteN);

						 rente.setPM(renteP);
					}
					}
															
															// Fils
						
						
						else if (beneficiaire.getEtat().equals("Fils") ) {
						
						if (beneficiaire.getConjoint()==1  ) {
						
							if (local.calculBenefF(beneficiaire.getVictime().getId_v())==1 ) {
								rente.setRente(renteN);

								 rente.setPM(renteP);
						} else if (local.calculBenefF(beneficiaire.getVictime().getId_v())==2 ){
						
							rente.setRente(renteN);

							 rente.setPM(renteP);
						}else if (local.calculBenefF(beneficiaire.getVictime().getId_v())==3 ){
							
							rente.setRente(renteN);

							 rente.setPM(renteP);
							}
						}else if (beneficiaire.getConjoint()==0  ) {
						
							if (local.calculBenefF(beneficiaire.getVictime().getId_v())==1 ) {
								rente.setRente(renteN);

								 rente.setPM(renteP);
						
						} else if (local.calculBenefF(beneficiaire.getVictime().getId_v())==2 ){
						
							rente.setRente(renteN);

							 rente.setPM(renteP);
						}else if (local.calculBenefF(beneficiaire.getVictime().getId_v())==3 ){
							
							rente.setRente(renteN);

							 rente.setPM(renteP);
							}else if (local.calculBenefF(beneficiaire.getVictime().getId_v())==4 ){
								
								rente.setRente(renteN);

								 rente.setPM(renteP);
								}
						}
					}
				
				
																
															// Fille
				
				
				
						else if (beneficiaire.getEtat().equals("Fille") ) {
							
							if (beneficiaire.getConjoint()==1  ) {
							
								if (local.calculBenefF(beneficiaire.getVictime().getId_v())==1 ) {
									rente.setRente(renteN);

									 rente.setPM(renteP);
							} else if (local.calculBenefF(beneficiaire.getVictime().getId_v())==2 ){
							
								rente.setRente(renteN);

								 rente.setPM(renteP);
							}else if (local.calculBenefF(beneficiaire.getVictime().getId_v())==3 ){
								
								rente.setRente(renteN);

								 rente.setPM(renteP);
								}
							}else if (beneficiaire.getConjoint()==0  ) {
							
								if (local.calculBenefF(beneficiaire.getVictime().getId_v())==1 ) {
									rente.setRente(renteN);

									 rente.setPM(renteP);
							
							} else if (local.calculBenefF(beneficiaire.getVictime().getId_v())==2 ){
							
								rente.setRente(renteN);

								 rente.setPM(renteP);
							}else if (local.calculBenefF(beneficiaire.getVictime().getId_v())==3 ){
								
								rente.setRente(renteN);

								 rente.setPM(renteP);
								}else if (local.calculBenefF(beneficiaire.getVictime().getId_v())==4 ){
									
									rente.setRente(renteN);

									 rente.setPM(renteP);
									}
							}
						}
						
					
						
				
				/* FIN CALCUL JIRAYA 
			
				//System.out.println("Rente"+renteb);
				//System.out.println("Id Victime"+beneficiaire.getVictime().getId_v());
				//System.out.println("Revenu"+vlocal.getRevenuAnnu(beneficiaire.getVictime().getId_v()));
				//System.out.println("nbbenfParents"+local.calculBenefP(beneficiaire.getVictime().getId_v()));
				//System.out.println("nbbenfFils"+local.calculBenefF(beneficiaire.getVictime().getId_v()));
				rlocal.ajoutRentePN(f.getBeneficiairesR().getId_b(), renteN,renteP ,true,calendar.getTime(), calendarF.getTime());
				rflocal.deleteRenteF(f);
				
				FacesMessage msg = new FacesMessage("Successful","Une nouvelle sous garantie a été ajoutée");
				//.addToControl("ffsCompanyForm:test", "Billing Address cannot be removed")
				FacesContext.getCurrentInstance().addMessage(null, msg);
				FacesContext context = FacesContext.getCurrentInstance();
				context.getExternalContext().getFlash().setKeepMessages(true);
					init();


			}
			
		
	
	
	 }
	 */
	 public void search(){
 		 System.out.println(cinbr);
		 rentesRech=rlocal.findRS(cinbr);
		 System.out.println(rentesRech);
		 
		 if(cinbr.isEmpty()||rentesRech.size()==0){
			 System.out.println("Erreur");
			 FacesMessage msg = new FacesMessage("Erreur! Vérifier Données","CIN NON CORRECTE");
				//.addToControl("ffsCompanyForm:test", "Billing Address cannot be removed")
				FacesContext.getCurrentInstance().addMessage(null, msg);
				FacesContext context = FacesContext.getCurrentInstance();
				context.getExternalContext().getFlash().setKeepMessages(true);
					init();
		 }
	 }
	 
public void searchPM(){
		 
	  
		 System.out.println(cinbr);
		 rentesPMT=rpmlocal.findAllT(cinbr);
		 System.out.println(rentesPMT);
		 
		 if(cinbr.isEmpty()||rentesPMT.size()==0){
			 System.out.println("Erreur");
			 FacesMessage msg = new FacesMessage("Erreur! Vérifier Données","CIN NON CORRECTE");
				//.addToControl("ffsCompanyForm:test", "Billing Address cannot be removed")
				FacesContext.getCurrentInstance().addMessage(null, msg);
				FacesContext context = FacesContext.getCurrentInstance();
				context.getExternalContext().getFlash().setKeepMessages(true);
					init();
		 }
	 }
	 

				public void searchDossier(){
					  
					 System.out.println(cinbr);
					 rentesu=rlocal.findDossier(cinbr);
					 System.out.println(rentesu);
					  
					 
					 if(cinbr.isEmpty()||rentesu.size()==0){
						 System.out.println("Erreur");
						 FacesMessage msg = new FacesMessage("Erreur! Vérifier Données","CIN NON CORRECTE");
							//.addToControl("ffsCompanyForm:test", "Billing Address cannot be removed")
							FacesContext.getCurrentInstance().addMessage(null, msg);
							FacesContext context = FacesContext.getCurrentInstance();
							context.getExternalContext().getFlash().setKeepMessages(true);
								init();
					 }
				}


				public void updatePM(){
	 for(RentePM f : rentesPMT ){
			beneficiaire = local.readByid(f.getBeneficiairesR().getId_b());
			rente=rlocal.readByid(beneficiaire.getId_b());
			System.out.println(f.getId_rente());
			System.out.println("benef"+beneficiaire.getId_b());
 			f.setBeneficiairesR(local.readByid(f.getBeneficiairesR().getId_b()));
 			
 			
		
			/*************************************************************/
			
					
			if(beneficiaire.getEtat().equals("Pere") ) 
			{
				
				renteb = BigInteger.valueOf((long) (rente.getRente() *(clocal.getCoefP(f.getBeneficiairesR().getAge()))*12)) ;
				 
					f.setPM(renteb);
					rpmlocal.update(f);

				 
			}
			else if(beneficiaire.getEtat().equals("PetitFils") ) 
			{
				renteb = BigInteger.valueOf((long) (rente.getRente() *(clocal.getCoefP(f.getAge()))*12)) ;
				
				 
					f.setPM(renteb);
					rpmlocal.update(f);

				 
				
			}else if(beneficiaire.getEtat().equals("Mere") ) 
			{
				renteb = BigInteger.valueOf((long) (rente.getRente() *(clocal.getCoefP(f.getAge()))*12)) ;
				
				 
					f.setPM(renteb);
					rpmlocal.update(f);
				 
				
			}else if(beneficiaire.getEtat().equals("Veuve") ) 
			{
				renteb = BigInteger.valueOf((long) (rente.getRente() *(clocal.getCoefP(f.getAge()))*12)) ;
				
				 
					f.setPM(renteb);
				 
					rpmlocal.update(f);
				
			}else if(beneficiaire.getEtat().equals("Fils") ) 
			{
				
				renteb = BigInteger.valueOf((long)(rente.getRente() *(25-f.getAge())*12))  ;
				 
					f.setPM(renteb);
					rpmlocal.update(f);
				 System.out.println(25-age);
				 
				
			}else if(beneficiaire.getEtat().equals("Fille") ) 
			{
			
				renteb = BigInteger.valueOf((long) (rente.getRente() *(clocal.getCoefP(f.getAge()))*12)) ;
				
				 
					f.setPM(renteb);
					rpmlocal.update(f);
				 
			}else if(beneficiaire.getEtat().equals("Handicape") ) 
				{
					
					renteb = BigInteger.valueOf((long) (rente.getRente() *(clocal.getCoefP(f.getAge()))*12)) ;
					
					 
						f.setPM(renteb);
						rpmlocal.update(f);
					 
			}
			System.out.println(rente.getRente());
			
			
			
			
			
			/*************************************************************/
			
			
 			
	 }
	 
	 FacesMessage msg = new FacesMessage("Successful ! ","Rente Modifiée");
		//.addToControl("ffsCompanyForm:test", "Billing Address cannot be removed")
		FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
			init();
	 
	 
				}	 
	 
				public void doOuvert(){
 
					Calendar calp = Calendar.getInstance();
					Calendar calpF = Calendar.getInstance();
					
					/*FacesContext ctx = FacesContext.getCurrentInstance();
					BeneficiaireBean monBean2 = (BeneficiaireBean) ctx.getApplication().getExpressionFactory().createValueExpression(ctx.getELContext(), "#{beneficiaireBean}", BeneficiaireBean.class).getValue(ctx.getELContext());
					monBean2.addRenteD();*/
					for(Rente r : rentesu){
						r.setEtat("REOUVERT");
						r.setMotif(null);
					r.setReouverture(dateFormat.format(calp.getTime()));
					r.setValider(null);
					rlocal.update(r);

					}
					  rentespm=rpmlocal.findAllT(cinbr) ;
					  
					  for(int j=0;j<rentespm.size();j++){
							rentespm.get(j).setEtat("REOUVERT");
							rentespm.get(j).setFerOuv(dateFormat.format(calp.getTime()));
							System.out.println(rentespm.get(j).getEtat());
							rpmlocal.update(rentespm.get(j));
						}

				}

				public void doFerme(){
					System.out.println("rentesu"+" "+rentesu);
					System.out.println(rentesu.get(1).getBeneficiairesR().getId_b());
					
					Calendar calp = Calendar.getInstance();
					Calendar calpF = Calendar.getInstance();
					
					for(Rente r : rentesu){
						
						r.setEtat("FERME");
						r.setMotif(motif);
						r.setReouverture(dateFormat.format(calp.getTime()));
						r.setValider(false);
						rlocal.update(r);
						}
					
					rentespm=rpmlocal.findAllT(cinbr);
					System.out.println("RentePM"+" "+rentespm);
					for(int j=0;j<rentespm.size();j++){
						rentespm.get(j).setEtat("FERME");
						rentespm.get(j).setFerOuv(dateFormat.format(calp.getTime()));
						System.out.println(rentespm.get(j).getEtat());
						rpmlocal.update(rentespm.get(j));
					}
					
					
					
					for(int i=0;i<rentesT.size();i++){
						System.out.println("rente moglga"+rentesu.get(1));
						System.out.println("T"+" "+rentesT.get(i).getBeneficiairesR().getPrenom());
						System.out.println("U"+" "+rentesu.get(1).getBeneficiairesR().getPrenom());
						if(rentesT.contains(rentesu.get(1).getBeneficiairesR().getPrenom())){
							for(Rente r : rentesT){
								r.setEtat("FERME");
								r.setMotif(motif);
								rlocal.update(r);
								}
							rentesT.remove(rentesT.get(i));
							rentesT.remove(rentesT);
					
					}
					}
					//rentesu.removeAll(rentesu);
				}
				
				public void imprim(Rente r){
					
					Document document = new Document();
			        try{
			        	
			        	String a = "CIN :"+" "+r.getBeneficiairesR().getCinb();
			        	String b= "NOM :"+" "+r.getBeneficiairesR().getNom();
			        	String c = "PRENOM :"+" "+r.getBeneficiairesR().getPrenom();
			        	String d= "PRENOM VICTIME :"+" "+r.getBeneficiairesR().getVictime().getPrenom();
			        	String montant_rente = "MONTANT RENTE :"+" "+r.getRente();
			        	String debut = "DATE DEBUT RENTE :"+" "+dateFormat.format(r.getDebut());
			        	String fin = "DATE FIN RENTE :"+" "+dateFormat.format(r.getFin());

			        	System.out.println(a);
			        	System.out.println(b);
			        	System.out.println(c);
			        	System.out.println(d);
			        	System.out.println(montant_rente);
			        	System.out.println(debut);
			        	System.out.println(fin);
			        	

			        	
			        	Calendar calp = Calendar.getInstance();
			        	PdfWriter.getInstance(document, new FileOutputStream("C:\\MAE\\Rente"+"-"+r.getBeneficiairesR().getPrenom()+"-"+r.getBeneficiairesR().getNom()+"-"+r.getBeneficiairesR().getCinb()+".pdf"));
			        	System.out.println("C:\\MAE\\Rente"+" "+r.getBeneficiairesR().getPrenom()+" "+r.getBeneficiairesR().getNom()+" "+dateFormat.format(calp.getTime())+".pdf");

			        	document.open();
			            Font font = new Font(Font.FontFamily.TIMES_ROMAN, 48, Font.ITALIC | Font.UNDERLINE | Font.BOLD);
			            
			            Paragraph p1 = new Paragraph(a);
			            Paragraph p2 = new Paragraph(b);
			            Paragraph p3 = new Paragraph(c);
			            Paragraph p4 = new Paragraph(d);
			            Paragraph mr = new Paragraph(montant_rente);
			            Paragraph p5 = new Paragraph(debut);
			            Paragraph p6 = new Paragraph(fin);
			            
			            
			            Paragraph pn = new Paragraph("RENTE MAE"+" "+r.getBeneficiairesR().getPrenom()+" "+r.getBeneficiairesR().getNom());
			            Paragraph pdate = new Paragraph("Tunis le"+" "+dateFormat.format(calp.getTime()));
			             pdate = new Paragraph("Tunis le"+" "+dateFormat.format(calp.getTime()));

			            //Paragraph p5 = new Paragraph(ff);
			            
			            p1.setAlignment(Element.ALIGN_LEFT);
			            p2.setAlignment(Element.ALIGN_LEFT);
			            p3.setAlignment(Element.ALIGN_LEFT);
			            p4.setAlignment(Element.ALIGN_LEFT);
			            p5.setAlignment(Element.ALIGN_LEFT);
			            p6.setAlignment(Element.ALIGN_LEFT);
			            mr.setAlignment(Element.ALIGN_LEFT);
			            pn.setAlignment(Element.ALIGN_CENTER);
			            pdate.setAlignment(Element.ALIGN_CENTER);

			           // p5.setAlignment(Element.ALIGN_CENTER);
			            
			            //ajout IMAGE
			            
			            Image png = Image.getInstance("C:\\MAE\\logo_mae.png");
			            png.scaleAbsolute(140, 120);
			            
			            document.add(png);
			            
			            
			            //add blank line
			    	    document.add(pn);
			    	    document.add( Chunk.NEWLINE );
			    	    document.add( Chunk.NEWLINE );
			    	    document.add( Chunk.NEWLINE );
			    	    document.add( Chunk.NEWLINE );
			    	    document.add( Chunk.NEWLINE );
			    	    document.add( Chunk.NEWLINE );
			           
			    	    document.add(p1);
			    	    document.add( Chunk.NEWLINE );
			            document.add(p2);
			            document.add( Chunk.NEWLINE );
			            document.add(p3);
			            document.add( Chunk.NEWLINE );
			            document.add(p4);
			            document.add( Chunk.NEWLINE );
			            document.add(mr);
			            document.add( Chunk.NEWLINE );
			            document.add(p5);
			            document.add( Chunk.NEWLINE );
			            document.add(p6);
			            document.add( Chunk.NEWLINE );
			            document.add( Chunk.NEWLINE );
			            document.add( Chunk.NEWLINE );
			            document.add( Chunk.NEWLINE );
			            document.add( Chunk.NEWLINE );
			            document.add( Chunk.NEWLINE );
			            document.add( Chunk.NEWLINE );
			            document.add( Chunk.NEWLINE );
			            document.add( Chunk.NEWLINE );
			            document.add( Chunk.NEWLINE );
			            document.add( Chunk.NEWLINE );

			            document.add(pdate);
			            if(dateFormat.format(r.getDatePriseRente())!=null){
				            Paragraph p7 = new Paragraph("DATE PRISE RENTE :"+" "+dateFormat.format(r.getDatePriseRente()));
				            p7.setAlignment(Element.ALIGN_LEFT);

				            }
			            

			            document.close();
			        }
			        catch(Exception n){
			            System.out.println(n);
			        }
			        document.close();
			    }
					
				

}
	 

