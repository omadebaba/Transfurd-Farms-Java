package com.project.transfurdfarms.serviceImplementation;

import com.project.transfurdfarms.dto.AnimalsDTO;
import com.project.transfurdfarms.jpa.AnimalsJPA;
import com.project.transfurdfarms.services.AnimalsDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class AnimalDAOServiceImplementation implements AnimalsDAOService {


    @Autowired
    AnimalsJPA animalsJPA;

    public void saveAnimal(AnimalsDTO animalsDTO){

        animalsJPA.save(animalsDTO);

    }


    public void saveAndFlushAnimal(AnimalsDTO animalsDTO){

        animalsJPA.saveAndFlush(animalsDTO);
    }

    public AnimalsDTO findAnimalById(long id){


        return animalsJPA.findAnimalById(id);

    }

    public List<AnimalsDTO> findAll(){

        return animalsJPA.findAll();

    }

    public void deleteById(long id){

        animalsJPA.deleteById(id);
    }
}
