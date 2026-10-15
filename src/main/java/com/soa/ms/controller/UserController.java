package com.soa.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soa.ms.dto.UserRequest;
import com.soa.ms.dto.UserResponse;
import com.soa.ms.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
   @Autowired
	  private UserService service;
   @PostMapping("/add")
	public ResponseEntity<UserResponse> add(@RequestBody UserRequest request) {
		return ResponseEntity.ok(service.adduser(request));
	}
   @PutMapping("/update/{id}")
	public ResponseEntity<UserResponse> update(@RequestBody UserRequest request,@PathVariable long id) {
		return ResponseEntity.ok(service.updateUser(request, id));
	}
   
  @DeleteMapping("/delete/{id}")
   public ResponseEntity<UserResponse> delete(@PathVariable long id) {
	   return  ResponseEntity.ok(service.deleteUser(id));
   }
  @GetMapping("/getall")
  public ResponseEntity<List<UserResponse>> displayall() {
	  return ResponseEntity.ok(service.displayall());
  }
  @GetMapping("/displaybyid")
  public ResponseEntity<List<UserResponse>> displaybyid(@PathVariable long id) {
	  return ResponseEntity.ok(service.displaybyid(id));
  }
	
}
