package com.inheritance.api.dto.response;

import java.time.LocalDate;

public class ApplicantResponse extends UserResponse {
    private String about;

    public ApplicantResponse() {
    }

    public ApplicantResponse(Long id, String name, String firstname, String lastname, 
                           LocalDate dateOfBirth, String nationalIdentity, String email, 
                           String about) {
        super(id, name, firstname, lastname, dateOfBirth, nationalIdentity, email);
        this.about = about;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
