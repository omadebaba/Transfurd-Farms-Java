<<<<<<< HEAD
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

=======
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
>>>>>>> a5cdac595779ebbb059c877abfc476806d64b219
}
