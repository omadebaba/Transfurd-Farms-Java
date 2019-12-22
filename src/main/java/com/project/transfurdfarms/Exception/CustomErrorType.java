package com.project.transfurdfarms.Exception;

import com.project.transfurdfarms.dto.CropsDTO;

public class CustomErrorType extends CropsDTO {
	
	private String errorMessage;
		
		public CustomErrorType(final String errorMessage) {
			this.errorMessage = errorMessage;
		}
		
	@Override
		public String getErrorMessage() {
		return errorMessage;
	}

}
