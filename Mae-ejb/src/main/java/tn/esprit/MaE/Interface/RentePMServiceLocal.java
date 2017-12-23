package tn.esprit.MaE.Interface;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import tn.esprit.MaE.entities.RentePM;

@Local
public interface RentePMServiceLocal {
	
	public void addRentePM(RentePM RentePM);
	public void ajoutRente(int id_bene,float RentePM,Date debut,Date fin);
	public void ajoutRentePM(int RentePMb);
	public void ajoutRentePMP(int id_bene,BigInteger PM,Date debut,Date fin,Boolean valid);
	public void ajoutRentePMPN(int id_bene,float RentePM,float age,BigInteger PM,Boolean rf,Date debut,Date fin);
	public void deleteRentePM(RentePM RentePM);
	public void update(RentePM RentePM);
	public List<RentePM> findAll();
	public Double getRentePM(int id);
	public RentePM readByid(int id);
	public List<RentePM> findRNV();
	public List<RentePM> findRV();
	public List<RentePM> findF();
	public List<RentePM> findR();
	public List<RentePM> findRF();
	public List<RentePM> findAllT(String cinb);
	public List<RentePM> findAllTotal();



	

	

}
