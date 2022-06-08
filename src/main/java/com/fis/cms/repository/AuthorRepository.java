package com.fis.cms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fis.cms.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{
	List<Author> findByFirstNameOrLastName(String firstName, String lastName);

}
