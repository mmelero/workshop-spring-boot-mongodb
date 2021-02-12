package com.mmelero.wokshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.mmelero.wokshopmongo.domain.Post;

@Repository
public interface PostRepository  extends MongoRepository<Post, String>{
	
	//o ?0 indica que é para pegar o primeiro parametro da opção @QUERY, no
	//caso na lista seria a variavel "text".
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);

	List<Post> findByTitleContainingIgnoreCase(String text);
}
