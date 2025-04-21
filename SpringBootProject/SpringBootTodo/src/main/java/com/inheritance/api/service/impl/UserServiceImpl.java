package com.inheritance.api.service.impl;

import com.inheritance.api.dto.request.UserRequest;
import com.inheritance.api.dto.response.UserResponse;
import com.inheritance.api.entity.User;
import com.inheritance.api.exception.ResourceNotFoundException;
import com.inheritance.api.repository.UserRepository;
import com.inheritance.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepository;
    
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse add(UserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setDateOfBirth(request.getDateOfBirth());
        user.setNationalIdentity(request.getNationalIdentity());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        
        User savedUser = userRepository.save(user);
        
        return mapToUserResponse(savedUser);
    }

    @Override
    public UserResponse update(Long id, UserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        
        user.setName(request.getName());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setDateOfBirth(request.getDateOfBirth());
        user.setNationalIdentity(request.getNationalIdentity());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        
        User updatedUser = userRepository.save(user);
        
        return mapToUserResponse(updatedUser);
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        
        userRepository.delete(user);
    }

    @Override
    public UserResponse getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        
        return mapToUserResponse(user);
    }

    @Override
    public List<UserResponse> getAll() {
        List<User> users = userRepository.findAll();
        
        return users.stream()
                .map(this::mapToUserResponse)
                .collect(Collectors.toList());
    }
    
    // Utility method to map User entity to UserResponse DTO
    protected UserResponse mapToUserResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getFirstname(),
                user.getLastname(),
                user.getDateOfBirth(),
                user.getNationalIdentity(),
                user.getEmail()
        );
    }
}
