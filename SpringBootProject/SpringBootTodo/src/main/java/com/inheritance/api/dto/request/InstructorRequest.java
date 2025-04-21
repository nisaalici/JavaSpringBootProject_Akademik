package com.inheritance.api.dto.request;

import java.time.LocalDate;

public class InstructorRequest extends UserRequest {
    private String companyName;

    public InstructorRequest() {
    }

    public InstructorRequest(String name, String firstname, String lastname, LocalDate dateOfBirth,
                           String nationalIdentity, String email, String password, String companyName) {
        super(name, firstname, lastname, dateOfBirth, nationalIdentity, email, password);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
