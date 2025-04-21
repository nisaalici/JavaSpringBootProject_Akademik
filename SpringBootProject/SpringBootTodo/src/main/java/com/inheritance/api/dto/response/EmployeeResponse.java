package com.inheritance.api.dto.response;

import java.time.LocalDate;

public class EmployeeResponse extends UserResponse {
    private String position;

    public EmployeeResponse() {
    }

    public EmployeeResponse(Long id, String name, String firstname, String lastname, 
                          LocalDate dateOfBirth, String nationalIdentity, String email, 
                          String position) {
        super(id, name, firstname, lastname, dateOfBirth, nationalIdentity, email);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
