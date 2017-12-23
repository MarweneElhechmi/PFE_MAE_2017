package tn.esprit.MaE.services;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.MaE.Interface.RenteUServiceLocal;
import tn.esprit.MaE.entities.Beneficiaire;
import tn.esprit.MaE.entities.Rente;
import tn.esprit.MaE.entities.RenteU;
import tn.esprit.MaE.entities.Victime;

/**
 * Session Bean implementation class RenteUService
 */
@Stateless
@LocalBean
public class RenteUService implements RenteUServiceLocal {

	@EJB
	BeneficiaireService blocal;
	
	@EJB
	RenteUService rlocal;

	Beneficiaire beneficiaire;
	RenteU RenteU;
	
	@PersistenceContext(unitName="Mae-ejb")
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public RenteUService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addRenteU(RenteU RenteU) {
		em.persist(RenteU);
	}

	
	public void ajoutRenteU(int id_bene, float RenteU, Date debut, Date fin,String etat) {
		beneficiaire = blocal.readByid(id_bene);
    	RenteU ren = new RenteU(beneficiaire, RenteU,debut,fin,etat);
  		em.persist(ren);
		
	}
	
	@Override
	public void updateR(int idrenteu,String etat,String motif){
    	RenteU ren = new RenteU(idrenteu,etat,motif);
		em.merge(ren);
	}


	@Override
	public void deleteRenteU(RenteU RenteU) {
		em.remove(em.merge(RenteU));
	}

	@Override
	public void update(RenteU RenteU) {
  		em.merge(RenteU);

	}

	@Override
	public List<RenteU> findAll() {
		return em.createQuery("select r from RenteU r ", RenteU.class).
  				getResultList();
	}

	public void ajoutRenteUP(int id_bene, float PM, Date debut, Date fin, Boolean valid) {
		beneficiaire = blocal.readByid(id_bene);
    	RenteU ren = new RenteU(beneficiaire, PM,debut,fin,valid);
  		em.persist(ren);
		
	}

	@Override
	public float getRenteU(int id) {
		Query req = em.createQuery("select r.rente from RenteU r where r.id=:id ");
		return (float)req.setParameter("id", id).getSingleResult();
	}

	public RenteU readByidu(int id) {
		Query req = em.createQuery("select g from RenteU g  where g.id=:id");
		return (RenteU)req.setParameter("id", id).getSingleResult();
	}

	@Override
	public void ajoutRenteUPM(float RenteUb) {
		RenteU ren = new RenteU(RenteUb);
  		em.persist(ren);
		
	}

	@Override
	public List<RenteU> findRV() {
		return em.createQuery("select s from RenteU s where s.valider=1", RenteU.class).
				getResultList();
	}
	
	@Override
	public List<RenteU> findRNV() {
		return em.createQuery("select s from RenteU s where s.valider=0", RenteU.class).
				getResultList();
	}

	@Override
	public List<RenteU> findF() {
		return em.createQuery("select s from RenteU s where s.DatePriseRenteU IS NULL and s.valider IS NULL", RenteU.class).
				getResultList();
	}
	
	@Override
	public List<RenteU> findR() {
		return em.createQuery("select s from RenteU s where (s.valider=0 or s.valider=1)", RenteU.class).
  				getResultList();
	}
	
	@Override
	public List<RenteU> findRF() {
		return em.createQuery("select s from RenteU s where s.bool IS NULL", RenteU.class).
  				getResultList();
	}

	@Override
	public void ajoutRenteUPN(int id_bene,float RenteU, float PM, Boolean rf, Date debut, Date fin) {
		beneficiaire = blocal.readByid(id_bene);
    	RenteU ren = new RenteU(beneficiaire, RenteU,PM,rf,debut,fin );
  		em.persist(ren);
		
	}

	@Override
	public Rente findByIdBenef(int idb){
		Query req = em.createQuery("select r from Rente r,Beneficiaire g  where g.id=:id and r.bool IS NULL ");
		return (Rente)req.setParameter("id", idb).getSingleResult();
	}
	
}
