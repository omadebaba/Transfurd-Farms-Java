package com.project.transfurdfarms.dto;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import org.hibernate.validator.constraints.Length;



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

	@NotNull(message = "error.animalType.NotNull")
	@Column(name = "Animal_Type")
	private String animalType;
	
	@NotNull(message = "error.numberOfAnimals.NotNull")
	@Column(name = "Number_Of_Animals")
	private long numberOfAnimals;
	
	@NotNull(message = "error.ageOnArrival.NotNull")
	@Column(name = "Age_On_Arrival")
	private long ageOnArrival;
	
	@NotNull(message = "error.arrivalDate.NotNull")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Column(name = "Arrival_Date")
	private Date arrivalDate;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Column(name = "Vaccination_Date")
	private Date vaccinationDate;
	
	@Column(name = "Maturity_Age")
	private long maturityAge;
	
	@Column(name = "Proposed_Unit_Selling_Price")
	private float proposedUnitSellingPrice;
	
	@Column(name = "Mortality_Rate")
	private float mortalityRate;
	
// Setters and Getters

	public long getAgeOnArrival() {
		return ageOnArrival;
	}

	public void setAgeOnArrival(long ageOnArrival) {
		this.ageOnArrival = ageOnArrival;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public float getProposedUnitSellingPrice() {
		return proposedUnitSellingPrice;
	}

	public void setProposedUnitSellingPrice(float proposedUnitSellingPrice) {
		this.proposedUnitSellingPrice = proposedUnitSellingPrice;
	}

	public float getMortalityRate() {
		return mortalityRate;
	}

	public void setMortalityRate(float mortalityRate) {
		this.mortalityRate = mortalityRate;
	}

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
