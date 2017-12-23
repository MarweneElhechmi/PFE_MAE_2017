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

import tn.esprit.MaE.Interface.RenteServiceLocal;
import tn.esprit.MaE.entities.Beneficiaire;
import tn.esprit.MaE.entities.Rente;

/**
 * Session Bean implementation class RenteService
 */
@Stateless
@LocalBean
public class RenteService implements RenteServiceLocal {

	@EJB
	BeneficiaireService blocal;
	
	@EJB
	RenteService rlocal;

	Beneficiaire beneficiaire;
	Rente rente;
	
	@PersistenceContext(unitName="Mae-ejb")
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public RenteService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addRente(Rente Rente) {
		em.persist(Rente);
	}

	
	public void ajoutRente(int id_bene, int Rente, Date debut, Date fin,String etat) {
		beneficiaire = blocal.readByid(id_bene);
    	Rente ren = new Rente(beneficiaire, Rente,debut,fin,etat);
  		em.persist(ren);
		
	}

	@Override
	public void deleteRente(Rente Rente) {
		em.remove(em.merge(Rente));
	}

	@Override
	public void update(Rente Rente) {
  		em.merge(Rente);

	}

	@Override
	public List<Rente> findAll() {
		return em.createQuery("select r from Rente r where month(debut)= month(now()) and year(debut) = year(now())", Rente.class).
  				getResultList();
	}

	@Override
	public List<Rente> findAllT() {
		return em.createQuery("select r from Rente r" , Rente.class).
  				getResultList();
	}
	
	@Override
	public void ajoutRenteP(int id_bene, BigInteger PM, Date debut, Date fin, Boolean valid) {
		beneficiaire = blocal.readByid(id_bene);
    	Rente ren = new Rente(beneficiaire, PM,debut,fin,valid);
  		em.persist(ren);
		
	}

	@Override
	public Double getRente(int id) {
		Query req = em.createQuery("select r.rente from Rente r where r.id=:id ");
		return (Double)req.setParameter("id", id).getSingleResult();
	}

	public Rente readByid(int id) {
		Query req = em.createQuery("select g from Rente g  where g.id=:id");
		return (Rente)req.setParameter("id", id).getSingleResult();
	}

	@Override
	public void ajoutRentePM(int renteb) {
		Rente ren = new Rente(renteb);
  		em.persist(ren);
		
	}
	
	@Override
	public Rente selectRenteBenef(int id) {
		Query req = em.createQuery("select r from Rente r,Beneficiaire b  where b.id=:id");
		return (Rente)req.setParameter("id", id).getSingleResult();
	}
	
	@Override
	public List<Rente> findRVide(int id) {
		return em.createQuery("select s from Rente s,Beneficiaire b where s.valider IS NULL and b.id=:id ", Rente.class).setParameter("id", id).
				getResultList();
	}
	
	@Override
	public List<Rente> findRNV() {
		return em.createQuery("select s from Rente s where s.valider=0", Rente.class).
				getResultList();
	}

	@Override
	public List<Rente> findF() {
		return em.createQuery("select s from Rente s where s.DatePriseRente IS NULL and s.valider IS NULL and month(debut)= month(now()) and year(debut) = year(now())", Rente.class).
				getResultList();
	}
	
	@Override
	public List<Rente> findR() {
		return em.createQuery("select s from Rente s where (s.valider=0 or s.valider=1)", Rente.class).
  				getResultList();
	}
	
	@Override
	public List<Rente> findRF() {
		return em.createQuery("select s from Rente s ", Rente.class).
  				getResultList();
	}

	@Override
	public void ajoutRentePN(int id_bene,int rente, BigInteger PM, Boolean rf, Date debut, Date fin) {
		beneficiaire = blocal.readByid(id_bene);
    	Rente ren = new Rente(beneficiaire, rente,PM,rf,debut,fin );
  		em.persist(ren);
		
	}

	@Override
	public List<Rente> findRS(String cinb) {
		return em.createQuery("select s from Rente s JOIN s.beneficiairesR b where b.cinb=:cinb ", Rente.class).setParameter("cinb", cinb).
				getResultList();
	}

	@Override
	public List<Rente> findDossier(String cinb) {
		return em.createQuery("select s from Rente s JOIN s.beneficiairesR b where b.cinb=:cinb  ", Rente.class).setParameter("cinb", cinb).
				getResultList();
	}


	
}
