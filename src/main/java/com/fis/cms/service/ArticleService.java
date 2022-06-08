package com.fis.cms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fis.cms.dto.ArticleDTO;
import com.fis.cms.model.Article;
import com.fis.cms.repository.ArticleRepository;

@Service
public class ArticleService {
	@Autowired
	ArticleRepository articleRepository;
	
	public List<ArticleDTO> getAll() {
		List<Article> articles = articleRepository.findAll(Sort.by(Sort.Direction.DESC, "articleId"));
		List<ArticleDTO> returnArticleDTOs = new ArrayList<ArticleDTO>();
		
		for(Article article : articles) {
			ArticleDTO articleDTO = new ArticleDTO();
			articleDTO.setArticleId(article.getArticleId());
			articleDTO.setTitle(article.getTitle());
			articleDTO.setExcerpt(article.getExcerpt());
			articleDTO.setContent(article.getContent());
			articleDTO.setCategory(article.getCategory());
			articleDTO.setAuthor(article.getAuthor());
			articleDTO.setDate(article.getDate());
			returnArticleDTOs.add(articleDTO);
		}
		return returnArticleDTOs;
	}
	
	public ArticleDTO findById(int id) {
		Article article = articleRepository.findById(id).get();
		ArticleDTO articleDTO = new ArticleDTO();
		articleDTO.setArticleId(article.getArticleId());
		articleDTO.setTitle(article.getTitle());
		articleDTO.setExcerpt(article.getExcerpt());
		articleDTO.setContent(article.getContent());
		articleDTO.setCategory(article.getCategory());
		articleDTO.setAuthor(article.getAuthor());
		articleDTO.setDate(article.getDate());
		return articleDTO;		
	}
	
	// dodaj ostale metode za iskanje

	public List<ArticleDTO> getAllArticlesForCategory(int categoryId) {
		List<ArticleDTO> returnArticleDTOs = new ArrayList<ArticleDTO>();
		List<Article> articles = articleRepository.findByCategory_categoryId(categoryId);
		for(Article article : articles) {
			ArticleDTO articleDTO = new ArticleDTO();
			articleDTO.setArticleId(article.getArticleId());
			articleDTO.setTitle(article.getTitle());
			articleDTO.setExcerpt(article.getExcerpt());
			articleDTO.setContent(article.getContent());
			articleDTO.setCategory(article.getCategory());
			articleDTO.setAuthor(article.getAuthor());
			articleDTO.setDate(article.getDate());
			returnArticleDTOs.add(articleDTO);
		}
		return returnArticleDTOs;
	}
	
	public List<ArticleDTO> getAllArticlesForAuthor(int authorId) {
		List<ArticleDTO> returnArticleDTOs = new ArrayList<ArticleDTO>();
		List<Article> articles = articleRepository.findByAuthor_authorId(authorId);
		for(Article article : articles) {
			ArticleDTO articleDTO = new ArticleDTO();
			articleDTO.setArticleId(article.getArticleId());
			articleDTO.setTitle(article.getTitle());
			articleDTO.setExcerpt(article.getExcerpt());
			articleDTO.setContent(article.getContent());
			articleDTO.setCategory(article.getCategory());
			articleDTO.setAuthor(article.getAuthor());
			articleDTO.setDate(article.getDate());
			returnArticleDTOs.add(articleDTO);
		}
		return returnArticleDTOs;
	}
	
	public ArticleDTO insertArticle(ArticleDTO articleDTO) {
		Article article = new Article();
		article.setTitle(articleDTO.getTitle());
		article.setExcerpt(articleDTO.getExcerpt());
		article.setContent(articleDTO.getContent());
		article.setCategory(articleDTO.getCategory());
		article.setAuthor(articleDTO.getAuthor());
		article.setDate(articleDTO.getDate());
		
		Article returnArticle = articleRepository.save(article);
		ArticleDTO returnArticleDTO = new ArticleDTO();
		
		returnArticleDTO.setArticleId(returnArticle.getArticleId());
		returnArticleDTO.setTitle(returnArticle.getTitle());
		returnArticleDTO.setExcerpt(returnArticle.getExcerpt());
		returnArticleDTO.setContent(returnArticle.getContent());
		returnArticleDTO.setCategory(returnArticle.getCategory());
		returnArticleDTO.setAuthor(returnArticle.getAuthor());
		returnArticleDTO.setDate(returnArticle.getDate());
		
		return returnArticleDTO;		
	}
	
	public ArticleDTO updateArticle(ArticleDTO articleDTO) {
		Article article = new Article();
		article.setArticleId(articleDTO.getArticleId());
		article.setTitle(articleDTO.getTitle());
		article.setExcerpt(articleDTO.getExcerpt());
		article.setContent(articleDTO.getContent());
		article.setCategory(articleDTO.getCategory());
		article.setAuthor(articleDTO.getAuthor());
		article.setDate(articleDTO.getDate());
		
		Article returnArticle = articleRepository.save(article);
		ArticleDTO returnArticleDTO = new ArticleDTO();
		
		returnArticleDTO.setArticleId(returnArticle.getArticleId());
		returnArticleDTO.setTitle(returnArticle.getTitle());
		returnArticleDTO.setExcerpt(returnArticle.getExcerpt());
		returnArticleDTO.setContent(returnArticle.getContent());
		returnArticleDTO.setCategory(returnArticle.getCategory());
		returnArticleDTO.setAuthor(returnArticle.getAuthor());
		returnArticleDTO.setDate(returnArticle.getDate());
		
		return returnArticleDTO;		
	}
	
	public String deleteArticleById(int id) {
		try {
			articleRepository.deleteById(Integer.valueOf(id));
			return "Article with id " + id + " has been deleted.";
		} catch (Exception e) {
			e.printStackTrace();
			return "No Article with id " + id + " has been found";
		}
	}
	
}
