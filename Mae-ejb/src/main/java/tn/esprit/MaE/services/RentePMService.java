package tn.esprit.MaE.services;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.MaE.Interface.RentePMServiceLocal;
import tn.esprit.MaE.entities.Beneficiaire;
import tn.esprit.MaE.entities.Rente;
import tn.esprit.MaE.entities.RentePM;

/**
 * Session Bean implementation class RentePMService
 */
@Stateless
@LocalBean
public class RentePMService implements RentePMServiceLocal {

	@EJB
	BeneficiaireService blocal;
	
	@EJB
	RentePMService rlocal;

	Beneficiaire beneficiaire;
	Rente Rente;
	
	@PersistenceContext(unitName="Mae-ejb")
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public RentePMService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addRentePM(RentePM RentePM) {
		em.persist(RentePM);
	}

	
	public void ajoutRente(int id_bene, float RentePM, Date debut, Date fin) {
		beneficiaire = blocal.readByid(id_bene);
    	RentePM ren = new RentePM(beneficiaire, RentePM,debut,fin);
  		em.persist(ren);
		
	}

	@Override
	public void deleteRentePM(RentePM RentePM) {
		em.remove(em.merge(RentePM));
	}

	@Override
	public void update(RentePM RentePM) {
  		em.merge(RentePM);

	}

	@Override
	public List<RentePM> findAll() {
		return em.createQuery("select r from RentePM r where year(debut) = year(now()) ", RentePM.class).
  				getResultList();
	}

	@Override
	public void ajoutRentePMP(int id_bene, BigInteger PM, Date debut, Date fin, Boolean valid) {
		beneficiaire = blocal.readByid(id_bene);
    	RentePM ren = new RentePM(beneficiaire, PM,debut,fin,valid);
  		em.persist(ren);
		
	}

	@Override
	public Double getRentePM(int id) {
		Query req = em.createQuery("select r.RentePM from RentePM r where r.id=:id ");
		return (Double)req.setParameter("id", id).getSingleResult();
	}

	public RentePM readByid(int id) {
		Query req = em.createQuery("select g from RentePM g  where g.id=:id");
		return (RentePM)req.setParameter("id", id).getSingleResult();
	}

	@Override
	public void ajoutRentePM(int RentePMb) {
		RentePM ren = new RentePM(RentePMb);
  		em.persist(ren);
		
	}

	@Override
	public List<RentePM> findRV() {
		return em.createQuery("select s from RentePM s where s.valider=1", RentePM.class).
				getResultList();
	}
	
	@Override
	public List<RentePM> findRNV() {
		return em.createQuery("select s from RentePM s where s.valider=0", RentePM.class).
				getResultList();
	}

	@Override
	public List<RentePM> findF() {
		return em.createQuery("select s from RentePM s where s.DatePriseRentePM IS NULL and s.valider IS NULL", RentePM.class).
				getResultList();
	}
	
	@Override
	public List<RentePM> findR() {
		return em.createQuery("select s from RentePM s where (s.valider=0 or s.valider=1)", RentePM.class).
  				getResultList();
	}
	
	@Override
	public List<RentePM> findRF() {
		return em.createQuery("select s from RentePM s where s.bool IS NULL", RentePM.class).
  				getResultList();
	}

	@Override
	public void ajoutRentePMPN(int id_bene,float RentePM,float age, BigInteger PM, Boolean rf, Date debut, Date fin) {
		beneficiaire = blocal.readByid(id_bene);
    	RentePM ren = new RentePM(beneficiaire, RentePM,age,PM,rf,debut,fin );
  		em.persist(ren);
	
	}

	@Override
	public List<RentePM> findAllT(String cinb) {
		return em.createQuery("select r from RentePM r JOIN r.beneficiairesR b where b.cinb=:cinb ", RentePM.class).setParameter("cinb", cinb).
				getResultList();
	}

	@Override
	public List<RentePM> findAllTotal() {
		return em.createQuery("select s from RentePM s ", RentePM.class).
  				getResultList();
	}

	
}
