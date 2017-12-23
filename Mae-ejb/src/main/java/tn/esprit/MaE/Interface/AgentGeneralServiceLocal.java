package tn.esprit.MaE.Interface;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.MaE.entities.AgentGeneral;

@Local
public interface AgentGeneralServiceLocal {

	public void addAgentGeneral(AgentGeneral AgentGeneral);
	public void deleteAgentGeneral(AgentGeneral AgentGeneral);
	public AgentGeneral findByCin(String cin);
	public void update(AgentGeneral AgentGeneral);
	public List<AgentGeneral> findAll();
	public AgentGeneral findById(int id_u);
	
}
