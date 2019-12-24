package com.project.transfurdfarms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.transfurdfarms.Exception.CustomErrorTypeCrop;
import com.project.transfurdfarms.dto.CropsDTO;
import com.project.transfurdfarms.jpa.CropsJpaRepository;

@RestController
@RequestMapping("/api/crops")
public class CropController {
	public static final Logger logger =
			LoggerFactory.getLogger(CropController.class);
	
	private CropsJpaRepository cropsJpaRepository;
	
	@Autowired
	public void setCropsRepository(CropsJpaRepository cropsJpaRepository) {
		this.cropsJpaRepository = cropsJpaRepository;
		
	}

	@GetMapping("/")
	public ResponseEntity<List<CropsDTO>> listAllCrops(){
		List<CropsDTO> crops = cropsJpaRepository.findAll();
		if (crops.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(crops, HttpStatus.OK);
	}




	
	@GetMapping("/{id}")
	public ResponseEntity<CropsDTO> getCropById(@PathVariable("id")final Long id){
		CropsDTO crops = cropsJpaRepository.findCropById(id);
		if(crops == null) {
			return new ResponseEntity<CropsDTO>(
					new CustomErrorTypeCrop("User with id"
							+ id + "not found"), HttpStatus.NOT_FOUND);
					
		}
		return new ResponseEntity<CropsDTO>(crops, HttpStatus.OK);
	}
	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CropsDTO> createCrop(@RequestBody final CropsDTO crops){

		if (cropsJpaRepository.findByCropType(crops.getCropType()) != null) {
			return new ResponseEntity<CropsDTO>(new CustomErrorTypeCrop(
					"Unable to create new crop type, A Crop Type " + crops.getCropType()
					+ " already exist."), HttpStatus.CONFLICT);
		}
		
		cropsJpaRepository.save(crops);
		return new ResponseEntity<CropsDTO>(crops, HttpStatus.CREATED);
	}



	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CropsDTO> updateCrop(
			@PathVariable("id") final Long id, @RequestBody CropsDTO crops){
		CropsDTO currentCrops = cropsJpaRepository.findCropById(id);
		if (currentCrops == null) {
			return new ResponseEntity<CropsDTO>(
					new CustomErrorTypeCrop("Unable  to update. Crop with id" + id + "not found."), HttpStatus.NOT_FOUND);
					
			
		}
		currentCrops.setCropType(crops.getCropType());
		currentCrops.setFertilizerApplicationDate(crops.getFertilizerApplicationDate());
		currentCrops.setMaturityAge(crops.getMaturityAge());
		currentCrops.setPesticideApplicationDate(crops.getPesticideApplicationDate());
		currentCrops.setPlantingDate(crops.getPlantingDate());
		currentCrops.setWeedingDate(crops.getWeedingDate());
		
		cropsJpaRepository.saveAndFlush(currentCrops);
		
		return new ResponseEntity<CropsDTO>(currentCrops, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<CropsDTO> deleteCrop(@PathVariable("id")final Long id){
		CropsDTO crops = cropsJpaRepository.findCropById(id);
		if(crops == null) {
			return new ResponseEntity<CropsDTO>(

					new CustomErrorTypeCrop("Unable to delete. User with id" + id + "not found."), HttpStatus.NOT_FOUND);
		}
		
		cropsJpaRepository.deleteById(id);
		return new ResponseEntity<>(
				new CustomErrorTypeCrop("Deleted crop with id" + id + "."), HttpStatus.NO_CONTENT);
		
	}

}
