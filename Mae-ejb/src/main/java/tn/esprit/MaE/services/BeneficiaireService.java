package tn.esprit.MaE.services;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.MaE.Interface.BeneficiaireServiceLocal;
import tn.esprit.MaE.entities.Beneficiaire;
import tn.esprit.MaE.entities.Victime;

/**
 * Session Bean implementation class BeneficiaireService
 */
@Stateless
@LocalBean
public class BeneficiaireService implements BeneficiaireServiceLocal {

	@EJB
	BeneficiaireService blocal;
	
	@EJB
	VictimeService local;

	Beneficiaire beneficiaire;
	Victime victime;
	
	@PersistenceContext(unitName="Mae-ejb")
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public BeneficiaireService() {
        // TODO Auto-generated constructor stub
    }

    @Override
  	public void addBeneficiaire(Beneficiaire Beneficiaire) {
  		em.persist(Beneficiaire);
  		
  	}
    
    @Override
  	public void ajoutBeneficiaire(int idVictime, float age ,String cin,String nom,String prenom,Date naissance,String etat, int conjoint) {
    	victime = local.readByid(idVictime);
    	Beneficiaire benf = new Beneficiaire(victime, age ,cin, nom,prenom,naissance, etat, conjoint);
  		em.merge(benf);
  		
  	}

  	@Override
  	public void deleteBeneficiaire(Beneficiaire Beneficiaire) {
  		em.remove(em.merge(Beneficiaire));
  		
  	}

  	@Override
  	public Beneficiaire findByCin(String cin) {
  		return em.find(Beneficiaire.class,cin);
  	}

  	@Override
  	public void update(Beneficiaire Beneficiaire) {
  		em.merge(Beneficiaire);
  		
  	}

  	@Override
  	public List<Beneficiaire> findAll() {
  		return em.createQuery("select s from Beneficiaire s ", Beneficiaire.class).
  				getResultList();
  	}
  	
  	@Override
  	public List<Beneficiaire> findAllB(int id_v) {
  		return em.createQuery("select s from Beneficiaire s JOIN s.victime v where v.id_v=:id_v", Beneficiaire.class).setParameter("id_v", id_v).
  				getResultList();
  	}
  	
  	@Override
  	public Beneficiaire readByid(int id) {
  		Query req = em.createQuery("select g from Beneficiaire g  where g.id=:id");
  		return (Beneficiaire)req.setParameter("id", id).getSingleResult();
  	}
  	
  	@Override
  	public int getMaxIdB() {
  		Query req = em.createQuery("select max(g.id) from Beneficiaire g ");
  		return (int)req.getSingleResult();
  	}
  	
	@Override
	public long calculBenefP(int id) {
		
		  Query req = em.createQuery("select COUNT(b.etat) from Beneficiaire b, Victime v where v.id=:id and (b.etat='Pere' or b.etat='Mere' or b.etat='PetitFils') ");
		return (long)req.setParameter("id", id).getSingleResult();
		
	}
	
	@Override
	public long calculBenefF(int id) {
		
		  Query req = em.createQuery("select COUNT(b.etat) from Beneficiaire b, Victime v where v.id=:id and (b.etat='Fils' or b.etat='Fille' or b.etat='Handicape') ");
		return (long)req.setParameter("id", id).getSingleResult();
		
	}

	@Override
	public long calculBenefV(int id) {
		
		  Query req = em.createQuery("select COUNT(b.etat) from Beneficiaire b, Victime v where v.id=:id and b.etat='Veuve' ");
		return (long)req.setParameter("id", id).getSingleResult();
		
	}

	@Override
	public float RecupereRente(int id) {
		 Query req = em.createQuery("select r.rente from RenteU r, Beneficiaire b where (b.id=:id)   ");
			return (float)req.setParameter("id", id).getSingleResult();
			
	}
	
	@Override
	public float RecuperePM(int id) {
		 Query req = em.createQuery("select r.PM from RenteU r, Beneficiaire b where b.id=:id  ");
			return (float)req.setParameter("id", id).getSingleResult();
			
	}

	@Override
	public List<Beneficiaire> findR() {
		return em.createQuery("select s from Beneficiaire s,Rente r where r.dpr IS NULL", Beneficiaire.class).
  				getResultList();
	}

	

	
	

}
