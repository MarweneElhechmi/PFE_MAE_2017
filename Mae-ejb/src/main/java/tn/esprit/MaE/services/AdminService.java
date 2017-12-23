package tn.esprit.MaE.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.MaE.Interface.AdminServiceLocal;
import tn.esprit.MaE.entities.Admin;

/**
 * Session Bean implementation class AdminService
 */
@Stateless
@LocalBean
public class AdminService implements AdminServiceLocal {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public AdminService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addAdmin(Admin ad) {
		em.persist(ad);
		
	}

	@Override
	public void updateAdmin(Admin ad) {
		em.merge(ad);
		
	}

	@Override
	public Boolean updateAdminB(Admin admin) {
		em.merge(admin);
		return null;
	}

	@Override
	public void deleteAdmin(Integer id) {
		em.remove(em.find(Admin.class, id));
		
	}

	@Override
	public List<Admin> findAdmins() {
		return em.createQuery("select s from Admin s", Admin.class).
				getResultList();
	}

	@Override
	public List<Admin> findByEmail(String email) {
		return em.createQuery("select s from Admin s where UPPER(s.email) LIKE :x", Admin.class)
				.setParameter("x", "%"+email.toUpperCase()+"%").getResultList();
	}

	@Override
	public boolean searchByEmail(String email) {
		List<Admin> admins = new ArrayList<Admin>();
		admins=em.createQuery("select s from Admin s where s.email=:x", Admin.class)
				.setParameter("x", email).getResultList();
		if (admins.isEmpty()) {
			return false;
		}
		else return true;
		
	}

	@Override
	public Admin findByid(int id) {
		return (Admin) em.createQuery("select s from Admin s where s.id  =:x", Admin.class)
				.setParameter("x", id).getResultList();
	}

	@Override
	public Admin findByEmail1(String email) {
		return   (Admin) em.createQuery("select s from Admin s where s.email  =:x", Admin.class)
				.setParameter("x", email).getResultList();
	}

}
