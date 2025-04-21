package com.inheritance.api.service;

import com.inheritance.api.dto.request.ApplicantRequest;
import com.inheritance.api.dto.response.ApplicantResponse;
import java.util.List;

public interface ApplicantService {
    ApplicantResponse add(ApplicantRequest request);
    ApplicantResponse update(Long id, ApplicantRequest request);
    void delete(Long id);
    ApplicantResponse getById(Long id);
    List<ApplicantResponse> getAll();
}
