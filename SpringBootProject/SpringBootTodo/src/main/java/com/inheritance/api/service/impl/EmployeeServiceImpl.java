package com.inheritance.api.service.impl;

import com.inheritance.api.dto.request.EmployeeRequest;
import com.inheritance.api.dto.response.EmployeeResponse;
import com.inheritance.api.entity.Employee;
import com.inheritance.api.exception.ResourceNotFoundException;
import com.inheritance.api.repository.EmployeeRepository;
import com.inheritance.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeResponse add(EmployeeRequest request) {
        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setFirstname(request.getFirstname());
        employee.setLastname(request.getLastname());
        employee.setDateOfBirth(request.getDateOfBirth());
        employee.setNationalIdentity(request.getNationalIdentity());
        employee.setEmail(request.getEmail());
        employee.setPassword(request.getPassword());
        employee.setPosition(request.getPosition());

        Employee savedEmployee = employeeRepository.save(employee);

        return mapToEmployeeResponse(savedEmployee);
    }

    @Override
    public EmployeeResponse update(Long id, EmployeeRequest request) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        employee.setName(request.getName());
        employee.setFirstname(request.getFirstname());
        employee.setLastname(request.getLastname());
        employee.setDateOfBirth(request.getDateOfBirth());
        employee.setNationalIdentity(request.getNationalIdentity());
        employee.setEmail(request.getEmail());
        employee.setPassword(request.getPassword());
        employee.setPosition(request.getPosition());

        Employee updatedEmployee = employeeRepository.save(employee);

        return mapToEmployeeResponse(updatedEmployee);
    }

    @Override
    public void delete(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        employeeRepository.delete(employee);
    }

    @Override
    public EmployeeResponse getById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        return mapToEmployeeResponse(employee);
    }

    @Override
    public List<EmployeeResponse> getAll() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream()
                .map(this::mapToEmployeeResponse)
                .collect(Collectors.toList());
    }

    // Utility method to map Employee entity to EmployeeResponse DTO
    private EmployeeResponse mapToEmployeeResponse(Employee employee) {
        return new EmployeeResponse(
                employee.getId(),
                employee.getName(),
                employee.getFirstname(),
                employee.getLastname(),
                employee.getDateOfBirth(),
                employee.getNationalIdentity(),
                employee.getEmail(),
                employee.getPosition()
        );
    }
}
