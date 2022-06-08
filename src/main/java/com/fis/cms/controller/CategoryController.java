package com.fis.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fis.cms.dto.CategoryDTO;
import com.fis.cms.service.CategoryService;

@CrossOrigin
@RestController
public class CategoryController {
	
	@Autowired 
	CategoryService categoryService;
	
	@RequestMapping(value = "/category/getAll", method = RequestMethod.GET)
	public List<CategoryDTO> getAll() {
		return categoryService.getAll();
	}
	
	@GetMapping("/category/getById/{id}")
	public CategoryDTO findById(@PathVariable int id) {
		return categoryService.findById(id);
	}
	
	@GetMapping("/category/findBytName/{name}")
	public List<CategoryDTO> findByName(@PathVariable String name) {
		return categoryService.findByName(name);		
	}
	
	@PostMapping("/category/save")
	public CategoryDTO saveCategory(@RequestBody CategoryDTO categoryDTO) {
		return categoryService.insertCategory(categoryDTO);
	}
	
	@PutMapping("/category/update")
	public CategoryDTO updateCategory(@RequestBody CategoryDTO categoryDTO) {
		return categoryService.update(categoryDTO);
	}
	
	@DeleteMapping("/category/delete/{id}")
	public String deleteCategoryByID(@PathVariable int id) {
		return categoryService.deleteCategoryById(id);
	}

}
