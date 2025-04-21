package com.inheritance.api.service.impl;

import com.inheritance.api.dto.request.ApplicantRequest;
import com.inheritance.api.dto.response.ApplicantResponse;
import com.inheritance.api.entity.Applicant;
import com.inheritance.api.exception.ResourceNotFoundException;
import com.inheritance.api.repository.ApplicantRepository;
import com.inheritance.api.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    private final ApplicantRepository applicantRepository;

    @Autowired
    public ApplicantServiceImpl(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    @Override
    public ApplicantResponse add(ApplicantRequest request) {
        Applicant applicant = new Applicant();
        applicant.setName(request.getName());
        applicant.setFirstname(request.getFirstname());
        applicant.setLastname(request.getLastname());
        applicant.setDateOfBirth(request.getDateOfBirth());
        applicant.setNationalIdentity(request.getNationalIdentity());
        applicant.setEmail(request.getEmail());
        applicant.setPassword(request.getPassword());
        applicant.setAbout(request.getAbout());

        Applicant savedApplicant = applicantRepository.save(applicant);

        return mapToApplicantResponse(savedApplicant);
    }

    @Override
    public ApplicantResponse update(Long id, ApplicantRequest request) {
        Applicant applicant = applicantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Applicant not found with id: " + id));

        applicant.setName(request.getName());
        applicant.setFirstname(request.getFirstname());
        applicant.setLastname(request.getLastname());
        applicant.setDateOfBirth(request.getDateOfBirth());
        applicant.setNationalIdentity(request.getNationalIdentity());
        applicant.setEmail(request.getEmail());
        applicant.setPassword(request.getPassword());
        applicant.setAbout(request.getAbout());

        Applicant updatedApplicant = applicantRepository.save(applicant);

        return mapToApplicantResponse(updatedApplicant);
    }

    @Override
    public void delete(Long id) {
        Applicant applicant = applicantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Applicant not found with id: " + id));

        applicantRepository.delete(applicant);
    }

    @Override
    public ApplicantResponse getById(Long id) {
        Applicant applicant = applicantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Applicant not found with id: " + id));

        return mapToApplicantResponse(applicant);
    }

    @Override
    public List<ApplicantResponse> getAll() {
        List<Applicant> applicants = applicantRepository.findAll();

        return applicants.stream()
                .map(this::mapToApplicantResponse)
                .collect(Collectors.toList());
    }

    // Utility method to map Applicant entity to ApplicantResponse DTO
    private ApplicantResponse mapToApplicantResponse(Applicant applicant) {
        return new ApplicantResponse(
                applicant.getId(),
                applicant.getName(),
                applicant.getFirstname(),
                applicant.getLastname(),
                applicant.getDateOfBirth(),
                applicant.getNationalIdentity(),
                applicant.getEmail(),
                applicant.getAbout()
        );
    }
}
