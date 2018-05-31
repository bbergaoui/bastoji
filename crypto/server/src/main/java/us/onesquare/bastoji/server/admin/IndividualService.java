package us.onesquare.bastoji.server.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import us.onesquare.bastoji.model.admin.Individual;

@Service("individualService")
public class IndividualService {
private IndividualRepository individualRepository;
	
    @Autowired
    public IndividualService(IndividualRepository individualRepository) { 
      this.individualRepository = individualRepository;
    }
	
	public void saveUser(Individual individual) {
		individualRepository.save(individual);	
		}
	
	}

