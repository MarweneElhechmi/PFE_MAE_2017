package tn.esprit.MaE.Interface;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.MaE.entities.Admin;

@Local
public interface AdminServiceLocal {

	public void addAdmin(Admin ad);
	public void updateAdmin(Admin ad);
	public Boolean updateAdminB(Admin admin) ;
	public void deleteAdmin(Integer id);
	public List<Admin> findAdmins();
	public List<Admin> findByEmail(String email);
	public boolean searchByEmail(String email);
	public Admin findByid(int id);
	public Admin findByEmail1(String email);
	
}
