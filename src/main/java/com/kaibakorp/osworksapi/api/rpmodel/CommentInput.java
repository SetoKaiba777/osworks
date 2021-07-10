package com.kaibakorp.osworksapi.api.rpmodel;

import javax.validation.constraints.NotBlank;

public class CommentInput {

    @NotBlank
    private String descrption;

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }
}
