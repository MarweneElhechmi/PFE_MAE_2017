package tn.esprit.MaE.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Coefficient implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_c;
	private float Age;
	private float coef_H;
	private float coef_F;
	
	public Coefficient(){
		
	}
	
	
	public Coefficient(float age2, float coeff_H, float coeff_F) {
		
		this.Age=age2;
		this.coef_H=coeff_H;
		this.coef_F=coeff_F;
		
	}
	
	 
	


	public Coefficient(float age2) {
		this.Age=age2;
	}


	public int getId_c() {
		return id_c;
	}
	public void setId_c(int id_c) {
		this.id_c = id_c;
	}


	public float getAge() {
		return Age;
	}


	public void setAge(float age) {
		Age = age;
	}


	public float getCoef_H() {
		return coef_H;
	}


	public void setCoef_H(float coef_H) {
		this.coef_H = coef_H;
	}


	public float getCoef_F() {
		return coef_F;
	}


	public void setCoef_F(float coef_F) {
		this.coef_F = coef_F;
	}
	
	

	
	
	
}
