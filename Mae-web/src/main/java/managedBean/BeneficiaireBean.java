package managedBean;

import java.math.BigInteger;
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
import tn.esprit.MaE.Interface.CoefficientServiceLocal;
import tn.esprit.MaE.Interface.RentePMServiceLocal;
import tn.esprit.MaE.Interface.RenteServiceLocal;
import tn.esprit.MaE.Interface.RenteUServiceLocal;
import tn.esprit.MaE.Interface.VictimeServiceLocal;
import tn.esprit.MaE.entities.Beneficiaire;
import tn.esprit.MaE.entities.Coefficient;
import tn.esprit.MaE.entities.Rente;
import tn.esprit.MaE.entities.RenteU;
import tn.esprit.MaE.entities.Victime;

@ManagedBean
@ViewScoped
public class BeneficiaireBean {

	@EJB
	BeneficiaireServiceLocal local;
	
	
	@EJB
	RenteServiceLocal rlocal;
	
	@EJB
	RenteUServiceLocal rulocal;
	
	@EJB
	VictimeServiceLocal vlocal;
	
	@EJB
	RentePMServiceLocal rpmlocal;
	
	@EJB
	CoefficientServiceLocal clocal;
	
	private Victime victime = new Victime();
	
	private Coefficient coefficient = new Coefficient();
	
	static private  int id_benef;
	
	private final static int SMIG = 393248;
	
	private List<Rente>rentesFiltred;
	private List<Rente>rentes=new ArrayList<>();
	
	private List<RenteU>rentesuFiltred;
	private List<RenteU>rentesu=new ArrayList<>();
	
	private List<Coefficient>coefficientsFiltred;
	private List<Coefficient>coefficients=new ArrayList<>();
	private Coefficient coef = new Coefficient();
	
	private Rente rente=new Rente();
	private Rente rente1=new Rente();

	static private BigInteger rentepm ; 

	
	private int renteP ;
	private int renteN ;
	
	 private int renteC ; 

	private List<Beneficiaire>beneficiairesFiltred;

	private List<Beneficiaire>beneficiaires=new ArrayList<>();
	
	private List<Beneficiaire>beneficiairesBFiltred;

	private List<Beneficiaire>beneficiairesB=new ArrayList<>();

	
	private Beneficiaire beneficiaire=new Beneficiaire();
	
	
	public List<Beneficiaire> getBeneficiairesBFiltred() {
		return beneficiairesBFiltred;
	}

	public void setBeneficiairesBFiltred(List<Beneficiaire> beneficiairesBFiltred) {
		this.beneficiairesBFiltred = beneficiairesBFiltred;
	}

	public List<Beneficiaire> getBeneficiairesB() {
		return beneficiairesB;
	}

	public void setBeneficiairesB(List<Beneficiaire> beneficiairesB) {
		this.beneficiairesB = beneficiairesB;
	}

	private int renteb ;
	private Date debut;
	private Date fin;
	private float age;
	
	private int PE;
	private int PM;
	private int FF;
	
	private int p1;
	private int p2;
	
	static private  int id_rente;
	
	

	public static BigInteger getRentepm() {
		return rentepm;
	}

	public static void setRentepm(BigInteger rentepm) {
		BeneficiaireBean.rentepm = rentepm;
	}

	public float getAge() {
		return age;
	}

	public void setAge(float age) {
		this.age = age;
	}

	public Rente getRente1() {
		return rente1;
	}

	public void setRente1(Rente rente1) {
		this.rente1 = rente1;
	}

	public static int getId_rente() {
		return id_rente;
	}

	public static void setId_rente(int id_rente) {
		BeneficiaireBean.id_rente = id_rente;
	}

	public float getP1() {
		return p1;
	}

	public int getRenteC() {
		return renteC;
	}

	public void setRenteC(int renteC) {
		this.renteC = renteC;
	}

	public Victime getVictime() {
		return victime;
	}

	public void setVictime(Victime victime) {
		this.victime = victime;
	}

	public Coefficient getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(Coefficient coefficient) {
		this.coefficient = coefficient;
	}

	
	

	public static int getId_benef() {
		return id_benef;
	}

