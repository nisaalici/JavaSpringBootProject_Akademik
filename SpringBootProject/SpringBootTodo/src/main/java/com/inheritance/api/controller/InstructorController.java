package com.inheritance.api.controller;

import com.inheritance.api.dto.request.InstructorRequest;
import com.inheritance.api.dto.response.InstructorResponse;
import com.inheritance.api.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping
    public ResponseEntity<InstructorResponse> createInstructor(@RequestBody InstructorRequest instructorRequest) {
        InstructorResponse createdInstructor = instructorService.add(instructorRequest);
        return new ResponseEntity<>(createdInstructor, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstructorResponse> getInstructorById(@PathVariable Long id) {
        InstructorResponse instructor = instructorService.getById(id);
        return ResponseEntity.ok(instructor);
    }

    @GetMapping
    public ResponseEntity<List<InstructorResponse>> getAllInstructors() {
        List<InstructorResponse> instructors = instructorService.getAll();
        return ResponseEntity.ok(instructors);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstructorResponse> updateInstructor(@PathVariable Long id, 
                                                             @RequestBody InstructorRequest instructorRequest) {
        InstructorResponse updatedInstructor = instructorService.update(id, instructorRequest);
        return ResponseEntity.ok(updatedInstructor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable Long id) {
        instructorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
