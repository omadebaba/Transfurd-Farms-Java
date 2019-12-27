package com.project.tranfurdfarms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.transfurdfarms.dto.FarmRegistration;
import com.project.transfurdfarms.jpa.FarmRegistrationJPA;

@Service("farmService")
public class FarmService {

	private FarmRegistrationJPA farmRegistrationjpa;
	
    @Autowired
    public FarmService(FarmRegistrationJPA farmRegistrationjpa) { 
      this.farmRegistrationjpa = farmRegistrationjpa;
    }
    
	public FarmRegistration findByEmail(String email) {
		return farmRegistrationjpa.findByEmail(email);
	}
	
	public FarmRegistration findByConfirmationToken(String confirmationToken) {
		return farmRegistrationjpa.findByConfirmationToken(confirmationToken);
	}
	
	public void saveUser(FarmRegistration farm) {
		farmRegistrationjpa.save(farm);
	}

}
