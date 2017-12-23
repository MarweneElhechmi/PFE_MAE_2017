package tn.esprit.MaE.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.MaE.Interface.GestionnaireSinistreServiceLocal;
import tn.esprit.MaE.entities. GestionnaireSinistre;

/**
 * Session Bean implementation class GestionnaireSinistreService
 */
@Stateless
@LocalBean
public class  GestionnaireSinistreService implements GestionnaireSinistreServiceLocal {

	
	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public GestionnaireSinistreService() {
        // TODO Auto-generated constructor stub
    }

    @Override
   	public void addGS( GestionnaireSinistre  GS) {
   		em.persist(GS);
   		
   	}

   	@Override
   	public void deleteGS( GestionnaireSinistre  GS) {
   		em.remove(em.merge( GS));
   		
   	}

   	@Override
   	public  GestionnaireSinistre findByCin(String cin) {
   		return em.find( GestionnaireSinistre.class,cin);
   	}

   	@Override
   	public void update( GestionnaireSinistre  GestionnaireSinistre) {
   		em.merge( GestionnaireSinistre);
   		
   	}

   	@Override
   	public List< GestionnaireSinistre> findAll() {
   		return em.createQuery("select s from  GestionnaireSinistre s",  GestionnaireSinistre.class).
   				getResultList();
   	}

	@Override
	public GestionnaireSinistre findById(int id_u) {
		return em.find(GestionnaireSinistre.class, id_u);

	}

}
