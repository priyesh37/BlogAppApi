package com.example.blog.controllers;

import java.util.List;

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
import com.example.blog.payloads.CategoryDto;
import com.example.blog.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
		@Autowired
		private CategoryService categoryService;
	
		//create
		@PostMapping("/")
		public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
			
			CategoryDto createCategory = this.categoryService.createCategory(categoryDto);
			
			return new ResponseEntity<CategoryDto>(createCategory,HttpStatus.CREATED);
			
		}
		
		//update
		@PutMapping("/{categoryId}")
		public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer categoryId){
			
			CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto,categoryId);
			
			return new ResponseEntity<CategoryDto>(updatedCategory,HttpStatus.OK);
			
		}
		
		//delete
		@DeleteMapping("/{categoryId}")
		public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId){
			
			this.categoryService.deleteCategory(categoryId);
			
			return new ResponseEntity<ApiResponse>(new ApiResponse("Category is deleted succesfully",true),HttpStatus.OK);
			
		}
		
		//get cat by id
		@GetMapping("/{categoryId}")
		public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer categoryId){
			
			CategoryDto cat = this.categoryService.getCategory(categoryId);
			
			return new ResponseEntity<CategoryDto>(cat,HttpStatus.OK);
			
		}
		
		//get all cat
		@GetMapping("/")
		public ResponseEntity<List<CategoryDto>> getCategories(){
			
			List<CategoryDto> categories = this.categoryService.getCategories();
			
			return new ResponseEntity<List<CategoryDto>>(categories,HttpStatus.OK);
			
		}
			
		

}
