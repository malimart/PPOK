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

import com.fis.cms.dto.ArticleDTO;
import com.fis.cms.service.ArticleService;

@RestController
@CrossOrigin
public class ArticleController {
	@Autowired
	ArticleService articleService;
	
	@RequestMapping(value = "/article/getAll", method = RequestMethod.GET)
	public List<ArticleDTO> getAll() {
		return articleService.getAll();
	}
	
	@GetMapping("/article/getById/{id}")
	public ArticleDTO findById(@PathVariable int id) {
		return articleService.findById(id);
	}
	
	@GetMapping("/article/getByCategoryId/{id}")
	public List<ArticleDTO> getAllArticlesForCategory(@PathVariable int id) {
		return articleService.getAllArticlesForCategory(id);
	}
	
	@GetMapping("/article/getByAuthorId/{id}")
	public List<ArticleDTO> getAllArticlesForAuthor(@PathVariable int id) {
		return articleService.getAllArticlesForAuthor(id);
	}
	
	@PostMapping("/article/save")
	public ArticleDTO saveArticle(@RequestBody ArticleDTO articleDTO) {
		return articleService.insertArticle(articleDTO);
	}
	
	@PutMapping("/article/update")
	public ArticleDTO updateArticle(@RequestBody ArticleDTO articleDTO) {
		return articleService.updateArticle(articleDTO);
	}
	
	@DeleteMapping("/article/delete/{id}")
	public String deleteArticle(@PathVariable int id) {
		return articleService.deleteArticleById(id);
	}
	
	

}
