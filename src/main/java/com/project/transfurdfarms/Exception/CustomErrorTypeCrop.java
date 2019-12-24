package com.project.transfurdfarms.Exception;

import com.project.transfurdfarms.dto.CropsDTO;

public class CustomErrorTypeCrop extends CropsDTO {


    private String errorMessage;

    public CustomErrorTypeCrop(final String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
