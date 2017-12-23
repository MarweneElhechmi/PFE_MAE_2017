package managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import tn.esprit.MaE.Interface.FinancierServiceLocal;
import tn.esprit.MaE.entities.Financier;

@ManagedBean
@ViewScoped
public class FinancierBean {


	@EJB
	FinancierServiceLocal local;
	private List<Financier>financiersFiltred;
	
	

	private List<Financier>financiers=new ArrayList<>();
	private Financier financier=new Financier();
	
	
	
	public List<Financier> getfinanciersFiltred() {
		return financiersFiltred;
	}

	public void setfinanciersFiltred(List<Financier> financiersFiltred) {
		this.financiersFiltred = financiersFiltred;
	}

	public List<Financier> getfinanciers() {
		return financiers;
	}

	public void setfinanciers(List<Financier> financiers) {
		this.financiers = financiers;
	}

	public Financier getfinancier() {
		return financier;
	}

	public void setfinancier(Financier financier) {
		this.financier = financier;
	}

	@PostConstruct
	public void init(){
	financier=new Financier();
	financiers=local.findAll();
	}
	
	public String doAdd(){
		local.addFinancier(financier);
		return null;
		
	}
	public String doUpdate(){
		FacesMessage message;
		local.update(financier);
		message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Opération effectué avec Succés",null);
		FacesContext.getCurrentInstance().addMessage(null, message);
		init();
		return null;
		
	}
	 public String doDelete(Financier financier){
		 local.deleteFinancier(financier);
		 init();
		 return null;
	 }
	 
	 public String initialiser(){
		 financier=new Financier();
		 return null;
	 }
	 
	 public void Valider_AG(Financier financier){
		 financier.setValidé(true);
		 local.update(financier);
		 
	 }
}
