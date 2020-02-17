package com.project.transfurdfarms.jpa;

import com.project.transfurdfarms.dto.FarmRegistrationDTO;
import com.project.transfurdfarms.services.FarmRegistrationService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository()
public interface FarmRegistrationJPA extends JpaRepository<FarmRegistrationDTO, Long>, FarmRegistrationService {

}
