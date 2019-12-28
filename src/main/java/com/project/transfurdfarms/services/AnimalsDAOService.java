package com.project.transfurdfarms.services;

import com.project.transfurdfarms.dto.AnimalsDTO;
import org.apache.coyote.ajp.AjpNio2Protocol;

import java.util.List;

public interface AnimalsDAOService {

    AnimalsDTO findAnimalById(long id);
    List<AnimalsDTO> findAll();
    void deleteById(long id);

}
