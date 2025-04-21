package com.inheritance.api.dto.response;

import java.time.LocalDate;

public class InstructorResponse extends UserResponse {
    private String companyName;

    public InstructorResponse() {
    }

    public InstructorResponse(Long id, String name, String firstname, String lastname, 
                            LocalDate dateOfBirth, String nationalIdentity, String email, 
                            String companyName) {
        super(id, name, firstname, lastname, dateOfBirth, nationalIdentity, email);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
