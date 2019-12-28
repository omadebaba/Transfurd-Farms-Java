package com.project.transfurdfarms.serviceImplementation;

import com.project.transfurdfarms.dto.CropsDTO;
import com.project.transfurdfarms.jpa.CropsJpaRepository;
import com.project.transfurdfarms.services.CropsDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CropsDAOServiceImplementation  implements CropsDAOService {

    @Autowired
    CropsJpaRepository cropsJpaRepository;

    public void saveCrop(CropsDTO cropsDTO){

        cropsJpaRepository.save(cropsDTO);
    }

    public void saveAndFlushCrop(CropsDTO cropsDTO){

         cropsJpaRepository.saveAndFlush(cropsDTO);
    }

    public CropsDTO findCropById(long id){


        return cropsJpaRepository.findCropById(id);
    }

    public CropsDTO findByCropType(String cropType){

        return cropsJpaRepository.findByCropType(cropType);
    }

    public List<CropsDTO> findAll(){

        return cropsJpaRepository.findAll();
    }

    public void deleteById(long id){

        cropsJpaRepository.deleteById(id);
    }
}
