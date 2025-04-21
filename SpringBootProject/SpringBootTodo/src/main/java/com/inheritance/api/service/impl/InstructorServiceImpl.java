package com.inheritance.api.service.impl;

import com.inheritance.api.dto.request.InstructorRequest;
import com.inheritance.api.dto.response.InstructorResponse;
import com.inheritance.api.entity.Instructor;
import com.inheritance.api.exception.ResourceNotFoundException;
import com.inheritance.api.repository.InstructorRepository;
import com.inheritance.api.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public InstructorResponse add(InstructorRequest request) {
        Instructor instructor = new Instructor();
        instructor.setName(request.getName());
        instructor.setFirstname(request.getFirstname());
        instructor.setLastname(request.getLastname());
        instructor.setDateOfBirth(request.getDateOfBirth());
        instructor.setNationalIdentity(request.getNationalIdentity());
        instructor.setEmail(request.getEmail());
        instructor.setPassword(request.getPassword());
        instructor.setCompanyName(request.getCompanyName());

        Instructor savedInstructor = instructorRepository.save(instructor);

        return mapToInstructorResponse(savedInstructor);
    }

    @Override
    public InstructorResponse update(Long id, InstructorRequest request) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not found with id: " + id));

        instructor.setName(request.getName());
        instructor.setFirstname(request.getFirstname());
        instructor.setLastname(request.getLastname());
        instructor.setDateOfBirth(request.getDateOfBirth());
        instructor.setNationalIdentity(request.getNationalIdentity());
        instructor.setEmail(request.getEmail());
        instructor.setPassword(request.getPassword());
        instructor.setCompanyName(request.getCompanyName());

        Instructor updatedInstructor = instructorRepository.save(instructor);

        return mapToInstructorResponse(updatedInstructor);
    }

    @Override
    public void delete(Long id) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not found with id: " + id));

        instructorRepository.delete(instructor);
    }

    @Override
    public InstructorResponse getById(Long id) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not found with id: " + id));

        return mapToInstructorResponse(instructor);
    }

    @Override
    public List<InstructorResponse> getAll() {
        List<Instructor> instructors = instructorRepository.findAll();

        return instructors.stream()
                .map(this::mapToInstructorResponse)
                .collect(Collectors.toList());
    }

    // Utility method to map Instructor entity to InstructorResponse DTO
    private InstructorResponse mapToInstructorResponse(Instructor instructor) {
        return new InstructorResponse(
                instructor.getId(),
                instructor.getName(),
                instructor.getFirstname(),
                instructor.getLastname(),
                instructor.getDateOfBirth(),
                instructor.getNationalIdentity(),
                instructor.getEmail(),
                instructor.getCompanyName()
        );
    }
}
