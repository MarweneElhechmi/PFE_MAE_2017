package tn.esprit.MaE.Interface;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import tn.esprit.MaE.entities.RenteF;

@Local
public interface RenteFServiceLocal {
	
	public void addRenteF(RenteF RenteF);
	public void ajoutRenteF(int id_bene,float RenteF,Date debut,Date fin);
	public void ajoutRenteFPM(float RenteFb);
	public void ajoutRenteFP(int id_bene,float RenteF,float PM,Date debut,Date fin,Boolean valid);
	public void deleteRenteF(RenteF RenteF);
	public void update(RenteF RenteF);
	public List<RenteF> findAll();
	public Double getRenteF(int id);
	public RenteF readByid(int id);
	public List<RenteF> findRNV();
	public List<RenteF> findRV();
	public List<RenteF> findF();
	public List<RenteF> findR();


	

	

}
