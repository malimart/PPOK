package com.fis.cms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fis.cms.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	List<Category> findByName(String name);
}
