package com.project.transfurdfarms.services;

import com.project.transfurdfarms.dto.CropsDTO;

import java.util.List;

public interface CropsDAOService {

    CropsDTO findCropById(long id);
    CropsDTO findByCropType(String cropType);
    List<CropsDTO> findAll();
    void deleteById(long id);
}
