package tn.esprit.MaE.Interface;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import tn.esprit.MaE.entities.Rente;
import tn.esprit.MaE.entities.RenteU;

@Local
public interface RenteUServiceLocal {
	
	public void addRenteU(RenteU RenteU);
	public void ajoutRenteU(int id_bene,float RenteU,Date debut,Date fin,String etat);
	public void ajoutRenteUPM(float RenteUb);
	public void ajoutRenteUP(int id_bene,float PM,Date debut,Date fin,Boolean valid);
	public void ajoutRenteUPN(int id_bene,float RenteU,float PM,Boolean rf,Date debut,Date fin);
	public void deleteRenteU(RenteU RenteU);
	public void update(RenteU RenteU);
	public List<RenteU> findAll();
	public float getRenteU(int id);
	public RenteU readByidu(int id);
	public List<RenteU> findRNV();
	public List<RenteU> findRV();
	public List<RenteU> findF();
	public List<RenteU> findR();
	public List<RenteU> findRF();
	public Rente findByIdBenef(int idb);
	public void updateR(int idrenteu,String etat,String motif);


	

	

}
