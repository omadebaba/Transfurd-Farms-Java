package com.project.transfurdfarms.serviceImplementation;

import com.project.transfurdfarms.dto.FarmRegistrationDTO;
import com.project.transfurdfarms.jpa.FarmRegistrationJPA;
import com.project.transfurdfarms.services.FarmRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmRegistrationServiceImpl implements FarmRegistrationService {

    @Autowired
    FarmRegistrationJPA farmRegistrationJPA;


    public FarmRegistrationDTO findByEmail(String email){

        return farmRegistrationJPA.findByEmail(email);

    }


    public void save(FarmRegistrationDTO farmRegistrationDTO){

        farmRegistrationJPA.save(farmRegistrationDTO);
    }

    public void saveAndFlush(FarmRegistrationDTO farmRegistrationDTO){

        farmRegistrationJPA.saveAndFlush(farmRegistrationDTO);
    }


    public List<FarmRegistrationDTO> findAll(){


        return farmRegistrationJPA.findAll();
    }
}
