package us.onesquare.bastoji.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import us.onesquare.bastoji.dao.IIndividualDao;
import us.onesquare.bastoji.model.admin.Individual;
import us.onesquare.bastoji.service.IIndividualService;
@Component
public class IndividualServiceImpl implements IIndividualService{
	@Autowired
	IIndividualDao individualDao;
	

	@Override
	public Individual createIndividual(Individual individual) {
		
		return individualDao.createIndividual(individual);
	}

	@Override
	public Individual getIndividual(UUID id) {
		
		return individualDao.getIndividual(id);
	}

	@Override
	public void updateIndividual(Individual individual) {
	individualDao.updateIndividual(individual);
		
	}

}
