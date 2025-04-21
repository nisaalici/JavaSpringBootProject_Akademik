package com.inheritance.api.controller;

import com.inheritance.api.dto.request.ApplicantRequest;
import com.inheritance.api.dto.response.ApplicantResponse;
import com.inheritance.api.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {

    private final ApplicantService applicantService;

    @Autowired
    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @PostMapping
    public ResponseEntity<ApplicantResponse> createApplicant(@RequestBody ApplicantRequest applicantRequest) {
        ApplicantResponse createdApplicant = applicantService.add(applicantRequest);
        return new ResponseEntity<>(createdApplicant, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplicantResponse> getApplicantById(@PathVariable Long id) {
        ApplicantResponse applicant = applicantService.getById(id);
        return ResponseEntity.ok(applicant);
    }

    @GetMapping
    public ResponseEntity<List<ApplicantResponse>> getAllApplicants() {
        List<ApplicantResponse> applicants = applicantService.getAll();
        return ResponseEntity.ok(applicants);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApplicantResponse> updateApplicant(@PathVariable Long id, 
                                                           @RequestBody ApplicantRequest applicantRequest) {
        ApplicantResponse updatedApplicant = applicantService.update(id, applicantRequest);
        return ResponseEntity.ok(updatedApplicant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplicant(@PathVariable Long id) {
        applicantService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
