package tn.esprit.MaE.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.MaE.Interface.FinancierServiceLocal;
import tn.esprit.MaE.entities.Financier;

/**
 * Session Bean implementation class FinancierService
 */
@Stateless
@LocalBean
public class FinancierService implements FinancierServiceLocal {

	
	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public FinancierService() {
        // TODO Auto-generated constructor stub
    }

    @Override
   	public void addFinancier(Financier Financier) {
   		em.persist(Financier);
   		
   	}

   	@Override
   	public void deleteFinancier(Financier Financier) {
   		em.remove(em.merge(Financier));
   		
   	}

   	@Override
   	public Financier findByCin(String cin) {
   		return em.find(Financier.class,cin);
   	}

   	@Override
   	public void update(Financier Financier) {
   		em.merge(Financier);
   		
   	}

   	@Override
   	public List<Financier> findAll() {
   		return em.createQuery("select s from Financier s", Financier.class).
   				getResultList();
   	}

	@Override
	public Financier findById(int id_u) {
		return em.find(Financier.class, id_u);

	}

}
