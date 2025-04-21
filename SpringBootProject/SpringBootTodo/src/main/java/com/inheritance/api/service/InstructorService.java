package com.inheritance.api.service;

import com.inheritance.api.dto.request.InstructorRequest;
import com.inheritance.api.dto.response.InstructorResponse;
import java.util.List;

public interface InstructorService {
    InstructorResponse add(InstructorRequest request);
    InstructorResponse update(Long id, InstructorRequest request);
    void delete(Long id);
    InstructorResponse getById(Long id);
    List<InstructorResponse> getAll();
}
