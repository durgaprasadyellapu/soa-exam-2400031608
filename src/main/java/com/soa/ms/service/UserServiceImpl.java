package com.soa.ms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soa.ms.dto.UserRequest;
import com.soa.ms.dto.UserResponse;
import com.soa.ms.entity.User;
import com.soa.ms.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
  @Autowired
	private UserRepository repo;
	
	@Override
	public UserResponse adduser(UserRequest request) {
		User user=User.builder()
				  .name(request.getName())
				  .email(request.getEmail())
				  .contact(request.getContact())
				  .build();
		return mapToresponse(repo.save(user));
	}

	@Override
	public UserResponse updateUser(UserRequest request, long id) {
		Optional<User>optional=repo.findById(id);
		if(optional.isPresent()) {			
			User user=User.builder()
					  .name(request.getName())
					  .email(request.getEmail())
					  .contact(request.getContact())
					  .build();
			return mapToresponse(repo.save(user));
		}
		return null;
	}

	@Override
	public UserResponse deleteUser(long id) {
	    boolean flag=repo.existsById(id);
	    if(flag) {
	    	repo.deleteById(id);
	    }
	    return null;
	}

	@Override
	public List<UserResponse> displayall() {
		return repo.findAll().stream().map(this::mapToresponse).toList();
	}

	@Override
	public List<UserResponse> displaybyid(long id) {
		return repo.findById(id).stream().map(this::mapToresponse).toList();
	}
	public UserResponse mapToresponse(User user) {
		return UserResponse.builder()
				.id(user.getId())
				.name(user.getName())
				.contact(user.getContact())
				.email(user.getEmail())
				.build();
	}
	

}
