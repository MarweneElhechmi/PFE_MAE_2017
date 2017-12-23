package tn.esprit.MaE.Interface;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import tn.esprit.MaE.entities.Rente;

@Local
public interface RenteServiceLocal {
	
	public void addRente(Rente Rente);
	public void ajoutRente(int id_bene,int Rente,Date debut,Date fin,String etat);
	public void ajoutRentePM(int renteb);
	public void ajoutRenteP(int id_bene,BigInteger PM,Date debut,Date fin,Boolean valid);
	public void ajoutRentePN(int id_bene,int rente,BigInteger PM,Boolean rf,Date debut,Date fin);
	public void deleteRente(Rente Rente);
	public void update(Rente Rente);
	public List<Rente> findAll();
	public Double getRente(int id);
	public Rente readByid(int id);
	public List<Rente> findRNV();
	public List<Rente> findRVide(int id);
	public List<Rente> findF();
	public List<Rente> findR();
	public List<Rente> findRF();
	public List<Rente> findAllT();
	public List<Rente> findRS(String cinb);
	public Rente selectRenteBenef(int id);
	public List<Rente> findDossier(String cinb);
	




	

	

}
