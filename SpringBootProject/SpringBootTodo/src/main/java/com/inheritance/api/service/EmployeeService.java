package com.inheritance.api.service;

import com.inheritance.api.dto.request.EmployeeRequest;
import com.inheritance.api.dto.response.EmployeeResponse;
import java.util.List;

public interface EmployeeService {
    EmployeeResponse add(EmployeeRequest request);
    EmployeeResponse update(Long id, EmployeeRequest request);
    void delete(Long id);
    EmployeeResponse getById(Long id);
    List<EmployeeResponse> getAll();
}
