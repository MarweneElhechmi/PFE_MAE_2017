package tn.esprit.MaE.services;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.MaE.Interface.GestionnaireSinistreServiceLocal;
import tn.esprit.MaE.Interface.VictimeServiceLocal;
import tn.esprit.MaE.entities.GestionnaireSinistre;
import tn.esprit.MaE.entities.Sinistre;
import tn.esprit.MaE.entities.Victime;

/**
 * Session Bean implementation class VictimeService
 */

@Stateless
@LocalBean
public class VictimeService implements VictimeServiceLocal {

	GestionnaireSinistre gestionnaire;
	
	@EJB
	SinistreService Slocal;
	
	@EJB
	GestionnaireSinistreServiceLocal gssl;
	
	@EJB
	VictimeService local;

	Sinistre sinistre;
	Victime victime;
	
	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public VictimeService(){
        // TODO Auto-generated constructor stub
    }

    @Override
   	public void addVictime(Victime Victime) {
   		em.persist(Victime);
   		
   	}
    
    public void ajoutVictime(int idgs,int idSinistre,String cin,String nom,String prenom,String Profession,Date naissance, Date deces,int nb_b,int revenu) {
    	sinistre = Slocal.RecupereIdSinistre(idSinistre);
    	gestionnaire = gssl.findById(idgs);
    	Victime sin = new Victime(gestionnaire,sinistre,cin, nom, prenom, Profession, naissance,  deces, nb_b, revenu);
  		em.persist(sin);
  		
  	}
    
    
    public void createVictime(int num, String nom, String prenom, Date naissance,Date deces, int nb_b) {

		
   
	}
    
    
   	@Override
   	public void deleteVictime(Victime Victime) {
   		em.remove(em.merge(Victime));
   		
   	}

   	@Override
   	public Victime findByCin(String cin) {
   		return em.find(Victime.class,cin);
   	}

   	@Override
   	public void update(Victime Victime) {
   		em.merge(Victime);
   		
   	}

   	@Override
   	public List<Victime> findAll() {
   		return em.createQuery("select s from Victime s", Victime.class).
   				getResultList();
   	}

	@Override
	public Victime readByid(int id) {
		Query req = em.createQuery("select g from Victime g  where g.id=:id");
		return (Victime)req.setParameter("id", id).getSingleResult();
	}
	
	@Override
	public int getMaxId() {
		Query req = em.createQuery("select max(g.id) from Victime g ");
		return (int)req.getSingleResult();
	}
	
	@Override
	public int getRevenuAnnu(int id) {
		Query req = em.createQuery("select g.revenu from Victime g where g.id=:id ");
		return (int)req.setParameter("id", id).getSingleResult();
	}

	
	
}
