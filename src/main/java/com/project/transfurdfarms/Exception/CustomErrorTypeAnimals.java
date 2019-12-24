package com.project.transfurdfarms.Exception;

import com.project.transfurdfarms.dto.AnimalsDTO;
import com.project.transfurdfarms.dto.CropsDTO;

/**
 * @author Olabisi
 *
 */

public class CustomErrorTypeAnimals extends AnimalsDTO{
	
	private String errorMessage;
	
		public CustomErrorTypeAnimals(final String errorMessage){
			this.errorMessage = errorMessage;
		}
	
		public String getErrorMessage() {
			return errorMessage;
		}
}
