package tn.esprit.MaE.Interface;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import tn.esprit.MaE.entities.Victime;

@Local
public interface VictimeServiceLocal {

	public void addVictime(Victime Victime);
	public void ajoutVictime(int idgs,int idSinistre, String cin,String nom,String prenom,String Profession,Date naissance, Date deces,int nb_b,int revenu) ;
	public void deleteVictime(Victime Victime);
	public Victime findByCin(String cin);
	public void update(Victime Victime);
	public List<Victime> findAll();
	Victime readByid(int id );
	public int getMaxId();
	public int getRevenuAnnu(int id);
	
		
}
