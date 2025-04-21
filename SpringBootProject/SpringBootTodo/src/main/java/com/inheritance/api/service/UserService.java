package com.inheritance.api.service;

import com.inheritance.api.dto.request.UserRequest;
import com.inheritance.api.dto.response.UserResponse;
import java.util.List;

public interface UserService {
    UserResponse add(UserRequest request);
    UserResponse update(Long id, UserRequest request);
    void delete(Long id);
    UserResponse getById(Long id);
    List<UserResponse> getAll();
}
