package managedBean;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.jmx.Agent;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import tn.esprit.MaE.entities.AgentGeneral;
import tn.esprit.MaE.entities.Coefficient;
import tn.esprit.MaE.services.CoefficientService;
import tn.esprit.MaE.services.SinistreService;

@ManagedBean
@ViewScoped
public class Bean {

	
	@EJB 
	CoefficientService clocal;
	
	@EJB 
	SinistreService slocal;
	
	Coefficient coeff = new Coefficient();
	@PersistenceContext
	EntityManager em;
	
	private static float ma ;
	private static String mag ; 
	private static float mh ; 
	private static float mho ; 
	private static float mf ; 
	static ArrayList values = new ArrayList();
	static List data = new ArrayList();
	static List dataH = new ArrayList();
	static List dataF = new ArrayList();
	private List<Coefficient>coefficients=new ArrayList<>();

	//******************************
	private final String path_to="/C:/IDE/workspace/PFE/Mae/Mae-web/src/main/webapp/pages/";
 	private HttpServletRequest servletRequest;

	static private String lien;
	
	private Part file1;
    private String fileContent;
    
    @PostConstruct
	public void init(){
	
	coefficients=clocal.findAll();

	
	}
    
	public UploadedFile getFileh() {
		return fileh;
	}

	public void setFileh(UploadedFile fileh) {
		this.fileh = fileh;
	}

