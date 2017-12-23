package tn.esprit.MaE.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.MaE.Interface.CoefficientServiceLocal;
import tn.esprit.MaE.entities.Coefficient;

/**
 * Session Bean implementation class CoefficientService
 */
@Stateless
@LocalBean
public class CoefficientService implements CoefficientServiceLocal {

	
	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public CoefficientService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addCoefficient(Coefficient coefficient) {
		em.persist(coefficient);
		
	}

	@Override
	public void ajoutCoeff(float Age, float Coeff_H, float Coeff_F) {
		Coefficient coefficient = new Coefficient(Age,Coeff_H,Coeff_F);
  		em.merge(coefficient);
  		
	}

	@Override
	public void ajoutAge(float Age) {
		Coefficient coefficient = new Coefficient(Age);
  		em.merge(coefficient);
		
	}

	@Override
	public void ajoutCoefH(float CoefH) {
		Coefficient coeff = new Coefficient(CoefH);
  		em.merge(coeff);
		
	}

	@Override
	public void ajoutCoefF(float CoefF) {
		Coefficient coefficient = new Coefficient(CoefF);
  		em.merge(coefficient);
		
	}

	@Override
	public float getCoefP(float age) {
		 Query req = em.createQuery("select c.coef_H from Coefficient c where c.Age=:age ");
			return (float)req.setParameter("age", age).getSingleResult();
			
	}

	@Override
	public float getCoefF(float age) {
		
		 Query req = em.createQuery("select c.coef_F from Coefficient c where c.Age=:age ");
			return (float)req.setParameter("age", age).getSingleResult();
			
		
	}

	@Override
	public List<Coefficient> findAll() {
		return em.createQuery("select s from Coefficient s", Coefficient.class).
  				getResultList();
	}

	@Override
	public void update(Coefficient Coefficient) {
		em.merge(Coefficient);
		
	}
	
	@Override
	public void Delete() {
	 em.createQuery("DELETE FROM Coefficient")
     .executeUpdate();
	}
}
