package tn.esprit.MaE.services;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.MaE.Interface.AgentGeneralServiceLocal;
import tn.esprit.MaE.Interface.GestionnaireSinistreServiceLocal;
import tn.esprit.MaE.Interface.SinistreServiceLocal;
import tn.esprit.MaE.entities.AgentGeneral;
import tn.esprit.MaE.entities.GestionnaireSinistre;
import tn.esprit.MaE.entities.Sinistre;

/**
 * Session Bean implementation class SinistreService
 */
@Stateless
@LocalBean
public class SinistreService implements SinistreServiceLocal {

	AgentGeneral agent;
	GestionnaireSinistre gestionnaire;
	int idgs;
	
	@EJB
	GestionnaireSinistreServiceLocal gssl;
	
	@EJB
	AgentGeneralServiceLocal agsl;
	
	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public SinistreService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addSinistre(Sinistre sinistre) {
		
		em.persist(sinistre);
		
	}

	@Override
	public void deleteSinistre(Sinistre AgentGeneral) {
		em.remove(em.merge(AgentGeneral));
		
	}

	@Override
	public Sinistre findByid(int num) {
		return em.find(Sinistre.class, num);
	}

	@Override
	public void update(Sinistre sinistre) {
		
		em.merge(sinistre);
		
	}

	@Override
	public List<Sinistre> findAll() {
		return em.createQuery("select s from Sinistre s", Sinistre.class).
				getResultList();
	}
	
	@Override
	public List<Sinistre> findS() {
		return em.createQuery("select s from Sinistre s where s.valider=0", Sinistre.class).
				getResultList();
	}
	
	@Override
	public List<Sinistre> findSV() {
		return em.createQuery("select s from Sinistre s where s.valider=1", Sinistre.class).
				getResultList();
	}
	
	@Override
	public Sinistre RecupereIdSinistre(int id) {
		 Query req = em.createQuery("select s from Sinistre s where s.id=:id ");
			return (Sinistre)req.setParameter("id", id).getSingleResult();
	}

	@Override
	public void ajoutSinistre( int idag,int numero, String nom_assure,String etat,Date dateSurvenance , Date dateDeclaration, int N_Police) {
		agent = agsl.findById(idag);
    	Sinistre sin = new Sinistre(agent, numero,  nom_assure,etat, dateSurvenance, dateDeclaration,  N_Police);
  		em.merge(sin);		
	}

	@Override
	public void Delete() {
	 em.createQuery("DELETE FROM Sinistre")
     .executeUpdate();
	}
	
	@Override
	public long Doublons(int numero) {
		
		  Query req = em.createQuery("select COUNT(*) from Sinistre s where s.numero=:numero ");
		return (long)req.setParameter("numero", numero).getSingleResult();
		
	}

}
