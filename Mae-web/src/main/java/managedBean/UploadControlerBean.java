package managedBean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

@ManagedBean(name="uploadController")
@SessionScoped
public class UploadControlerBean {

	
	
	private String ExcelFile="";
	private Part p ;
	
	
	public String getExcelFile() {
		return ExcelFile;
	}
	public void setExcelFile(String excelFile) {
		ExcelFile = excelFile;
	}
	public Part getP() {
		return p;
	}
	public void setP(Part p) {
		this.p = p;
	}
	
	public String processUpload() throws IOException{
		UploadHelper uh = new UploadHelper();
		this.ExcelFile=uh.ProcessUpload(this.p);
		return "Victime";
	}
	
	@SuppressWarnings("unused")
	private String getFilename(Part part)  {
		for (String cd: part.getHeader("content-disposition").split(";")){
			if(cd.trim().startsWith("filename")){
				String filename=cd.substring(cd.indexOf('=')+1).trim().replace("\"", "");
						return filename.substring(filename.lastIndexOf('/')+1).substring(filename.lastIndexOf('\\')+1);
			}
		}
		return null;
	}
	
	
}