	public String getFileContent() {
		return fileContent;
	}

	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}
	//*******************************
	


	

	private UploadedFile fileh;
	 
	    public UploadedFile getFile() {
	        return fileh;
	    }
	 
	    public void setFile(UploadedFile fileh) {
	        this.fileh = fileh;
	    }
	 
	    private File ress ; 
	    
	    
	    
	    // *********** DEEEEEEEEEEBUT JDID ***************
	   
	    public File getRess() {
			return ress;
		}

		public void setRess(File ress) {
			this.ress = ress;
		}

		public void upload() {
	      try {
	        fileContent = new Scanner(file1.getInputStream())
	            .useDelimiter("\\A").next();
	        
	        System.out.println("HELLO");
	        System.out.println("FILE SIZE"+" "+file1.getSize());
	        System.out.println("FILE TYPE"+" "+file1.getContentType());
	        System.out.println("FILE SUB"+" "+file1.getSubmittedFileName());
	        System.out.println("FILE NAME"+" "+file1.getInputStream());
	        System.out.println("FILE NAME"+" "+file1.getHeaderNames());
	        


	      } catch (IOException e) {
	        // Error handling
	      }
	    }
	   
	    
	    
	    public void setFile1(Part file1) {
			this.file1 = file1;
		}

		public Part getFile1() {
	      return file1;
	    }
	   
	    
	    
	    public void validateFile(FacesContext ctx, UIComponent comp,Object value) {
				List<FacesMessage> msgs = new ArrayList<FacesMessage>();
				Part file = (Part)value;
				if (file.getSize() > 1024) {
				msgs.add(new FacesMessage("file too big"));
				}
				if (!"text/plain".equals(file.getContentType())) {
				msgs.add(new FacesMessage("not a text file"));
				}
				if (!msgs.isEmpty()) {
				throw new ValidatorException(msgs);
				}
				}
	    
	    // ********** FIIIIIIIIIIIIIIN JDIIIIIIIIIIID ******************
	    public void getPath(File file){
	    	System.out.println("3assléma");
	    lien = file.getAbsolutePath();
	    System.out.println("lien");
	    }
	    
	    
	    public void upload1(FileUploadEvent e) throws IOException {
	    	fileh = e.getFile();
	    	System.out.println(fileh.getFileName());
       	 System.out.println("FADDA");

       	 
     	
       	 
	    			fileh =  (UploadedFile) new File("C:/IDE/workspace/PFE/Mae/Mae-web/src/main/webapp/pages/Coefrente.xls");
	    			
	    			//"C:/IDE/workspace/PFE/Mae/Mae-web/src/main/webapp/pages/Coefrente.xls"
	        	 System.out.println("HELLO");
	 	        //System.out.println("FILE SIZE"+" "+ress.getAbsolutePath());
	 	        System.out.println("FILE SIZE"+" "+fileh.getFileName());
	 	        //System.out.println("FILE TYPE"+" "+ress.length());
	 	        //System.out.println("FILE SUB"+" "+ress.getName());
	 	       // System.out.println("FILE H"+" "+"lien");
	 	       // System.out.println("FILE H"+" "+"lien");
	 	        System.out.println("FILE C"+" "+ress.getCanonicalPath());



	 	       
	 	        
	 	        String absoluteWebPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("../../"+this.path_to+fileh.getFileName());
	 	        String filename = FilenameUtils.getName(fileh.getFileName());
	 	        InputStream input1 = getClass().getResourceAsStream(fileh.getFileName());
	 	        System.out.println("Absolute Path : "+" "+absoluteWebPath);
	 	       System.out.println("RESS Path : "+" "+ress.getCanonicalPath());

	 	        System.out.println("FILE NAME"+" "+filename);
	 	        System.out.println("INPUT"+" "+input1);


	            FacesMessage message = new FacesMessage("Succesful", fileh.getFileName() + " is uploaded.");
	            FacesContext.getCurrentInstance().addMessage(null, message);
	        }
	    
	    
	  
	       public void readData() throws IOException{
	    	   
	    	   //File file = new File("C:\\IDE\\workspace\\PFE\\Mae\\Mae-web\\src\\main\\webapp\\pages\\templates\\Coefrente.xls");
	    	     /* FileInputStream fIP = new FileInputStream(file);
	    	      //Get the workbook instance for XLS file 
	    	      XSSFWorkbook wb = new XSSFWorkbook(fIP);
	    	      if(file.isFile() && file.exists())
	    	      {
	    	         System.out.println(
	    	         "xls file open successfully.");
	    	      }
	    	      else
	    	      {
	    	         System.out.println(
	    	         "Error to open xls file.");
	    	      }*/
	    	   
	    	  
	    	   
	        /*FileInputStream input = new FileInputStream("C:/IDE/workspace/PFE/Mae/Mae-web/src/main/webapp/pages/templates/Coefrente.xls");  
	        POIFSFileSystem fs = new POIFSFileSystem( input );  
	        HSSFWorkbook wb = new HSSFWorkbook(fs);  
	        HSSFSheet sheet = wb.getSheetAt(0);  
	        HSSFRow row;
	        for(int i=1; i<=sheet.getLastRowNum(); i++){
	            row = sheet.getRow(i);
	           String Age = row.getCell(1).getStringCellValue();
	            String Coef_H = row.getCell(2).getStringCellValue();
	            String Coef_F = row.getCell(3).getStringCellValue();
	         
	           coeff.setAge(Age);
	           coeff.setCoef_H(Coef_H);
	           coeff.setCoef_F(Coef_F);
	           
	           clocal.addCoefficient(coeff);
	           
	            System.out.println("Import rows "+i);
	        }
	       wb.close();
	        input.close();
	        System.out.println("Success import excel to mysql table");
	    	  
	    	    

	}*/
	    	   //		EXCEL
	    	   
	    	   File file = new File(fileh.getFileName());
	    	   //"C:/IDE/workspace/PFE/Mae/Mae-web/src/main/webapp/pages/templates/Coefrente.xls"
	    	   InputStream ExcelFileToRead = new FileInputStream(file);
	   		HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);

	   		HSSFSheet sheet=wb.getSheetAt(0);
	   		HSSFSheet sheet1=wb.getSheetAt(1);
	   		HSSFSheet sheet2=wb.getSheetAt(2);

	   		HSSFRow row; 
	   		HSSFCell cell;
	   		
	   			//	SHEET 0
	   		Iterator rows = sheet.rowIterator();
	   		
	   		while (rows.hasNext())
	   		{
	   			row=(HSSFRow) rows.next();
	   			Iterator cells = row.cellIterator();
	   			List dataS = new ArrayList();
	   			while (cells.hasNext())
	   			{
	   				cell=(HSSFCell) cells.next();
	   		
	   				if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
	   				{
	   					System.out.println(cell.getStringCellValue()+" ");
	   					 /*ma = cell.getStringCellValue();
  						 dataS.add(ma);
	   		   			//System.out.println("f1"+data);
  						 mag=(String) dataS.get(0);
  						System.out.println(mag);
  						
  						for(Iterator it=dataS.iterator(); it.hasNext();) 

		   		            System.out.println("f1"+it.next());
  						
  							

	   					//System.out.print(cell.getStringCellValue()+" ");
	   					
	   					  	*/
	   				}
	   				else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
	   				{
	   					
	   					//System.out.println("hhhhhhhh"+mag);
	   					
			   				
		   						/*double ma1 = cell.getNumericCellValue();
		   						 data.add(ma1);
			   		   			System.out.println("aaage"+data.get(0));			   		   			
			   		   		System.out.println("aaage---858-"+sheet.getFirstRowNum());
			   		   			*/
			   		   		
			   		   		
			   		   		  ma = (float) cell.getNumericCellValue();
	   						 data.add(ma);
	   					
			   		   		
	   					 System.out.println(cell.getNumericCellValue()+" ");
	   					
	   		   			
	   					
   		   			
	   				}
	   				else
	   				{
	   					//U Can Handel Boolean, Formula, Errors
	   				}
	   				
	   			}
	   			
	   			
	   			System.out.println();


	   		}
   			System.out.println("data"+data);
   			for(Iterator it=data.iterator(); it.hasNext();) {
   				coeff.setAge( (float) it.next());
   				System.out.println("age"+" "+coeff.getAge());
		           // System.out.println("AGEmA"+" "+it.next());
   			}
	   		
	   		//		SHEET 1 
