package com.fis.cms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fis.cms.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer>{
	
	List<Article> findByCategory_categoryId(int categoryId);
	List<Article> findByAuthor_authorId(int authorId);

}
