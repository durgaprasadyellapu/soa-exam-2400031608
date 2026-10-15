package com.soa.ms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.soa.ms.dto.UserRequest;
import com.soa.ms.dto.UserResponse;

@Service
public interface UserService {

	UserResponse adduser(UserRequest request);
	UserResponse updateUser(UserRequest request,long id);
	UserResponse deleteUser(long id);
	List<UserResponse> displayall();
	List<UserResponse> displaybyid(long id);
}
