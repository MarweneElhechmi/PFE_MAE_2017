package managedBean;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.atp.DateParser;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.usermodel.DateUtil;

import tn.esprit.MaE.Interface.GestionnaireSinistreServiceLocal;
import tn.esprit.MaE.Interface.SinistreServiceLocal;
import tn.esprit.MaE.Interface.VictimeServiceLocal;
import tn.esprit.MaE.entities.AgentGeneral;
import tn.esprit.MaE.entities.Sinistre;
import tn.esprit.MaE.entities.Victime;

/**
 * @author marwe
 *
 */
@ManagedBean
@ViewScoped
public class SinistreBean {
	
	@ManagedProperty("#{identityB.identifieduser}")
	private AgentGeneral agent;
	
	@EJB
	GestionnaireSinistreServiceLocal gssl;
	
	@EJB
	SinistreServiceLocal local;
	
	@EJB
	VictimeServiceLocal vlocal;

	static ArrayList values = new ArrayList();



	private List<Sinistre>sinistresFiltred;

	private List<Sinistre>sinistres=new ArrayList<>();
	private List<Sinistre>sinistres1=new ArrayList<>();
	private List<Sinistre>sinistresV=new ArrayList<>();
	private Sinistre sinistre=new Sinistre();
	
	private List<Victime>victimesFiltred;
	private List<Victime>victimes=new ArrayList<>();
	private Victime victime=new Victime();
	
		// VICTIME
	
	private String cin_v;
	private String nom;
	private String prenom;
	private String profession;
	private int revenu;
	private Date naissance;
	private Date deces;
	private int nb_b;
	static private  int id_s;
	
		// SINISTRE
	private int numero;
	private String nom_assure;
	private Date dateSurvenance;
	private Date dateDeclaration;
	private int N_Police;
	
	public AgentGeneral getAgent() {
		return agent;
	}

	public void setAgent(AgentGeneral agent) {
		this.agent = agent;
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

	public static int getId_s() {
		return id_s;
	}

	public static void setId_s(int id_s) {
		SinistreBean.id_s = id_s;
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
		sinistre.setDateSurvenance(dateSurvenance);
		int idag = agent.getId_u();
		local.ajoutSinistre(idag, numero, nom_assure,"Ajout Simple", dateSurvenance,dateDeclaration, N_Police);
		message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Opération effectué avec Succés",null);
		FacesContext.getCurrentInstance().addMessage(null, message);
		init();
		return null;
		
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
	 
	
	 
	 public String Page(Sinistre s){
		 id_s=s.getId();
			System.out.println(id_s);
		return "/pages/GestionnaireSinistre/Victime?faces-redirect=true"; 
	 }
	 
	  
										/* SINISTRE */
	 
	 
	 public void ExcelReadS() throws IOException {

  	   File file = new File("C:/MAE/Sinistre.xls");
  	   //"C:/IDE/workspace/PFE/Mae/Mae-web/src/main/webapp/pages/Coefrente.xls"
  	  // "C:/IDE/workspace/PFE/Mae/Mae-web/src/main/webapp/pages/"
  	   InputStream ExcelFileToRead = new FileInputStream(file);
 		HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);

 		HSSFSheet sheet=wb.getSheetAt(0);
		HSSFRow row; 
		HSSFCell cell;

		Iterator rows = sheet.rowIterator();

		while (rows.hasNext())
		{
			values.clear();
			row=(HSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			
			while (cells.hasNext())
			{
				cell=(HSSFCell) cells.next();
		
				if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
				{
					 values.add((String)cell.getStringCellValue());

					System.out.print(cell.getStringCellValue()+" ");
				}
				else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
				{	
					values.add((double)cell.getNumericCellValue());
					System.out.print(cell.getNumericCellValue()+" ");
					
					//clocal.ajoutCoeff(values.get(0), values.get(1), values.get(2));

				}
				else
				{
					//U Can Handel Boolean, Formula, Errors
				}
			}
			System.out.println();
			System.out.print(values+"INFINI ");
			System.out.print(values.size()+"SIZE ");
			
			
			
			

			for(int i=0;i<values.size()-4;i++){
		
				
				Double y = (Double) values.get(0);
				int x = Integer.valueOf(y.intValue());
				
				Double y1 = (Double) values.get(3);
				int x1 = Integer.valueOf(y1.intValue());
				
				System.out.print("VALEUR 1- "+" " +x);

				if(local.Doublons(x)==0){
				 Date javaDate= DateUtil.getJavaDate((double) values.get(1));
			        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(javaDate));
			        
			        Date javaDate1= DateUtil.getJavaDate((double) values.get(2));
			        System.out.println(new SimpleDateFormat("MM/dd/yyyy").format(javaDate1));
			        
			System.out.print("VALEUR 1- "+" " +y);
			System.out.print("VALEUR 2-- "+" " +javaDate);
			System.out.print("VALEUR 3--- "+" " +javaDate1);
			System.out.print("VALEUR 4---- "+" " +x1);
			System.out.print("VALEUR 5----- "+" " +values.get(4));
			local.ajoutSinistre(agent.getId_u(), x, (String) values.get(4), "Upload" ,javaDate,javaDate1,x1);

			}
			}
			 
		}
		
		
		FacesMessage message = new FacesMessage("Succesful",  " EXCEL uploaded.");
      FacesContext.getCurrentInstance().addMessage(null, message);

     }
     
								
								
	 }

