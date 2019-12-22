/**
 * 
 */
package com.project.transfurdfarms.Exception;

import com.project.transfurdfarms.dto.AnimalsDTO;

/**
 * @author Olabisi
 *
 */

public class CustomErrorType extends AnimalsDTO {
	
	private String errorMessage;
	
		public CustomErrorType(final String errorMessage){
			this.errorMessage = errorMessage;
		}
	
		public String getErrorMessage() {
			return errorMessage;
		}
}
