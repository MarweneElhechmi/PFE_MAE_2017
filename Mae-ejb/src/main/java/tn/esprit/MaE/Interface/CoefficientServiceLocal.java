package tn.esprit.MaE.Interface;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.MaE.entities.Coefficient;

@Local
public interface CoefficientServiceLocal {

	public void addCoefficient(Coefficient coefficient);
	public void ajoutCoeff(float Age, float Coeff_H, float Coeff_F);
	public void ajoutAge(float Age);
	public void ajoutCoefH(float CoefH);
	public List<Coefficient> findAll();
	public void update(Coefficient Coefficient);
	public void ajoutCoefF(float CoefF);
	public float getCoefP(float age);
	public float getCoefF(float age);
	public void Delete();
	
}
