package com.project.transfurdfarms.jpa;

import com.project.transfurdfarms.services.AnimalsDAOService;
import org.springframework.data.jpa.repository.JpaRepository;
import com.project.transfurdfarms.dto.AnimalsDTO;
import org.springframework.stereotype.Repository;


@Repository
public interface AnimalsJPA extends JpaRepository<AnimalsDTO, Long>, AnimalsDAOService {


}
