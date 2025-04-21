package com.inheritance.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "applicants")
@PrimaryKeyJoinColumn(name = "user_id")
public class Applicant extends User {
    
    @Column(nullable = false, columnDefinition = "TEXT")
    private String about;

    // Constructors
    public Applicant() {
    }

    // Getters and Setters
    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
