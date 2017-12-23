package tn.esprit.MaE.Interface;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.MaE.entities.AgentGeneral;
import tn.esprit.MaE.entities.Financier;

@Local
public interface FinancierServiceLocal {

	public void addFinancier(Financier Financier);
	public void deleteFinancier(Financier Financier);
	public Financier findByCin(String cin);
	public void update(Financier Financier);
	public List<Financier> findAll();
	public Financier findById(int id_u);

	
}
