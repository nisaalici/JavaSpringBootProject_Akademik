package com.inheritance.api.dto.request;

import java.time.LocalDate;

public class ApplicantRequest extends UserRequest {
    private String about;

    public ApplicantRequest() {
    }

    public ApplicantRequest(String name, String firstname, String lastname, LocalDate dateOfBirth,
                          String nationalIdentity, String email, String password, String about) {
        super(name, firstname, lastname, dateOfBirth, nationalIdentity, email, password);
        this.about = about;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
