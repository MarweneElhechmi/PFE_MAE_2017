package managedBean;

import java.io.*;
import java.util.*;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.servlet.http.*;

public class UploadHelper {

	private final int limit_max_size=10240000;
	private final String limit_type_file="xls|xlsx";
	private final String path_to="/templates/assets/";
	
	public UploadHelper(){
		
	}
	
	public String ProcessUpload(Part fileUpload){
		String fileSaveData = "";
		try{
			if (fileUpload.getSize()>0){
			
				String fileName=getFilename(fileUpload);
				if(checkFileType(fileName)){
				if(fileUpload.getSize() > this.limit_max_size){
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO , "File is too large",""));
					
				} else {
					String currentFileName=fileName;
					String extension = currentFileName.substring(currentFileName.lastIndexOf("."),currentFileName.length());
					Long nameRadom = Calendar.getInstance().getTimeInMillis();
					String newfileName = nameRadom + extension ; 
					fileSaveData = newfileName;
					String fileSavePath = FacesContext.getCurrentInstance().getExternalContext().getRealPath(this.path_to);
					try{
						byte[] fileContent = new byte[(int) fileUpload.getSize()];
						InputStream in = fileUpload.getInputStream();
						in.read(fileContent);
						File fileToCreate = new File(fileSavePath,newfileName);
						File folder = new File(fileSavePath);
						
						if(!folder.exists()){
							folder.mkdirs();
						}
					FileOutputStream fileOutStream = new FileOutputStream(fileToCreate);
					fileOutStream.write(fileContent);
					fileOutStream.flush();
					fileOutStream.close();
					
					
					}catch(IOException e){
						fileSaveData="";
					}
				}
				
			}else {
				fileSaveData="";
			}
			}
		
		}catch (Exception e){
			fileSaveData="";
		}
		return fileSaveData;
	}

	private String getFilename(Part part)  {
		for (String cd: part.getHeader("content-disposition").split(";")){
			if(cd.trim().startsWith("filename")){
				String filename=cd.substring(cd.indexOf('=')+1).trim().replace("\"", "");
						return filename.substring(filename.lastIndexOf('/')+1).substring(filename.lastIndexOf('\\')+1);
			}
		}
		return null;
	}
	
	private boolean checkFileType(String fileName){
		if (fileName.length() > 0 ){
			
			String[] parts = fileName.split("\\.");
			if(parts.length >0){
				String extention = parts[parts.length - 1];
				return this.limit_type_file.contains(extention);
			}
		}
		return false;
		
	}
	
}
