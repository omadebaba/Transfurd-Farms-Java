package com.project.transfurdfarms.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.transfurdfarms.dto.CropsDTO;

public interface CropsJpaRepository extends JpaRepository<CropsDTO, Long> {
	
	CropsDTO findCropById(long id);

	CropsDTO findByCropType(String cropType);
	

}
