package tn.esprit.MaE.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.MaE.Interface.AgentGeneralServiceLocal;
import tn.esprit.MaE.entities.AgentGeneral;

/**
 * Session Bean implementation class AgentGeneralService
 */
@Stateless
@LocalBean
public class AgentGeneralService implements AgentGeneralServiceLocal {

	
	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public AgentGeneralService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addAgentGeneral(AgentGeneral AgentGeneral) {
		em.persist(AgentGeneral);
		
	}

	@Override
	public void deleteAgentGeneral(AgentGeneral AgentGeneral) {
		em.remove(em.merge(AgentGeneral));
		
	}

	@Override
	public AgentGeneral findByCin(String cin) {
		return em.find(AgentGeneral.class,cin);
	}

	@Override
	public void update(AgentGeneral AgentGeneral) {
		em.merge(AgentGeneral);
		
	}

	@Override
	public List<AgentGeneral> findAll() {
		return em.createQuery("select s from AgentGeneral s", AgentGeneral.class).
				getResultList();
	}

	@Override
	public AgentGeneral findById(int id_u) {
		return em.find(AgentGeneral.class, id_u);
	}

}
