package tn.esprit.MaE.Interface;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import tn.esprit.MaE.entities.Beneficiaire;

@Local
public interface BeneficiaireServiceLocal {

	public void addBeneficiaire(Beneficiaire Beneficiaire);
	public void ajoutBeneficiaire(int idVictime,float age ,String cin,String nom,String prenom,Date naissance,String etat, int conjoint);
	public void deleteBeneficiaire(Beneficiaire Beneficiaire);
	public Beneficiaire findByCin(String cin);
	public void update(Beneficiaire Beneficiaire);
	public List<Beneficiaire> findAll();
	public List<Beneficiaire> findAllB(int id_v);
	public List<Beneficiaire> findR();
	public int getMaxIdB();
	public Beneficiaire readByid(int id );
	public long calculBenefP(int id);
	public long calculBenefF(int id);
	public long calculBenefV(int id);
	public float RecupereRente(int id);
	public float RecuperePM(int id);
	

}
