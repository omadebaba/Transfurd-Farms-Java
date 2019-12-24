 package com.project.transfurdfarms.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Crops")
public class CropsDTO {
	
	
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

	@Column(name = "Crop_Type")
	private String cropType;
	
	@Column(name = "Planting_Date")
	private Date plantingDate;
	
	@Column(name = "Fertilizer_Application_Date")
	private Date fertilizerApplicationDate;
	
	@Column(name = "Weeding_date")
	private Date weedingDate;
	
	@Column(name = "Pesticide_Application_Date")
	private Date pesticideApplicationDate;
	
	@Column(name = "Maturity_Age")
	private int maturityAge;

	public String getCropType() {
		return cropType;
	}

	public void setCropType(String cropType) {
		this.cropType = cropType;
	}

	public Date getPlantingDate() {
		return plantingDate;
	}

	public void setPlantingDate(Date plantingDate) {
		this.plantingDate = plantingDate;
	}

	public Date getFertilizerApplicationDate() {
		return fertilizerApplicationDate;
	}

	public void setFertilizerApplicationDate(Date fertilizerApplicationDate) {
		this.fertilizerApplicationDate = fertilizerApplicationDate;
	}

	public Date getWeedingDate() {
		return weedingDate;
	}

	public void setWeedingDate(Date weedingDate) {
		this.weedingDate = weedingDate;
	}

	public Date getPesticideApplicationDate() {
		return pesticideApplicationDate;
	}

	public void setPesticideApplicationDate(Date pesticideApplicationDate) {
		this.pesticideApplicationDate = pesticideApplicationDate;
	}

	public int getMaturityAge() {
		return maturityAge;
	}

	public void setMaturityAge(int maturityAge) {
		this.maturityAge = maturityAge;
	}



}
