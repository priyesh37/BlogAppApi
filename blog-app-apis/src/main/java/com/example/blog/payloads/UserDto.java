package com.example.blog.payloads;

import javax.validation.constraints.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	
		private int id;
		
		@NotEmpty
		@Size(min = 4 , message="userName must be atleast 4 characters")
		private String name;
		
		@Email(message="please enter valis email address")
		private String email;
		
		@NotEmpty
		@Size(min = 3 , max = 10 ,message = "password must be between 3 to 10 characters")
		private String password; 
		
		@NotEmpty
		private String about;
		

}
