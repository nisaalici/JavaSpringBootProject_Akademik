package com.inheritance.api.dto.request;

import java.time.LocalDate;

public class EmployeeRequest extends UserRequest {
    private String position;

    public EmployeeRequest() {
    }

    public EmployeeRequest(String name, String firstname, String lastname, LocalDate dateOfBirth,
                         String nationalIdentity, String email, String password, String position) {
        super(name, firstname, lastname, dateOfBirth, nationalIdentity, email, password);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
