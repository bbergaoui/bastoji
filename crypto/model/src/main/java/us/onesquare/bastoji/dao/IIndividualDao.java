package us.onesquare.bastoji.dao;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import us.onesquare.bastoji.model.admin.Individual;

public interface IIndividualDao {
	
	public Individual createIndividual(Individual individual);

	public Individual getIndividual(UUID id);

	public void updateIndividual(Individual individual);

	public void deleteIndividual(UUID id);
	
	public void deleteAll();

	public List<Individual> getAllIndividuals();

	void deleteIndividuals(Collection<UUID> individuals);

	Individual findByUserId(Long userId);
}
