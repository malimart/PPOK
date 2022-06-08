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

import com.fis.cms.dto.AuthorDTO;
import com.fis.cms.service.AuthorService;

@RestController
@CrossOrigin
public class AuthorController {
	
	@Autowired 
	AuthorService authorService;
	
	@RequestMapping(value = "/author/getAll", method = RequestMethod.GET)
	public List<AuthorDTO> getAll() {
		return authorService.getAll();
	}
	
	@GetMapping("/author/getById/{id}")
	public AuthorDTO findById(@PathVariable int id) {
		return authorService.findById(id);
	}
	
	@GetMapping("/author/findByFirstNameOrLastName/{firstName}/{lastName}")
	public List<AuthorDTO> findByFirstNameOrLastName(@PathVariable ("firstName") String firstName, @PathVariable ("lastName") String lastName) {
		return authorService.findByFirstNameOrLastName(firstName, lastName);		
	}
	
	@PostMapping("/author/save")
	public AuthorDTO saveAuthor(@RequestBody AuthorDTO authorDTO) {
		return authorService.insertAuthor(authorDTO);
	}
	
	@PutMapping("/author/update")
	public AuthorDTO updateAuthor(@RequestBody AuthorDTO authorDTO) {
		return authorService.update(authorDTO);
	}
	
	@DeleteMapping("/author/delete/{id}")
	public String deleteAuthorByID(@PathVariable int id) {
		return authorService.deleteAuthorById(id);
	}
	
}




