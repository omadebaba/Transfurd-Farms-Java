package com.project.transfurdfarms.jpa;

import com.project.transfurdfarms.services.CropsDAOService;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.transfurdfarms.dto.CropsDTO;

public interface CropsJpaRepository extends JpaRepository<CropsDTO, Long>, CropsDAOService {

	

}
