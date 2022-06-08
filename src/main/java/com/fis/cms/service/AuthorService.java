package com.fis.cms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fis.cms.dto.AuthorDTO;
import com.fis.cms.model.Author;
import com.fis.cms.repository.AuthorRepository;

@Service
public class AuthorService {
	@Autowired
	AuthorRepository authorRepository;
	
	public List<AuthorDTO> getAll() {
		List<Author> authors = authorRepository.findAll(Sort.by(Sort.Direction.ASC, "authorId"));
		List<AuthorDTO> authorDTOs = new ArrayList<AuthorDTO>();
		
		for(Author author : authors) {
			AuthorDTO newAuthorDTO = new AuthorDTO();
			newAuthorDTO.setAuthorId(author.getAuthorId());
			newAuthorDTO.setFirstName(author.getFirstName());
			newAuthorDTO.setLastName(author.getLastName());
			authorDTOs.add(newAuthorDTO);
		}
		return authorDTOs;
	}
	
	public AuthorDTO findById(int id) {
		Author author = authorRepository.findById(id).get();
		AuthorDTO authorDTO = new AuthorDTO();
		authorDTO.setAuthorId(author.getAuthorId());
		authorDTO.setFirstName(author.getFirstName());
		authorDTO.setLastName(author.getLastName());
		return authorDTO;
	}
	
	public List<AuthorDTO> findByFirstNameOrLastName(String firstName, String lastName) {
		List<Author> authors = authorRepository.findByFirstNameOrLastName(firstName, lastName);
		List<AuthorDTO> authorDTOs = new ArrayList<AuthorDTO>();
		for(Author author : authors) {
			AuthorDTO authorDTO = new AuthorDTO();
			authorDTO.setAuthorId(author.getAuthorId());
			authorDTO.setFirstName(author.getFirstName());
			authorDTO.setLastName(author.getLastName());
			authorDTOs.add(authorDTO);
		}
		return authorDTOs;	
	}
	
	public AuthorDTO insertAuthor(AuthorDTO authorDTO) {
		Author author = new Author();
		author.setFirstName(authorDTO.getFirstName());
		author.setLastName(authorDTO.getLastName());
		
		Author returnAuthor = authorRepository.save(author);
		
		AuthorDTO returnAuthorDTO = new AuthorDTO();
		returnAuthorDTO.setFirstName(returnAuthor.getFirstName());
		returnAuthorDTO.setLastName(returnAuthor.getLastName());
		returnAuthorDTO.setAuthorId(returnAuthor.getAuthorId());
		
		return returnAuthorDTO;
	}
	
	public AuthorDTO update(AuthorDTO authorDTO) {	
		Author author = new Author();
		author.setFirstName(authorDTO.getFirstName());
		author.setLastName(authorDTO.getLastName());
		author.setAuthorId(authorDTO.getAuthorId());
					
		Author returnAuthor = authorRepository.save(author);
		
		AuthorDTO returnAuthorDTO = new AuthorDTO();
		returnAuthorDTO.setFirstName(returnAuthor.getFirstName());
		returnAuthorDTO.setLastName(returnAuthor.getLastName());
		returnAuthorDTO.setAuthorId(returnAuthor.getAuthorId());
				
		return returnAuthorDTO;
	}
	
	public String deleteAuthorById(int id) {
		try {
			authorRepository.deleteById(Integer.valueOf(id));
			return "Author with id " + id + " has been deleted.";
		} catch (Exception e) {
			e.printStackTrace();
			return "No Author with id " + id + " has been found";
		}		
	}

}
