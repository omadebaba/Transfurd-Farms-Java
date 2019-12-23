package com.project.transfurdfarms.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.transfurdfarms.dto.AnimalsDTO;


public interface AnimalsJPA extends JpaRepository<AnimalsDTO, Long> {
	
	AnimalsDTO findAnimalById(long id);

}
