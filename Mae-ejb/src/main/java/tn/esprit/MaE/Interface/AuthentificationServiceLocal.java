package tn.esprit.MaE.Interface;

import javax.ejb.Local;

import tn.esprit.MaE.entities.User;

@Local
public interface AuthentificationServiceLocal {

	String getIdFromEmail(String email);
	User authentifier(String email,String pwd);
}
