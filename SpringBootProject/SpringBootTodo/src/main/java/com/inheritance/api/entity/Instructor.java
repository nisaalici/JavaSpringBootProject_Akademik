package com.inheritance.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "instructors")
@PrimaryKeyJoinColumn(name = "user_id")
public class Instructor extends User {
    
    @Column(nullable = false)
    private String companyName;

    // Constructors
    public Instructor() {
    }

    // Getters and Setters
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
