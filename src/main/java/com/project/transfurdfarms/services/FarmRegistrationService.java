package com.project.transfurdfarms.services;

import com.project.transfurdfarms.dto.FarmRegistrationDTO;

public interface FarmRegistrationService {

    FarmRegistrationDTO findByEmail(String email);


}
