package tn.esprit.MaE.services;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.MaE.Interface.RenteFServiceLocal;
import tn.esprit.MaE.entities.Beneficiaire;
import tn.esprit.MaE.entities.RenteF;

/**
 * Session Bean implementation class RenteFService
 */
@Stateless
@LocalBean
public class RenteFService implements RenteFServiceLocal {

	@EJB
	BeneficiaireService blocal;
	
	@EJB
	RenteFService rlocal;

	Beneficiaire beneficiaire;
	RenteF RenteF;
	
	@PersistenceContext(unitName="Mae-ejb")
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public RenteFService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addRenteF(RenteF RenteF) {
		em.persist(RenteF);
	}

	
	public void ajoutRenteF(int id_bene, float RenteF, Date debut, Date fin) {
		beneficiaire = blocal.readByid(id_bene);
    	RenteF ren = new RenteF(beneficiaire, RenteF,debut,fin);
  		em.persist(ren);
		
	}

	@Override
	public void deleteRenteF(RenteF RenteF) {
		em.remove(em.merge(RenteF));
	}

	@Override
	public void update(RenteF RenteF) {
  		em.merge(RenteF);

	}

	@Override
	public List<RenteF> findAll() {
		return em.createQuery("select r from RenteF r ", RenteF.class).
  				getResultList();
	}

	public void ajoutRenteFP(int id_bene, float RenteF,float PM, Date debut, Date fin, Boolean valid) {
		beneficiaire = blocal.readByid(id_bene);
    	RenteF ren = new RenteF(beneficiaire, RenteF,PM,debut,fin,valid);
  		em.persist(ren);
		
	}

	@Override
	public Double getRenteF(int id) {
		Query req = em.createQuery("select r.RenteF from RenteF r where r.id=:id ");
		return (Double)req.setParameter("id", id).getSingleResult();
	}

	public RenteF readByid(int id) {
		Query req = em.createQuery("select g from RenteF g  where g.id=:id");
		return (RenteF)req.setParameter("id", id).getSingleResult();
	}

	@Override
	public void ajoutRenteFPM(float RenteFb) {
		RenteF ren = new RenteF(RenteFb);
  		em.persist(ren);
		
	}

	@Override
	public List<RenteF> findRV() {
		return em.createQuery("select s from RenteF s where s.valider=1", RenteF.class).
				getResultList();
	}
	
	@Override
	public List<RenteF> findRNV() {
		return em.createQuery("select s from RenteF s where s.valider=0", RenteF.class).
				getResultList();
	}

	@Override
	public List<RenteF> findF() {
		return em.createQuery("select s from RenteF s where s.DatePriseRenteF IS NULL and s.valider IS NULL", RenteF.class).
				getResultList();
	}
	
	@Override
	public List<RenteF> findR() {
		return em.createQuery("select s from RenteF s where (s.valider=0 or s.valider=1)", RenteF.class).
  				getResultList();
	}

	
}
