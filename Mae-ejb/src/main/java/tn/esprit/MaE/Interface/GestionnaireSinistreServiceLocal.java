package tn.esprit.MaE.Interface;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.MaE.entities.GestionnaireSinistre;

@Local
public interface GestionnaireSinistreServiceLocal {

	public void addGS(GestionnaireSinistre GS);
	public void deleteGS(GestionnaireSinistre GS);
	public GestionnaireSinistre findByCin(String cin);
	public void update(GestionnaireSinistre GS);
	public List<GestionnaireSinistre> findAll();
	public GestionnaireSinistre findById(int id_u);
	
}
