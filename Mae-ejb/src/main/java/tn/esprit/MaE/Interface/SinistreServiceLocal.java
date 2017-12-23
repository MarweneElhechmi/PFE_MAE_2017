package tn.esprit.MaE.Interface;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import tn.esprit.MaE.entities.Sinistre;

@Local
public interface SinistreServiceLocal {
	public void addSinistre(Sinistre sinistre);
	public void ajoutSinistre(int idag,int numero, String nom_assure,String etat,Date dateSurvenance, Date dateDeclaration, int N_Police);
	public void deleteSinistre(Sinistre sinistre);
    public Sinistre findByid(int num);
	public void update(Sinistre sinistre);
	public List<Sinistre> findAll();
	public List<Sinistre> findS();
	public Sinistre RecupereIdSinistre(int id);
	public List<Sinistre> findSV();
	public void Delete();
	public long Doublons(int Num);
}
