package tn.esprit.MaE.services;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.MaE.Interface.AuthentificationServiceLocal;
import tn.esprit.MaE.entities.User;

/**
 * Session Bean implementation class AuthentificationService
 */
@Stateless
@LocalBean
public class AuthentificationService implements AuthentificationServiceLocal {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public AuthentificationService() {
        // TODO Auto-generated constructor stub
    }

    @Override
	public String getIdFromEmail(String email) {
		// TODO Auto-generated method stub
		return (String) em.createQuery("SELECT n.id from User n WHERE n.email LIKE :email").setParameter("email", email).getSingleResult();
	}
	


    @Override
    public User authentifier(String email,String pwd) {
    	User utilisateur = null;
		Query query = em
				.createQuery("select u from User u where u.email=:email and u.pwd=:pwd");
		query.setParameter("email", email).setParameter("pwd", pwd);
		
		try {
			utilisateur = (User) query.getSingleResult();
			
		} catch (Exception e) {
			Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "authentication failed with email="+email+" and pwd="+pwd);
		}
		return utilisateur;
	}

}
