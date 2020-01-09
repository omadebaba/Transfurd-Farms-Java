package com.project.transfurdfarms.controller;


import com.project.transfurdfarms.dto.FarmRegistrationDTO;
import com.project.transfurdfarms.serviceImplementation.FarmRegistrationServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/register")
public class FarmRegistrationController {

    public static final Logger logger = LoggerFactory.getLogger(FarmRegistrationController.class);


    FarmRegistrationServiceImpl farmRegistrationService;

    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public void setbCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {

        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Autowired
    public void setFarmRegistrationService(FarmRegistrationServiceImpl farmRegistrationService) {
        this.farmRegistrationService = farmRegistrationService;
    }

    @PostMapping("/")
    public ResponseEntity<FarmRegistrationDTO> registerFarm(@Valid @RequestBody  FarmRegistrationDTO farmRegistrationDTO){

        farmRegistrationDTO.setPassword(bCryptPasswordEncoder.encode(farmRegistrationDTO.getPassword()));

        farmRegistrationDTO.setRoles("USER");
        farmRegistrationDTO.setRegistrationDate(new Date());

        farmRegistrationService.save(farmRegistrationDTO);

        return new ResponseEntity<>(farmRegistrationDTO, HttpStatus.CREATED);
    }


    @GetMapping("/")
    @PreAuthorize("hasAnyAuthority('ADMIN')")

    public ResponseEntity<List<FarmRegistrationDTO>> findAllRegisteredUsers(){


        List<FarmRegistrationDTO> registeredUsers = farmRegistrationService.findAll();

        return new ResponseEntity<>(registeredUsers, HttpStatus.OK);
    }

}
