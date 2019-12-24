/**
 * 
 */
package com.project.transfurdfarms.controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.type.CustomType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.transfurdfarms.Exception.CustomErrorTypeAnimals;
import com.project.transfurdfarms.dto.AnimalsDTO;
import com.project.transfurdfarms.jpa.AnimalsJPA;

/**
 * @author Olabisi
 *
 */

@RestController
@RequestMapping("api/animal")
public class AnimalRestController {
	public static final Logger logger = LoggerFactory.getLogger(AnimalRestController.class);
	
	private AnimalsJPA animalsJpaRepository;
	
	@Autowired
	public void setAnimalsJpaRepository(AnimalsJPA animalsJpaRepository) {
	this.animalsJpaRepository = animalsJpaRepository;	
	}
	
	@GetMapping("/")
	public ResponseEntity<List<AnimalsDTO>> listAllAnimals() {
		List<AnimalsDTO> animals = animalsJpaRepository.findAll();
		if(animals.isEmpty()) {
			return new ResponseEntity<List<AnimalsDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<AnimalsDTO>>(animals, HttpStatus.OK);
	}
	
	@PostMapping(value = "/")
	public ResponseEntity<AnimalsDTO> createAnimal(@Valid @RequestBody final AnimalsDTO animal) {
		logger.info("Creating Animal : {}", animal);
		//animalsJpaRepository.save(animal);
		if (animalsJpaRepository.findById(animal.getId())!= null) {
			logger.error("Unable to create. An Animal with name {} already exist", animal.getAnimalType());
			return new ResponseEntity<AnimalsDTO>(new CustomErrorTypeAnimals("Unable to create new animal. Animal with type"
					+ animal.getAnimalType() + "already exist!."), HttpStatus.CONFLICT);
			
		}
		return new ResponseEntity<AnimalsDTO>(animal, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AnimalsDTO> getAnimalById(@PathVariable("id") final long id){
		AnimalsDTO animal = animalsJpaRepository.findAnimalById(id);
		if (animal == null) {
			return new ResponseEntity<AnimalsDTO>(new CustomErrorTypeAnimals("Animal with id"
					+ id + "not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<AnimalsDTO>(animal, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<AnimalsDTO> updateAnimal(@PathVariable("id") final long id, @RequestBody AnimalsDTO animal){
		AnimalsDTO currentAnimal = animalsJpaRepository.findAnimalById(id);
		if(currentAnimal == null) {
			return new ResponseEntity<AnimalsDTO>(new CustomErrorTypeAnimals("Unable to update. Animal with id"
					+ id + "not found!"), HttpStatus.NOT_FOUND);
		}
		
		animal.setAnimalType(animal.getAnimalType());
		animal.setAgeOnArrival(animal.getAgeOnArrival());
		animal.setNumberOfAnimals(animal.getNumberOfAnimals());
		animal.setArrivalDate(animal.getArrivalDate());
		animal.setVaccinationDate(animal.getVaccinationDate());
		animal.setMaturityAge(animal.getMaturityAge());
		animal.setProposedUnitSellingPrice(animal.getProposedUnitSellingPrice());
		animal.setMortalityRate(animal.getMortalityRate());
		
		animalsJpaRepository.saveAndFlush(animal);
		return new ResponseEntity<AnimalsDTO>(currentAnimal, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<AnimalsDTO> deleteAnimal(@PathVariable("id") final long id) {
		AnimalsDTO animal = animalsJpaRepository.findAnimalById(id);
		if(animal == null) {
			return new ResponseEntity<AnimalsDTO>(new CustomErrorTypeAnimals("Unable to delete. Animal with id"
					+ id + "not found!"), HttpStatus.NOT_FOUND);
		}
		animalsJpaRepository.deleteById(id);
		return new ResponseEntity<AnimalsDTO>( new CustomErrorTypeAnimals("Deleted Animal with id"
				+ id + "."), HttpStatus.NO_CONTENT);
	}	
}
