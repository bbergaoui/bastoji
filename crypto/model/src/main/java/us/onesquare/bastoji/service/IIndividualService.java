package us.onesquare.bastoji.service;

import java.util.UUID;

import us.onesquare.bastoji.model.admin.Individual;

public interface IIndividualService {

	
	Individual createIndividual( Individual individual);

	Individual getIndividual(UUID id);

	void updateIndividual(Individual individualData);

}
