package com.fis.cms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fis.cms.dto.CategoryDTO;
import com.fis.cms.model.Category;
import com.fis.cms.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	
	public List<CategoryDTO> getAll() {
		List<Category> categorys = categoryRepository.findAll(Sort.by(Sort.Direction.ASC, "categoryId"));
		List<CategoryDTO> categoryDTOs = new ArrayList<CategoryDTO>();
		
		for(Category category : categorys) {
			CategoryDTO newCategoryDTO = new CategoryDTO();
			newCategoryDTO.setCategoryId(category.getCategoryId());
			newCategoryDTO.setName(category.getName());
			categoryDTOs.add(newCategoryDTO);
		}
		return categoryDTOs;
	}
	
	public CategoryDTO findById(int id) {
		Category category = categoryRepository.findById(id).get();
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setCategoryId(category.getCategoryId());
		categoryDTO.setName(category.getName());
		return categoryDTO;
	}
	
	public List<CategoryDTO> findByName(String name) {
		List<Category> categorys = categoryRepository.findByName(name);
		List<CategoryDTO> categoryDTOs = new ArrayList<CategoryDTO>();
		for(Category category : categorys) {
			CategoryDTO categoryDTO = new CategoryDTO();
			categoryDTO.setCategoryId(category.getCategoryId());
			categoryDTO.setName(category.getName());
			categoryDTOs.add(categoryDTO);
		}
		return categoryDTOs;	
	}
	
	public CategoryDTO insertCategory(CategoryDTO CategoryDTO) {
		Category category = new Category();
		category.setName(CategoryDTO.getName());
		
		Category returnCategory = categoryRepository.save(category);
		
		CategoryDTO returnCategoryDTO = new CategoryDTO();
		returnCategoryDTO.setName(returnCategory.getName());
		returnCategoryDTO.setCategoryId(returnCategory.getCategoryId());
		
		return returnCategoryDTO;
	}
	
	public CategoryDTO update(CategoryDTO CategoryDTO) {	
		Category category = new Category();
		category.setName(CategoryDTO.getName());
		category.setCategoryId(CategoryDTO.getCategoryId());
					
		Category returnCategory = categoryRepository.save(category);
		
		CategoryDTO returnCategoryDTO = new CategoryDTO();
		returnCategoryDTO.setName(returnCategory.getName());
		returnCategoryDTO.setCategoryId(returnCategory.getCategoryId());
				
		return returnCategoryDTO;
	}
	
	public String deleteCategoryById(int id) {
		try {
			categoryRepository.deleteById(Integer.valueOf(id));
			return "category with id " + id + " has been deleted.";
		} catch (Exception e) {
			e.printStackTrace();
			return "No category with id " + id + " has been found";
		}		
	}

}
