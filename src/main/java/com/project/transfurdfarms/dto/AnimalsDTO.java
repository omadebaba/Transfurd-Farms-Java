package com.project.transfurdfarms.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Animals")
public class AnimalsDTO {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "Animal_Type")
	private String animalType;
	
	@Column(name = "Number_Of_Animal")
	private long numberOfAnimals;
	
	@Column(name = "Age")
	private long age;
	
	@Column(name = "Vaccination_Date")
	private Date vaccinationDate;
	
	@Column(name = "Maturity_Age")
	private long maturityAge;

	public String getAnimalType() {
		return animalType;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	public long getNumberOfAnimals() {
		return numberOfAnimals;
	}

	public void setNumberOfAnimals(long numberOfAnimals) {
		this.numberOfAnimals = numberOfAnimals;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public Date getVaccinationDate() {
		return vaccinationDate;
	}

	public void setVaccinationDate(Date vaccinationDate) {
		this.vaccinationDate = vaccinationDate;
	}

	public long getMaturityAge() {
		return maturityAge;
	}

	public void setMaturityAge(long maturityAge) {
		this.maturityAge = maturityAge;
	}
}