Iterator rows1 = sheet1.rowIterator();
	   		
	   		while (rows1.hasNext())
	   		{
	   			row=(HSSFRow) rows1.next();
	   			Iterator cells = row.cellIterator();
	   			List dataS = new ArrayList();
	   			while (cells.hasNext())
	   			{
	   				cell=(HSSFCell) cells.next();
	   		
	   				if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
	   				{
	   					System.out.println(cell.getStringCellValue()+" ");
	   					 /*ma = cell.getStringCellValue();
  						 dataS.add(ma);
	   		   			//System.out.println("f1"+data);
  						 mag=(String) dataS.get(0);
  						System.out.println(mag);
  						
  						for(Iterator it=dataS.iterator(); it.hasNext();) 

		   		            System.out.println("f1"+it.next());
  						
  							

	   					//System.out.print(cell.getStringCellValue()+" ");
	   					
	   					  	*/
	   				}
	   				else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
	   				{
	   					
	   					/*System.out.println("hhhhhhhh"+mag);
	   					
	   						List data = new ArrayList();
			   				
		   						double ma1 = cell.getNumericCellValue();
		   						 data.add(ma1);
			   		   			System.out.println("aaage"+data.get(0));			   		   			
			   		   		System.out.println("aaage---858-"+sheet.getFirstRowNum());
			   		   			*/
			   		   		
			   		   		//for(Iterator it=data.iterator(); it.hasNext();) 
			   		   			
			   		          //  System.out.println("f2"+it.next()); 	
	   				  
	   					mh =  (float) cell.getNumericCellValue();
						 dataH.add(mh);
							
						 		coeff.setCoef_H(mh);
	   					 System.out.println(cell.getNumericCellValue()+" ");
	   					
	   		   			
	   					
   		   			
	   				}
	   				else
	   				{
	   					//U Can Handel Boolean, Formula, Errors
	   				}
	   				
	   			}
	   			
	   			
	   			System.out.println();
	   			

	   		}
	   		
   			System.out.println("dataH"+dataH);

	   		// 	SHEET2
	   		
Iterator rows2 = sheet2.rowIterator();
	   		
	   		while (rows2.hasNext())
	   		{
	   			row=(HSSFRow) rows2.next();
	   			Iterator cells = row.cellIterator();
	   			List dataS = new ArrayList();
	   			while (cells.hasNext())
	   			{
	   				cell=(HSSFCell) cells.next();
	   		
	   				if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
	   				{
	   					System.out.println(cell.getStringCellValue()+" ");
	   					 /*ma = cell.getStringCellValue();
  						 dataS.add(ma);
	   		   			//System.out.println("f1"+data);
  						 mag=(String) dataS.get(0);
  						System.out.println(mag);
  						
  						for(Iterator it=dataS.iterator(); it.hasNext();) 

		   		            System.out.println("f1"+it.next());
  						
  							

	   					//System.out.print(cell.getStringCellValue()+" ");
	   					
	   					  	*/
	   				}
	   				else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
	   				{
	   					
	   					/*System.out.println("hhhhhhhh"+mag);
	   					
	   						List data = new ArrayList();
			   				
		   						double ma1 = cell.getNumericCellValue();
		   						 data.add(ma1);
			   		   			System.out.println("aaage"+data.get(0));			   		   			
			   		   		System.out.println("aaage---858-"+sheet.getFirstRowNum());
			   		   			*/
			   		   		
			   		   		//for(Iterator it=data.iterator(); it.hasNext();) 
			   		   			
			   		          //  System.out.println("f2"+it.next()); 	
	   					
	   				  mf = (float) cell.getNumericCellValue();
						 dataF.add(mf);
	   					 System.out.println(cell.getNumericCellValue()+" ");
	   					
	   		   			
	   					
   		   			
	   				}
	   				else
	   				{
	   					//U Can Handel Boolean, Formula, Errors
	   				}
	   				
	   			}
	   			
	   			
	   			System.out.println();
	   			

	   		}
	   		
   			System.out.println("dataF"+dataF);

   			for(Iterator it=data.iterator(); it.hasNext();) {
   				
	    	  clocal.ajoutCoeff( (float)data.get(0), (float) dataH.get(0), (float) dataF.get(0));
   			}
   			
   		
   			
}
	       
	        
	       
	     
	       										/* Coefficient */
	       
	       public void ExcelRead() throws IOException {

	    	   File file = new File("C:/MAE/Coefrente.xls");
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
						
						//System.out.print(cell.getStringCellValue()+" ");
					}
					else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
					{	
						
						values.add((float)cell.getNumericCellValue());
						//System.out.print(cell.getNumericCellValue()+" ");
						
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

				
				for(int i=0;i<values.size()-2;i++){
				System.out.print("VALEUR 1- "+" " +(float)values.get(0) );
				System.out.print("VALEUR 2-- "+" " +values.get(1));
				System.out.print("VALEUR 3--- "+" " +values.get(2));
				clocal.ajoutCoeff((float)values.get(0),(float) values.get(1),(float) values.get(2));
				}
				
				 
			}
			FacesMessage message = new FacesMessage("Succesful",  " EXCEL uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);

	       }
	       
	       
}