	public static void setId_benef(int id_benef) {
		BeneficiaireBean.id_benef = id_benef;
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

	public Rente getRente() {
		return rente;
	}

	public void setRente(Rente rente) {
		this.rente = rente;
	}
	 

	
	
	/*public static void setRenteC(int renteC) {
		BeneficiaireBean.renteC = renteC;
	}*/

	public float getRenteN() {
		return renteN;
	}

	 

	public List<Beneficiaire> getBeneficiairesFiltred() {
		return beneficiairesFiltred;
	}

	public void setBeneficiairesFiltred(List<Beneficiaire> beneficiairesFiltred) {
		this.beneficiairesFiltred = beneficiairesFiltred;
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

	public float getRenteb() {
		return renteb;
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

	public List<RenteU> getRentesuFiltred() {
		return rentesuFiltred;
	}

	public void setRentesuFiltred(List<RenteU> rentesuFiltred) {
		this.rentesuFiltred = rentesuFiltred;
	}

	public List<RenteU> getRentesu() {
		return rentesu;
	}

	public void setRentesu(List<RenteU> rentesu) {
		this.rentesu = rentesu;
	}

	 
	
	public int getRenteP() {
		return renteP;
	}

	public void setRenteP(int renteP) {
		this.renteP = renteP;
	}

	public int getPE() {
		return PE;
	}

	public void setPE(int pE) {
		PE = pE;
	}

	public int getPM() {
		return PM;
	}

	public void setPM(int pM) {
		PM = pM;
	}

	public int getFF() {
		return FF;
	}

	public void setFF(int fF) {
		FF = fF;
	}

	public int getP2() {
		return p2;
	}

	public void setP2(int p2) {
		this.p2 = p2;
	}

	 

	public void setRenteN(int renteN) {
		this.renteN = renteN;
	}

	public void setRenteb(int renteb) {
		this.renteb = renteb;
	}

	public void setP1(int p1) {
		this.p1 = p1;
	}

	@PostConstruct
	public void init(){
	beneficiaire=new Beneficiaire();
	beneficiaires=local.findAll();
	beneficiairesB=local.findAllB(VictimeBean.getId_vi());

	coef=new Coefficient();
	coefficients=clocal.findAll();
	
	
	}
	
public String Page_Lbenef(){
	
		System.out.println(VictimeBean.getId_vi());
		
		return "/pages/GestionnaireSinistre/ListeBeneficiaires?faces-redirect=true"; 
	}

public String Page_Rente(){
	
	return "/pages/GestionnaireSinistre/Rente?faces-redirect=true"; 
}
	
	public void RecupereIdBen(Beneficiaire b){
		id_benef=b.getId_b();
		System.out.println("Benef"+" "+id_benef);
		
		
	}
	
	/*public void addRente() {
		rente = new Rente();
		beneficiaire = local.readByid(id_benef);
		rente.setBeneficiairesR(local.readByid(id_benef));
		rente.setDebut(debut);
		rente.setFin(fin);
		System.out.println("benef"+beneficiaire.getEtat());
		
/* Calcul JIRAYA 
		
													//	PERE
		
		if(beneficiaire.getEtat().equals("Pere") ) 
		{
			System.out.println("AGE"+" " +beneficiaire.getAge());
			renteb = (int) (renteC *(clocal.getCoefP(beneficiaire.getAge())))  ;
			
	
			 rente.setRente(renteb);
		} 
			
													// MERE
		
			else if (beneficiaire.getEtat().equals("Mere") ) {
			
			renteb = (int) (renteC * (clocal.getCoefF(beneficiaire.getAge())));
			 rente.setRente(renteb);
			 } 
			
			
							
													// Veuve
			
				else if (beneficiaire.getEtat().equals("Veuve") ) {
			
			if (local.calculBenefF(beneficiaire.getVictime().getId_v())==1 || local.calculBenefF(beneficiaire.getVictime().getId_v())==2 || local.calculBenefF(beneficiaire.getVictime().getId_v())==3 || local.calculBenefF(beneficiaire.getVictime().getId_v())==4  ) {
			
			renteb = renteC * (clocal.getCoefF(beneficiaire.getAge()))  ;
			
			 rente.setRente(renteb);
			}
			else {
				
				renteb = renteC * (clocal.getCoefF(beneficiaire.getAge()))   ;
				
				 rente.setRente(renteb);
			}
			}
													
													// Fils
				
				
				else if (beneficiaire.getEtat().equals("Fils") ) {
				
				if (beneficiaire.getConjoint()==1  ) {
				
					if (local.calculBenefF(beneficiaire.getVictime().getId_v())==1 ) {
				renteb = renteC *(25-beneficiaire.getAge())  ;
				
				 rente.setRente(renteb);
				} else if (local.calculBenefF(beneficiaire.getVictime().getId_v())==2 ){
				
				renteb = renteC * (25-beneficiaire.getAge())  ;
				
				 rente.setRente(renteb);
				}else if (local.calculBenefF(beneficiaire.getVictime().getId_v())==3 ){
					
					renteb = renteC * (25-beneficiaire.getAge())  ;
					
					 rente.setRente(renteb);
					}
				}else if (beneficiaire.getConjoint()==0  ) {
				
					if (local.calculBenefF(beneficiaire.getVictime().getId_v())==1 ) {
						renteb = renteC * (25-beneficiaire.getAge())  ;
						
						 rente.setRente(renteb);
				
				} else if (local.calculBenefF(beneficiaire.getVictime().getId_v())==2 ){
				
					renteb = renteC * (25-beneficiaire.getAge())  ;
					
					 rente.setRente(renteb);
				}else if (local.calculBenefF(beneficiaire.getVictime().getId_v())==3 ){
					
					renteb = renteC * (25-beneficiaire.getAge())  ;
					
					 rente.setRente(renteb);
					}else if (local.calculBenefF(beneficiaire.getVictime().getId_v())==4 ){
						
						renteb = renteC * (25-beneficiaire.getAge())  ;
						
						 rente.setRente(renteb);
						}
				}
			}
		
		
														
													// Fille
		
		
		
				else if (beneficiaire.getEtat().equals("Fille") ) {
					
					if (beneficiaire.getConjoint()==1  ) {
					
						if (local.calculBenefF(beneficiaire.getVictime().getId_v())==1 ) {
							renteb = renteC * (25-beneficiaire.getAge())  ;
							
							 rente.setRente(renteb);
					} else if (local.calculBenefF(beneficiaire.getVictime().getId_v())==2 ){
					
						renteb = renteC * (25-beneficiaire.getAge())  ;
						
						 rente.setRente(renteb);
					}else if (local.calculBenefF(beneficiaire.getVictime().getId_v())==3 ){
						
						renteb = renteC * (25-beneficiaire.getAge())  ;
						
						 rente.setRente(renteb);
						}
					}else if (beneficiaire.getConjoint()==0  ) {
					
						if (local.calculBenefF(beneficiaire.getVictime().getId_v())==1 ) {
							renteb = renteC * (25-beneficiaire.getAge())  ;
							
							 rente.setRente(renteb);
					
					} else if (local.calculBenefF(beneficiaire.getVictime().getId_v())==2 ){
					
						renteb = renteC * (25-beneficiaire.getAge())  ;
						
						 rente.setRente(renteb);
					}else if (local.calculBenefF(beneficiaire.getVictime().getId_v())==3 ){
						
						renteb = renteC * (25-beneficiaire.getAge())  ;
						
						 rente.setRente(renteb);
						}else if (local.calculBenefF(beneficiaire.getVictime().getId_v())==4 ){
							
							renteb = renteC * (25-beneficiaire.getAge())  ;
							
							 rente.setRente(renteb);
							}
					}
				}
				
			
				
		
		/* FIN CALCUL JIRAYA 
	
		System.out.println("Rente"+renteb);
		System.out.println("Id Victime"+beneficiaire.getVictime().getId_v());
		System.out.println("Revenu"+vlocal.getRevenuAnnu(beneficiaire.getVictime().getId_v()));
		System.out.println("nbbenfParents"+local.calculBenefP(beneficiaire.getVictime().getId_v()));
		System.out.println("nbbenfFils"+local.calculBenefF(beneficiaire.getVictime().getId_v()));

		
		rlocal.ajoutRente(id_benef, renteb, debut, fin,"OUVERT");
		FacesMessage msg = new FacesMessage("Successful","Une nouvelle sous garantie a été ajoutée");
		//.addToControl("ffsCompanyForm:test", "Billing Address cannot be removed")
		FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
			init();

				}
	*/
	public void RecupereRen(){
		renteP = (int) local.RecupereRente(id_benef);
		
		System.out.println(renteP+" "+"Rente"+" "+renteC);

		
	}
	
	/*public void addRenteNEW() {
		rente = new Rente();
		rente1 = rlocal.readByid(id_rente);

		beneficiaire = local.readByid(rente1.getBeneficiairesR().getId_b());
		rente.setBeneficiairesR(local.readByid(rente1.getBeneficiairesR().getId_b()));
		rente.setDebut(debut);
		rente.setFin(fin);
		renteN = local.RecupereRente(rente1.getBeneficiairesR().getId_b());
		renteP= local.RecuperePM(rente1.getBeneficiairesR().getId_b());
		System.out.println("RENTE BENEF"+" " +renteP);
		System.out.println("ID BENEF"+" " +rente1.getBeneficiairesR().getId_b());
		
		System.out.println("benef"+beneficiaire.getEtat());
		
/* Calcul JIRAYA 
		
													//	PERE
		
		if(beneficiaire.getEtat().equals("Pere") ) 
		{
			System.out.println("AGE"+" " +beneficiaire.getAge());
			System.out.println("RENTE BENEF"+" " +local.RecupereRente(rente1.getBeneficiairesR().getId_b()));
			
			 rente.setRente(renteN);

			 rente.setPM(renteP);
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

		rlocal.ajoutRente(id_benef, renteP,debut, fin,"OUVERT");
		FacesMessage msg = new FacesMessage("Successful","Une nouvelle sous garantie a été ajoutée");
		//.addToControl("ffsCompanyForm:test", "Billing Address cannot be removed")
		FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
			init();

				}
	
	
	public void addRenteF() {
		rente = new Rente();
		beneficiaire = local.readByid(id_benef);
		rente.setBeneficiairesR(local.readByid(id_benef));
		
		System.out.println("benef"+beneficiaire.getEtat());
		
/* Calcul JIRAYA 
		
													//	PERE
		
		if(beneficiaire.getEtat().equals("Pere") ) 
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
			c.setTime(beneficiaire.getNaissance());
			int YearB = c.get(Calendar.YEAR);
			System.out.println("Date Time Benef : " + YearB);
			
			
		age = Year - YearB;
		
		beneficiaire.setAge(age);
		System.out.println("aaaaage"+" "+age);
		System.out.println("age"+" "+beneficiaire.getAge());
		
			p1=(float) (vlocal.getRevenuAnnu(beneficiaire.getVictime().getId_v())*(0.8)*(0.1));
			p2=local.calculBenefP(beneficiaire.getVictime().getId_v());
			PE = renteC+( p1  /p2 )  ;
			PM = (float) (2 * SMIG);
			FF = (float) (0.25 * SMIG);
			 renteb=PE+PM+FF;
			 rente.setRente(renteb);
			 rente.setPM(renteb);
				rulocal.ajoutRenteU(id_benef, renteb, cal.getTime(), calF.getTime(),"OUVERT");

		} 
			
													// MERE
		
			else if (beneficiaire.getEtat().equals("Mere") ) {
			
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
				c.setTime(beneficiaire.getNaissance());
				int YearB = c.get(Calendar.YEAR);
				System.out.println("Date Time Benef : " + YearB);
				
				
			age = Year - YearB;
			
			beneficiaire.setAge(age);
			System.out.println("aaaaage"+" "+age);
			System.out.println("age"+" "+beneficiaire.getAge());
				
				
			PE = (float) (renteC+( (vlocal.getRevenuAnnu(beneficiaire.getVictime().getId_v())*(0.8)*(0.1))/(local.calculBenefP(beneficiaire.getVictime().getId_v())) ))  ;
			PM = (float) (2 * SMIG);
			FF = (float) (0.25 * SMIG);
			 renteb=PE+PM+FF;
			 rente.setRente(renteb);
			 rente.setPM(renteb);
			 
				rulocal.ajoutRenteU(id_benef, renteb, cal.getTime(), calF.getTime(),"OUVERT");

			 } 
			
			
							
													// Veuve
			
				else if (beneficiaire.getEtat().equals("Veuve") ) {
			
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
					c.setTime(beneficiaire.getNaissance());
					int YearB = c.get(Calendar.YEAR);
					System.out.println("Date Time Benef : " + YearB);
					
					
				age = Year - YearB;
				
				beneficiaire.setAge(age);
				System.out.println("aaaaage"+" "+age);
				System.out.println("age"+" "+beneficiaire.getAge());
				
			if (local.calculBenefF(beneficiaire.getVictime().getId_v())>1 ) {
			
			PE = (float) (renteC+( (vlocal.getRevenuAnnu(beneficiaire.getVictime().getId_v())*(0.8)*(0.4)) ))  ;
			PM = (float) (2.5 * SMIG);
			FF = (float) (0.25 * SMIG);
			 renteb=PE+PM+FF;
			 rente.setRente(renteb);
			 rente.setPM(renteb);
			}
			else {
				
				PE = (float) (renteC+( (vlocal.getRevenuAnnu(beneficiaire.getVictime().getId_v())*(0.8)*(0.5)) ))  ;
				PM = (float) (2.5 * SMIG);
				FF = (float) (0.25 * SMIG);
				 renteb=PE+PM+FF;
				 rente.setRente(renteb);
				 rente.setPM(renteb);
			}
			
			rulocal.ajoutRenteU(id_benef, renteb, cal.getTime(), calF.getTime(),"OUVERT");

			}
													
													// Fils
				
				
				else if (beneficiaire.getEtat().equals("Fils") ) {
					if(beneficiaire.getAge()<25){
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
					c.setTime(beneficiaire.getNaissance());
					int YearB = c.get(Calendar.YEAR);
					System.out.println("Date Time Benef : " + YearB);
					
					
				age = Year - YearB;
				
				beneficiaire.setAge(age);
				System.out.println("aaaaage"+" "+age);
				System.out.println("age"+" "+beneficiaire.getAge());
				
				
				if (beneficiaire.getConjoint()==1  ) {
				
					if (local.calculBenefF(beneficiaire.getVictime().getId_v())>1 ) {
						p1=(float)(vlocal.getRevenuAnnu(beneficiaire.getVictime().getId_v())*(0.8)*(0.2));
						p2=local.calculBenefF(beneficiaire.getVictime().getId_v());
				PE = (float) (renteC+(p1/p2) ) ;
				PM = (float) (2 * SMIG);
				FF = (float) (0.25 * SMIG);
				 renteb=PE+PM+FF;
				 rente.setRente(renteb);
				 rente.setPM(renteb);
				
					}
				}else if (beneficiaire.getConjoint()==0  ) {
				
					if (local.calculBenefF(beneficiaire.getVictime().getId_v())>1 ) {
				PE = (float) (renteC+( (vlocal.getRevenuAnnu(beneficiaire.getVictime().getId_v())*(0.8)*(0.5))/local.calculBenefF(beneficiaire.getVictime().getId_v()) ))  ;
				PM = (float) (2 * SMIG);
				FF = (float) (0.25 * SMIG);
				 renteb=PE+PM+FF;
				 rente.setRente(renteb);
				 rente.setPM(renteb);
				
				}  
				}
				
				
				rente.setPM(renteb);
				System.out.println("Id Victime"+beneficiaire.getVictime().getId_v());
				System.out.println("Mois"+" "+beneficiaire.getNaissance().getMonth());

				//rlocal.ajoutRente(id_benef, renteb, debut, fin);
				rulocal.ajoutRenteU(id_benef, renteb, cal.getTime(), calF.getTime(),"OUVERT");
				
				
			}

				}								
													// Fille
		
		
		
				else if (beneficiaire.getEtat().equals("Fille") ) {
					if(beneficiaire.getAge()<25){
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
					c.setTime(beneficiaire.getNaissance());
					int YearB = c.get(Calendar.YEAR);
					System.out.println("Date Time Benef : " + YearB);
					
					
				age = Year - YearB;
				
				beneficiaire.setAge(age);
				System.out.println("aaaaage"+" "+age);
				System.out.println("age"+" "+beneficiaire.getAge());
					
					if (beneficiaire.getConjoint()==1  ) {
					
						if (local.calculBenefF(beneficiaire.getVictime().getId_v())>1 ) {
					PE = (float) (renteC+( (vlocal.getRevenuAnnu(beneficiaire.getVictime().getId_v())*(0.8)*(0.2))/local.calculBenefF(beneficiaire.getVictime().getId_v()) ))  ;
					PM = (float) (2 * SMIG);
					FF = (float) (0.25 * SMIG);
					 renteb=PE+PM+FF;
					 rente.setRente(renteb);
					 rente.setPM(renteb);
					
						}
					}else if (beneficiaire.getConjoint()==0  ) {
					
						if (local.calculBenefF(beneficiaire.getVictime().getId_v())>1 ) {
					PE = (float) (renteC+( (vlocal.getRevenuAnnu(beneficiaire.getVictime().getId_v())*(0.8)*(0.5))/local.calculBenefF(beneficiaire.getVictime().getId_v()) ))  ;
					PM = (float) (2 * SMIG);
					FF = (float) (0.25 * SMIG);
					 renteb=PE+PM+FF;
					 rente.setRente(renteb);
					 rente.setPM(renteb);
					
					}
					}
					rulocal.ajoutRenteU(id_benef, renteb, cal.getTime(), calF.getTime(),"OUVERT");

				}
				
				}
				
		
		/* FIN CALCUL JIRAYA 
	
		System.out.println("Rente"+renteb);
		System.out.println("PE"+PE);
		System.out.println("PM"+PM);
		System.out.println("FF"+FF);
		System.out.println("FF"+FF);

		rente.setPM(renteb);
		System.out.println("Id Victime"+beneficiaire.getVictime().getId_v());
		System.out.println("Revenu"+vlocal.getRevenuAnnu(beneficiaire.getVictime().getId_v()));
		System.out.println("nbbenfParents"+local.calculBenefP(beneficiaire.getVictime().getId_v()));
		System.out.println("nbbenfFils"+local.calculBenefF(beneficiaire.getVictime().getId_v()));
		//rlocal.ajoutRente(id_benef, renteb, debut, fin);
 		FacesMessage msg = new FacesMessage("Successful","Une nouvelle rente a été ajoutée");
		//.addToControl("ffsCompanyForm:test", "Billing Address cannot be removed")
		FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
			init();

				}
	
	 
	*/
	public String doAdd(){
		
		local.addBeneficiaire(beneficiaire);
		
		return null;
		
	}
	public String doUpdate(){
		FacesMessage message;
		
		local.update(beneficiaire);
		System.out.println(" "+beneficiaire.getNaissance());
		
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
				c.setTime(beneficiaire.getNaissance());
				int YearB = c.get(Calendar.YEAR);
				System.out.println("Date Time Benef : " + YearB);
				
				System.out.println("Year B"+" "+YearB);
			age = Year - YearB;
			System.out.println("AGE "+" "+age);
			
				beneficiaire.setAge(age);
				
				local.update(beneficiaire);
			// ******************* FIN AGE ***********************
		message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Opération effectué avec Succés",null);
		FacesContext.getCurrentInstance().addMessage(null, message);
		init();
		return null;
		
	}
	
	public String doUp(){
		FacesMessage message;
		
		clocal.update(coefficient);
		message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Opération effectué avec Succés",null);
		FacesContext.getCurrentInstance().addMessage(null, message);
		init();
		return null;
		
	}
	
	 public String doDelete(Beneficiaire beneficiaire){
		 local.deleteBeneficiaire(beneficiaire);
		 init();
		 return null;
	 }
	 
	 public String initialiser(){
		 beneficiaire=new Beneficiaire();
		 return null;
	 }
	
	 public void RecupereIdRen(Rente r){
			id_rente=r.getId_rente();
			rente = rlocal.readByid(id_rente);
			renteC = (int) rente.getRente();
			System.out.println(id_rente+" "+"Rente"+renteC);

			
		}
	
	 public void addRenteD() {
			rente = new Rente();
			beneficiaire = local.readByid(id_benef);
			rente.setBeneficiairesR(local.readByid(id_benef));
			
			System.out.println("benef"+beneficiaire.getEtat());
	 
			/* Calcul JIRAYA */
			
													
									
													//	PERE

				if(beneficiaire.getEtat().equals("Pere") ) 
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
				c.setTime(beneficiaire.getNaissance());
				int YearB = c.get(Calendar.YEAR);
				System.out.println("Date Time Benef : " + YearB);
				
				
				age = Year - YearB;
				
				beneficiaire.setAge(age);
				System.out.println("aaaaage"+" "+age);
				System.out.println("age"+" "+beneficiaire.getAge());
				
				while(age<=100 ||  beneficiaire.getNaissance().getMonth()!=calF.getTime().getMonth()){
					int YearR = cal.get(Calendar.YEAR);
					System.out.println("AGE REGLO"+" "+calF.getTime().getYear());
					System.out.println("AGE REGLO 1 "+" "+ YearR);
			
					age = YearR - YearB;
					System.out.println("aaaaage jdid"+" "+age);
					System.out.println("age jdiddd"+" "+beneficiaire.getAge());
					
				p1=(int) (vlocal.getRevenuAnnu(beneficiaire.getVictime().getId_v())*(0.8)*(0.1));
				p2=(int) local.calculBenefP(beneficiaire.getVictime().getId_v());
				PE = renteC+( p1  /p2 )  ;
				PM = (int) (2 * SMIG);
				FF = (int) (0.25 * SMIG);
				renteb=PE+PM+FF;
				rente.setRente(renteb);
				rlocal.ajoutRente(id_benef, renteb, cal.getTime(), calF.getTime(),"OUVERT");

				//*****************DATE DEBUT***********************
				
				cal.add(Calendar.MONTH, 1);
				System.out.println("MOIS DEBUT " +cal.getTime().getMonth());

					
				//******************DATE FIN***********************
				
				calF.add(Calendar.MONTH, 1);

				System.out.println("MOIS FIN " +calF.getTime().getMonth());

				 
				//***********************************************

				}
				
				/***************************************************/
				
				
				Calendar calp = Calendar.getInstance();
				Calendar calpF = Calendar.getInstance();

				int Yearp = calp.get(Calendar.YEAR);
				int Dayp = calp.get(Calendar.DATE);
				int Monthp = calp.get(Calendar.MONTH);
				int Monthfp = calpF.get(Calendar.MONTH);
				
				//cal.add(Calendar.MONTH, 1);
				calpF.add(Calendar.YEAR, 1);

				
				
				System.out.println("Current Date Time Year : " + Yearp);
				System.out.println("Current Date Time Day : " + Dayp);
				System.out.println("Current Date Time Month : " + calp.getTime());
				System.out.println("Current Date Time Month FIN : " + calpF.getTime());

				
				
				Calendar cp = Calendar.getInstance();
				cp.setTime(beneficiaire.getNaissance());
				int YearpB = cp.get(Calendar.YEAR);
				System.out.println("Date Time Benef : " + YearpB);
				
				
			age = Yearp - YearpB;
			
			beneficiaire.setAge(age);
			System.out.println("aaaaage"+" "+age);
			System.out.println("age"+" "+ beneficiaire.getAge());
				
			
				System.out.println("AGE"+" " +beneficiaire.getAge());
				
				while(age<100 ){
					
					int YearpR = calp.get(Calendar.YEAR);
					 
					System.out.println("AGE REGLO"+" "+calpF.getTime().getYear());
					System.out.println("AGE REGLO 1 "+" "+ YearpR);
					 



					age = YearpR - YearpB;
					System.out.println("aaaaage jdid"+" "+age);
					System.out.println("age jdiddd"+" "+ beneficiaire.getAge());
					
				rentepm = BigInteger.valueOf((long)(renteb *(clocal.getCoefP(age))*12))  ;
				

				rente.setPM(rentepm);
				
				rpmlocal.ajoutRentePMPN(beneficiaire.getId_b(), rente.getRente(),age, rentepm, true,  calp.getTime(), calpF.getTime());

				//*****************ANNEE SUIVANTE***********************
				
				calp.add(Calendar.YEAR, 1);
				calpF.add(Calendar.YEAR, 1);
				System.out.println("YEAR NEXT " +calp.getTime().getYear());
				System.out.println("YEAR NEXT 11" +" " +calp.get(Calendar.YEAR));


				 
				//***********************************************
				

			} 
				
				
				
				/***********************************************************/
				
				 

				 
				}
				
				
										//	PETIT FILS

				else if(beneficiaire.getEtat().equals("PetitFils") ) 
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
						c.setTime(beneficiaire.getNaissance());
						int YearB = c.get(Calendar.YEAR);
						System.out.println("Date Time Benef : " + YearB);
						
						
						age = Year - YearB;
						
						beneficiaire.setAge(age);
						System.out.println("aaaaage"+" "+age);
						System.out.println("age"+" "+beneficiaire.getAge());
						
						while(age<=100 ||  beneficiaire.getNaissance().getMonth()!=calF.getTime().getMonth()){
						int YearR = cal.get(Calendar.YEAR);
						System.out.println("AGE REGLO"+" "+calF.getTime().getYear());
						System.out.println("AGE REGLO 1 "+" "+ YearR);
						
						age = YearR - YearB;
						System.out.println("aaaaage jdid"+" "+age);
						System.out.println("age jdiddd"+" "+beneficiaire.getAge());
						
						p1=(int) (vlocal.getRevenuAnnu(beneficiaire.getVictime().getId_v())*(0.8)*(0.1));
						p2=(int) local.calculBenefP(beneficiaire.getVictime().getId_v());
						PE = renteC+( p1  /p2 )  ;
						PM = (int) (2 * SMIG);
						FF = (int) (0.25 * SMIG);
						renteb=PE+PM+FF;
						rente.setRente(renteb);
						rlocal.ajoutRente(id_benef, renteb, cal.getTime(), calF.getTime(),"OUVERT");
						
						//*****************DATE DEBUT***********************
						
						cal.add(Calendar.MONTH, 1);
						System.out.println("MOIS DEBUT " +cal.getTime().getMonth());
						
						
						//******************DATE FIN***********************
						
						calF.add(Calendar.MONTH, 1);
						
						System.out.println("MOIS FIN " +calF.getTime().getMonth());
						
						
						//***********************************************
						
						}
						
						/***************************************************/
						
						
						Calendar calp = Calendar.getInstance();
						Calendar calpF = Calendar.getInstance();
						
						int Yearp = calp.get(Calendar.YEAR);
						int Dayp = calp.get(Calendar.DATE);
						int Monthp = calp.get(Calendar.MONTH);
						int Monthfp = calpF.get(Calendar.MONTH);
						
						//cal.add(Calendar.MONTH, 1);
						calpF.add(Calendar.YEAR, 1);
						
						
						
						System.out.println("Current Date Time Year : " + Yearp);
						System.out.println("Current Date Time Day : " + Dayp);
						System.out.println("Current Date Time Month : " + calp.getTime());
						System.out.println("Current Date Time Month FIN : " + calpF.getTime());
						
						
						
						Calendar cp = Calendar.getInstance();
						cp.setTime(beneficiaire.getNaissance());
						int YearpB = cp.get(Calendar.YEAR);
						System.out.println("Date Time Benef : " + YearpB);
						
						
						age = Yearp - YearpB;
						
						beneficiaire.setAge(age);
						System.out.println("aaaaage"+" "+age);
						System.out.println("age"+" "+ beneficiaire.getAge());
						
						
						System.out.println("AGE"+" " +beneficiaire.getAge());
						
						while(age<100 ){
						
						int YearpR = calp.get(Calendar.YEAR);
						
						System.out.println("AGE REGLO"+" "+calpF.getTime().getYear());
						System.out.println("AGE REGLO 1 "+" "+ YearpR);
						
						
						
						
						age = YearpR - YearpB;
						System.out.println("aaaaage jdid"+" "+age);
						System.out.println("age jdiddd"+" "+ beneficiaire.getAge());
						
						rentepm = BigInteger.valueOf((long)(renteb *(clocal.getCoefP(age))*12))  ;
						
						
						rente.setPM(rentepm);
						
						rpmlocal.ajoutRentePMPN(beneficiaire.getId_b(), rente.getRente(),age, rentepm, true,  calp.getTime(), calpF.getTime());
						
						//*****************ANNEE SUIVANTE***********************
						
						calp.add(Calendar.YEAR, 1);
						calpF.add(Calendar.YEAR, 1);
						System.out.println("YEAR NEXT " +calp.getTime().getYear());
						System.out.println("YEAR NEXT 11" +" " +calp.get(Calendar.YEAR));
						
						
						
						//***********************************************
						
						
						} 
						
						
						
						/***********************************************************/
						
						
						
						
						}
				
							// MERE
				
				else if (beneficiaire.getEtat().equals("Mere") ) {
				
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
				c.setTime(beneficiaire.getNaissance());
				int YearB = c.get(Calendar.YEAR);
				System.out.println("Date Time Benef : " + YearB);
				
				
				age = Year - YearB;
				
				beneficiaire.setAge(age);
				System.out.println("aaaaage"+" "+age);
				System.out.println("age"+" "+beneficiaire.getAge());
				
				while(age<=100 ||  beneficiaire.getNaissance().getMonth()!=calF.getTime().getMonth()){
					int YearR = cal.get(Calendar.YEAR);
					System.out.println("AGE REGLO"+" "+calF.getTime().getYear());
					System.out.println("AGE REGLO 1 "+" "+ YearR);
			
					age = YearR - YearB;
					System.out.println("aaaaage jdid"+" "+age);
					System.out.println("age jdiddd"+" "+beneficiaire.getAge());
				
				PE = (int) (renteC+( (vlocal.getRevenuAnnu(beneficiaire.getVictime().getId_v())*(0.8)*(0.1))/(local.calculBenefP(beneficiaire.getVictime().getId_v())) ))  ;
				PM = (int) (2 * SMIG);
				FF = (int) (0.25 * SMIG);
				renteb=PE+PM+FF;
				rente.setRente(renteb);
				rlocal.ajoutRente(id_benef, renteb, cal.getTime(), calF.getTime(),"OUVERT");

				//*****************DATE DEBUT***********************
				
				cal.add(Calendar.MONTH, 1);
				System.out.println("MOIS DEBUT " +cal.getTime().getMonth());

					
				//******************DATE FIN***********************
				
				calF.add(Calendar.MONTH, 1);

				System.out.println("MOIS FIN " +calF.getTime().getMonth());

				 
				//***********************************************
				
				}
				
/***************************************************/
				
				
				Calendar calp = Calendar.getInstance();
				Calendar calpF = Calendar.getInstance();

				int Yearp = calp.get(Calendar.YEAR);
				int Dayp = calp.get(Calendar.DATE);
				int Monthp = calp.get(Calendar.MONTH);
				int Monthfp = calpF.get(Calendar.MONTH);
				
				//cal.add(Calendar.MONTH, 1);
				calpF.add(Calendar.YEAR, 1);

				
				
				System.out.println("Current Date Time Year : " + Yearp);
				System.out.println("Current Date Time Day : " + Dayp);
				System.out.println("Current Date Time Month : " + calp.getTime());
				System.out.println("Current Date Time Month FIN : " + calpF.getTime());

				
				
				Calendar cp = Calendar.getInstance();
				cp.setTime(beneficiaire.getNaissance());
				int YearpB = cp.get(Calendar.YEAR);
				System.out.println("Date Time Benef : " + YearpB);
				
				
			age = Yearp - YearpB;
			
			beneficiaire.setAge(age);
			System.out.println("aaaaage"+" "+age);
			System.out.println("age"+" "+ beneficiaire.getAge());
				
			
				System.out.println("AGE"+" " +beneficiaire.getAge());
				
				while(age<100 ){
					
					int YearpR = calp.get(Calendar.YEAR);
					 
					System.out.println("AGE REGLO"+" "+calpF.getTime().getYear());
					System.out.println("AGE REGLO 1 "+" "+ YearpR);
					 



					age = YearpR - YearpB;
					System.out.println("aaaaage jdid"+" "+age);
					System.out.println("age jdiddd"+" "+ beneficiaire.getAge());
					
					rentepm = BigInteger.valueOf((long)(renteb *(clocal.getCoefP(age))*12))  ;
					
					rente.setPM(rentepm);
					
					rpmlocal.ajoutRentePMPN(beneficiaire.getId_b(), rente.getRente(), age,rentepm, true,  calp.getTime(), calpF.getTime());

				
				//*****************ANNEE SUIVANTE***********************
				calp.add(Calendar.YEAR, 1);
				calpF.add(Calendar.YEAR, 1);
				System.out.println("YEAR NEXT " +calp.getTime().getYear());
				System.out.println("YEAR NEXT 11" +" " +calp.get(Calendar.YEAR));


				 
				//***********************************************
				
				
			} 
				
				
				
				/***********************************************************/
				} 
				
				
				
							// Veuve
				
				else if (beneficiaire.getEtat().equals("Veuve") ) {
				
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
				c.setTime(beneficiaire.getNaissance());
				int YearB = c.get(Calendar.YEAR);
				System.out.println("Date Time Benef : " + YearB);
				
				
				age = Year - YearB;
				
				beneficiaire.setAge(age);
				System.out.println("aaaaage"+" "+age);
				System.out.println("age"+" "+beneficiaire.getAge());
				
				while(age<=100 ||  beneficiaire.getNaissance().getMonth()!=calF.getTime().getMonth()){
					int YearR = cal.get(Calendar.YEAR);
					System.out.println("AGE REGLO"+" "+calF.getTime().getYear());
					System.out.println("AGE REGLO 1 "+" "+ YearR);
			
					age = YearR - YearB;
					System.out.println("aaaaage jdid"+" "+age);
					System.out.println("age jdiddd"+" "+beneficiaire.getAge());
					
				if (local.calculBenefF(beneficiaire.getVictime().getId_v())>1 ) {
				
				PE = (int) (renteC+( (vlocal.getRevenuAnnu(beneficiaire.getVictime().getId_v())*(0.8)*(0.4)) ))  ;
				PM = (int) (2.5 * SMIG);
				FF = (int) (0.25 * SMIG);
				renteb=PE+PM+FF;
				rente.setRente(renteb);
 				}
				else {
				
				PE = (int) (renteC+( (vlocal.getRevenuAnnu(beneficiaire.getVictime().getId_v())*(0.8)*(0.5)) ))  ;
				PM = (int) (2.5 * SMIG);
				FF = (int) (0.25 * SMIG);
				renteb=PE+PM+FF;
				rente.setRente(renteb);
 				}
				rlocal.ajoutRente(id_benef, renteb, cal.getTime(), calF.getTime(),"OUVERT");

				//*****************DATE DEBUT***********************
				
				cal.add(Calendar.MONTH, 1);
				System.out.println("MOIS DEBUT " +cal.getTime().getMonth());

					
				//******************DATE FIN***********************
				
				calF.add(Calendar.MONTH, 1);

				System.out.println("MOIS FIN " +calF.getTime().getMonth());

				 
				//***********************************************
				
				}
/***************************************************/
				
				
				Calendar calp = Calendar.getInstance();
				Calendar calpF = Calendar.getInstance();

				int Yearp = calp.get(Calendar.YEAR);
				int Dayp = calp.get(Calendar.DATE);
				int Monthp = calp.get(Calendar.MONTH);
				int Monthfp = calpF.get(Calendar.MONTH);
				
				//cal.add(Calendar.MONTH, 1);
				calpF.add(Calendar.YEAR, 1);

				
				
				System.out.println("Current Date Time Year : " + Yearp);
				System.out.println("Current Date Time Day : " + Dayp);
				System.out.println("Current Date Time Month : " + calp.getTime());
				System.out.println("Current Date Time Month FIN : " + calpF.getTime());

				
				
				Calendar cp = Calendar.getInstance();
				cp.setTime(beneficiaire.getNaissance());
				int YearpB = cp.get(Calendar.YEAR);
				System.out.println("Date Time Benef : " + YearpB);
				
				
			age = Yearp - YearpB;
			
			beneficiaire.setAge(age);
			System.out.println("aaaaage"+" "+age);
			System.out.println("age"+" "+ beneficiaire.getAge());
				
			
				System.out.println("AGE"+" " +beneficiaire.getAge());
				
				while(age<100 ){
					
					int YearpR = calp.get(Calendar.YEAR);
					 
					System.out.println("AGE REGLO"+" "+calpF.getTime().getYear());
					System.out.println("AGE REGLO 1 "+" "+ YearpR);
					 



					age = YearpR - YearpB;
					System.out.println("aaaaage jdid"+" "+age);
					System.out.println("age jdiddd"+" "+ beneficiaire.getAge());
					
					rentepm = BigInteger.valueOf((long)(renteb *(clocal.getCoefP(age))*12))  ;
					
					rente.setPM(rentepm);
					
					rpmlocal.ajoutRentePMPN(beneficiaire.getId_b(), rente.getRente(),age, rentepm, true,  calp.getTime(), calpF.getTime());

				//*****************ANNEE SUIVANTE***********************
				
				calp.add(Calendar.YEAR, 1);
				calpF.add(Calendar.YEAR, 1);
				System.out.println("YEAR NEXT " +calp.getTime().getYear());
				System.out.println("YEAR NEXT 11" +" " +calp.get(Calendar.YEAR));


				 
				//***********************************************
				
				
			} 
				
				
				
				/***********************************************************/
				}		
							// Fils
				
				
				else if (beneficiaire.getEtat().equals("Fils") ) {
				if(beneficiaire.getAge()<25){
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
				c.setTime(beneficiaire.getNaissance());
				int YearB = c.get(Calendar.YEAR);
				System.out.println("Date Time Benef : " + YearB);
				
				
				age = Year - YearB;
				
				beneficiaire.setAge(age);
				System.out.println("aaaaage"+" "+age);
				System.out.println("age"+" "+beneficiaire.getAge());
				
				while( age<25 || beneficiaire.getNaissance().getMonth()!=calF.getTime().getMonth() ){
 					int YearR = cal.get(Calendar.YEAR);
					System.out.println("AGE REGLO"+" "+calF.getTime().getYear());
					System.out.println("AGE REGLO 1 "+" "+ YearR);
			
					age = YearR - YearB;
					System.out.println("aaaaage jdid"+" "+age);
					System.out.println("age jdiddd"+" "+beneficiaire.getAge());
				if (beneficiaire.getConjoint()==1  ) {
				
				if (local.calculBenefF(beneficiaire.getVictime().getId_v())>1 ) {
				p1=(int)(vlocal.getRevenuAnnu(beneficiaire.getVictime().getId_v())*(0.8)*(0.2));
				p2=(int) local.calculBenefF(beneficiaire.getVictime().getId_v());
				PE = (int) (renteC+(p1/p2) ) ;
				PM = (int) (2 * SMIG);
				FF = (int) (0.25 * SMIG);
				renteb=PE+PM+FF;
				rente.setRente(renteb);
 				
				}
				}else if (beneficiaire.getConjoint()==0  ) {
				
				if (local.calculBenefF(beneficiaire.getVictime().getId_v())>1 ) {
				PE = (int) (renteC+( (vlocal.getRevenuAnnu(beneficiaire.getVictime().getId_v())*(0.8)*(0.5))/local.calculBenefF(beneficiaire.getVictime().getId_v()) ))  ;
				PM = (int) (2 * SMIG);
				FF = (int) (0.25 * SMIG);
				renteb=PE+PM+FF;
				rente.setRente(renteb);
 				
				}  
				}
				
				
 				System.out.println("Id Victime"+beneficiaire.getVictime().getId_v());
				System.out.println("Mois"+" "+beneficiaire.getNaissance().getMonth());
				
				//rlocal.ajoutRente(id_benef, renteb, debut, fin);
				
				rlocal.ajoutRente(id_benef, renteb, cal.getTime(), calF.getTime(),"OUVERT");

				//*****************DATE DEBUT***********************
				
				cal.add(Calendar.MONTH, 1);
				System.out.println("MOIS DEBUT " +cal.getTime().getMonth());

					
				//******************DATE FIN***********************
				
				calF.add(Calendar.MONTH, 1);

				System.out.println("MOIS FIN " +calF.getTime().getMonth());

				 
				//***********************************************
				}
				
				}
				/***************************************************/
				
				
				Calendar calp = Calendar.getInstance();
				Calendar calpF = Calendar.getInstance();

				int Yearp = calp.get(Calendar.YEAR);
				int Dayp = calp.get(Calendar.DATE);
				int Monthp = calp.get(Calendar.MONTH);
				int Monthfp = calpF.get(Calendar.MONTH);
				
				//cal.add(Calendar.MONTH, 1);
				calpF.add(Calendar.YEAR, 1);

				
				
				System.out.println("Current Date Time Year : " + Yearp);
				System.out.println("Current Date Time Day : " + Dayp);
				System.out.println("Current Date Time Month : " + calp.getTime());
				System.out.println("Current Date Time Month FIN : " + calpF.getTime());

				
				
				Calendar cp = Calendar.getInstance();
				cp.setTime(beneficiaire.getNaissance());
				int YearpB = cp.get(Calendar.YEAR);
				System.out.println("Date Time Benef : " + YearpB);
				
				
			age = Yearp - YearpB;
			
			beneficiaire.setAge(age);
			System.out.println("aaaaage"+" "+age);
			System.out.println("age"+" "+ beneficiaire.getAge());
				
			
				System.out.println("AGE"+" " +beneficiaire.getAge());
				
				while(age<25 ){
					
					int YearpR = calp.get(Calendar.YEAR);
					 
					System.out.println("AGE REGLO"+" "+calpF.getTime().getYear());
					System.out.println("AGE REGLO 1 "+" "+ YearpR);
					System.out.println("Date Time Benef : " + YearpB);
					 

					age = YearpR - YearpB;
					System.out.println("aaaaage jdid"+" "+age);
					System.out.println("age jdiddd"+" "+ beneficiaire.getAge());
					
				rentepm = BigInteger.valueOf((long)(renteb *(25-age)*12))  ;
				System.out.println("Renteb"+" "+renteb+" "+rente.getRente());
				System.out.println(renteC *(clocal.getCoefP(age))*12);
				System.out.println("ehim"+" "+renteC *(renteb *(25-age)*12));

				rente.setPM(rentepm);
				System.out.println("rente table"+" "+rente.getPM());
				System.out.println("rente table PM"+" "+rentepm);

				
				
				

				 
				//***********************************************
				
				rpmlocal.ajoutRentePMPN(beneficiaire.getId_b(), rente.getRente(), age,rentepm, true,  calp.getTime(), calpF.getTime());
				//*****************ANNEE SUIVANTE***********************
				calp.add(Calendar.YEAR, 1);
				calpF.add(Calendar.YEAR, 1);
				System.out.println("YEAR NEXT " +calp.getTime().getYear());
				System.out.println("YEAR NEXT 11" +" " +calp.get(Calendar.YEAR));

				
			} 
				
				
				
				/***********************************************************/
				}								
							// Fille
				
				
				
				else if (beneficiaire.getEtat().equals("Fille") ) {
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
				c.setTime(beneficiaire.getNaissance());
				int YearB = c.get(Calendar.YEAR);
				System.out.println("Date Time Benef : " + YearB);
				
				
				age = Year - YearB;
				
				beneficiaire.setAge(age);
				System.out.println("aaaaage"+" "+age);
				System.out.println("age"+" "+beneficiaire.getAge());
				
				while(age<=100 ||  beneficiaire.getNaissance().getMonth()!=calF.getTime().getMonth()){
					int YearR = cal.get(Calendar.YEAR);
					System.out.println("AGE REGLO"+" "+calF.getTime().getYear());
					System.out.println("AGE REGLO 1 "+" "+ YearR);
			
					System.out.println("Current Date Time Year : " + YearR);
					System.out.println("Current Date Time Day : " + Day);
					System.out.println("Current Date Time Month : " + cal.getTime());
					System.out.println("Current Date Time Month FIN : " + calF.getTime());
					
					age = YearR - YearB;
					System.out.println("aaaaage jdid"+" "+age);
					System.out.println("age jdiddd"+" "+beneficiaire.getAge());
					
				if (beneficiaire.getConjoint()==1  ) {
				
				if (local.calculBenefF(beneficiaire.getVictime().getId_v())>1 ) {
				PE = (int) (renteC+( (vlocal.getRevenuAnnu(beneficiaire.getVictime().getId_v())*(0.8)*(0.2))/local.calculBenefF(beneficiaire.getVictime().getId_v()) ))  ;
				PM = (int) (2 * SMIG);
				FF = (int) (0.25 * SMIG);
				renteb=PE+PM+FF;
				rente.setRente(renteb);
 				
				}
				}else if (beneficiaire.getConjoint()==0  ) {
				
				if (local.calculBenefF(beneficiaire.getVictime().getId_v())>1 ) {
				PE = (int) (renteC+( (vlocal.getRevenuAnnu(beneficiaire.getVictime().getId_v())*(0.8)*(0.5))/local.calculBenefF(beneficiaire.getVictime().getId_v()) ))  ;
				PM = (int) (2 * SMIG);
				FF = (int) (0.25 * SMIG);
				renteb=PE+PM+FF;
				rente.setRente(renteb);
				}
				}
				
				rlocal.ajoutRente(id_benef, renteb, cal.getTime(), calF.getTime(),"OUVERT");

				//*****************DATE DEBUT***********************
				
				cal.add(Calendar.MONTH, 1);
				System.out.println("MOIS DEBUT " +cal.getTime().getMonth());

					
				//******************DATE FIN***********************
				
				calF.add(Calendar.MONTH, 1);

				System.out.println("MOIS FIN " +calF.getTime().getMonth());

				 
				//***********************************************

				}
				
				/***************************************************/
				
				
				Calendar calp = Calendar.getInstance();
				Calendar calpF = Calendar.getInstance();

				int Yearp = calp.get(Calendar.YEAR);
				int Dayp = calp.get(Calendar.DATE);
				int Monthp = calp.get(Calendar.MONTH);
				int Monthfp = calpF.get(Calendar.MONTH);
				
				//cal.add(Calendar.MONTH, 1);
				calpF.add(Calendar.YEAR, 1);

				
				
				System.out.println("Current Date Time Year : " + Yearp);
				System.out.println("Current Date Time Day : " + Dayp);
				System.out.println("Current Date Time Month : " + calp.getTime());
				System.out.println("Current Date Time Month FIN : " + calpF.getTime());

				
				
				Calendar cp = Calendar.getInstance();
				cp.setTime(beneficiaire.getNaissance());
				int YearpB = cp.get(Calendar.YEAR);
				System.out.println("Date Time Benef : " + YearpB);
				
				
			age = Yearp - YearpB;
			
			beneficiaire.setAge(age);
			System.out.println("aaaaage"+" "+age);
			System.out.println("age"+" "+ beneficiaire.getAge());
				
			
				System.out.println("AGE"+" " +beneficiaire.getAge());
				
				while(age<100 ){
					
					int YearpR = calp.get(Calendar.YEAR);
					 
					System.out.println("AGE REGLO"+" "+calpF.getTime().getYear());
					System.out.println("AGE REGLO 1 "+" "+ YearpR);
					 



					age = YearpR - YearpB;
					System.out.println("aaaaage jdid"+" "+age);
					System.out.println("age jdiddd"+" "+ beneficiaire.getAge());
					
					rentepm = BigInteger.valueOf((long)(renteb *(clocal.getCoefP(age))*12))  ;
				
				rente.setPM(rentepm);
				
				rpmlocal.ajoutRentePMPN(beneficiaire.getId_b(), rente.getRente(),age, rentepm, true,  calp.getTime(), calpF.getTime());

				//*****************ANNEE SUIVANTE***********************
				
				calp.add(Calendar.YEAR, 1);
				calpF.add(Calendar.YEAR, 1);

				System.out.println("YEAR NEXT " +calp.getTime().getYear());
				System.out.println("YEAR NEXT 11" +" " +calp.get(Calendar.YEAR));


				 
				//***********************************************
				
				
			} 
				
				
				
				/***********************************************************/
				
				
				}
				

				
										// ( Fils || Fille ) Handicapés
				
				
				
				else if (beneficiaire.getEtat().equals("Handicape") ) {
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
				c.setTime(beneficiaire.getNaissance());
				int YearB = c.get(Calendar.YEAR);
				System.out.println("Date Time Benef : " + YearB);
				
				
				age = Year - YearB;
				
				beneficiaire.setAge(age);
				System.out.println("aaaaage"+" "+age);
				System.out.println("age"+" "+beneficiaire.getAge());
				
				while(age<=100 ||  beneficiaire.getNaissance().getMonth()!=calF.getTime().getMonth()){
					int YearR = cal.get(Calendar.YEAR);
					System.out.println("AGE REGLO"+" "+calF.getTime().getYear());
					System.out.println("AGE REGLO 1 "+" "+ YearR);
			
					System.out.println("Current Date Time Year : " + YearR);
					System.out.println("Current Date Time Day : " + Day);
					System.out.println("Current Date Time Month : " + cal.getTime());
					System.out.println("Current Date Time Month FIN : " + calF.getTime());
					
					age = YearR - YearB;
					System.out.println("aaaaage jdid"+" "+age);
					System.out.println("age jdiddd"+" "+beneficiaire.getAge());
					
				if (beneficiaire.getConjoint()==1  ) {
				
				if (local.calculBenefF(beneficiaire.getVictime().getId_v())>1 ) {
				PE = (int) (renteC+( (vlocal.getRevenuAnnu(beneficiaire.getVictime().getId_v())*(0.8)*(0.2))/local.calculBenefF(beneficiaire.getVictime().getId_v()) ))  ;
				PM = (int) (2 * SMIG);
				FF = (int) (0.25 * SMIG);
				renteb=PE+PM+FF;
				rente.setRente(renteb);
 				
				}
				}else if (beneficiaire.getConjoint()==0  ) {
				
				if (local.calculBenefF(beneficiaire.getVictime().getId_v())>1 ) {
				PE = (int) (renteC+( (vlocal.getRevenuAnnu(beneficiaire.getVictime().getId_v())*(0.8)*(0.5))/local.calculBenefF(beneficiaire.getVictime().getId_v()) ))  ;
				PM = (int) (2 * SMIG);
				FF = (int) (0.25 * SMIG);
				renteb=PE+PM+FF;
				rente.setRente(renteb);
				}
				}
				
				rlocal.ajoutRente(id_benef, renteb, cal.getTime(), calF.getTime(),"OUVERT");

				//*****************DATE DEBUT***********************
				
				cal.add(Calendar.MONTH, 1);
				System.out.println("MOIS DEBUT " +cal.getTime().getMonth());

					
				//******************DATE FIN***********************
				
				calF.add(Calendar.MONTH, 1);

				System.out.println("MOIS FIN " +calF.getTime().getMonth());

				 
				//***********************************************

				}
				
				/***************************************************/
				
				
				Calendar calp = Calendar.getInstance();
				Calendar calpF = Calendar.getInstance();

				int Yearp = calp.get(Calendar.YEAR);
				int Dayp = calp.get(Calendar.DATE);
				int Monthp = calp.get(Calendar.MONTH);
				int Monthfp = calpF.get(Calendar.MONTH);
				
				//cal.add(Calendar.MONTH, 1);
				calpF.add(Calendar.YEAR, 1);

				
				
				System.out.println("Current Date Time Year : " + Yearp);
				System.out.println("Current Date Time Day : " + Dayp);
				System.out.println("Current Date Time Month : " + calp.getTime());
				System.out.println("Current Date Time Month FIN : " + calpF.getTime());

				
				
				Calendar cp = Calendar.getInstance();
				cp.setTime(beneficiaire.getNaissance());
				int YearpB = cp.get(Calendar.YEAR);
				System.out.println("Date Time Benef : " + YearpB);
				
				
			age = Yearp - YearpB;
			
			beneficiaire.setAge(age);
			System.out.println("aaaaage"+" "+age);
			System.out.println("age"+" "+ beneficiaire.getAge());
				
			
				System.out.println("AGE"+" " +beneficiaire.getAge());
				
				while(age<100 ){
					
					int YearpR = calp.get(Calendar.YEAR);
					 
					System.out.println("AGE REGLO"+" "+calpF.getTime().getYear());
					System.out.println("AGE REGLO 1 "+" "+ YearpR);
					 



					age = YearpR - YearpB;
					System.out.println("aaaaage jdid"+" "+age);
					System.out.println("age jdiddd"+" "+ beneficiaire.getAge());
					
					rentepm = BigInteger.valueOf((long)(renteb *(clocal.getCoefP(age))*12))  ;
				
				rente.setPM(rentepm);
				
				rpmlocal.ajoutRentePMPN(beneficiaire.getId_b(), rente.getRente(),age, rentepm, true,  calp.getTime(), calpF.getTime());

				//*****************ANNEE SUIVANTE***********************
				
				calp.add(Calendar.YEAR, 1);
				calpF.add(Calendar.YEAR, 1);

				System.out.println("YEAR NEXT " +calp.getTime().getYear());
				System.out.println("YEAR NEXT 11" +" " +calp.get(Calendar.YEAR));


				 
				//***********************************************
				
				
			} 
				
				
				
				/***********************************************************/
				
				
				}
				
				
				
				/* FIN CALCUL JIRAYA */ 
				
				System.out.println("Rente"+renteb);
				System.out.println("PE"+PE);
				System.out.println("PM"+PM);
				System.out.println("FF"+FF);
				System.out.println("FF"+FF);
				
				System.out.println("Id Victime"+beneficiaire.getVictime().getId_v());
				System.out.println("Revenu"+vlocal.getRevenuAnnu(beneficiaire.getVictime().getId_v()));
				System.out.println("nbbenfParents"+local.calculBenefP(beneficiaire.getVictime().getId_v()));
				System.out.println("nbbenfFils"+local.calculBenefF(beneficiaire.getVictime().getId_v()));
				//rlocal.ajoutRente(id_benef, renteb, debut, fin);
				FacesMessage msg = new FacesMessage("Successful","Une nouvelle rente a été ajoutée");
				//.addToControl("ffsCompanyForm:test", "Billing Address cannot be removed")
				FacesContext.getCurrentInstance().addMessage(null, msg);
				FacesContext context = FacesContext.getCurrentInstance();
				context.getExternalContext().getFlash().setKeepMessages(true);
				init();

			
	 }
	 
}
