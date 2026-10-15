package com.soa.ms.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequest {
	
	private Long id;
	@NotBlank(message = "Name is required")
	 private String name;
	@NotBlank(message = "email is required")
	 private String email;
	@NotBlank(message = "contact is required")
	 private String contact;
}
