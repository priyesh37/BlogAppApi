package com.example.blog.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.payloads.ApiResponse;
import com.example.blog.payloads.UserDto;
import com.example.blog.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

		@Autowired
		private UserService userService;
		
		//POST - create user
		
		@PostMapping("/")
		public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
			
			UserDto createUserDto = this.userService.createUser(userDto);
			
			return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
		}
		
		//PUT -UPDATE user
		
		@PutMapping("/{userId}")
		public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId){
			
			
			UserDto updatedUserDto = this.userService.updateUser(userDto,userId);
			
			return ResponseEntity.ok(updatedUserDto);
		}
		
		// DELETE - delete user
		
		@DeleteMapping("/{userId}")
		public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){
			
			this.userService.deleteUser(userId);
			
			return new ResponseEntity<ApiResponse>(new ApiResponse("User Delted SuccessFully",true),HttpStatus.OK);
					
		}
		 
		
		 // GET - get user
		@GetMapping("/{userId}")
		public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId){
			
			UserDto createUserDto = this.userService.getUserById(userId);
			
			return new ResponseEntity<>(createUserDto,HttpStatus.OK);
					
		}
		
		//GET - get all user
		@GetMapping("/")
		public ResponseEntity<List<UserDto>> getAllUsers(){
			
			return ResponseEntity.ok(this.userService.getAllUsers());
		}
		
		
		
		
		
		
}
