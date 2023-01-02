package com.example.restservice.repositories;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.example.restservice.models.CommentModel;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface CommentRepository extends PagingAndSortingRepository<CommentModel, Long> {
	@Query(value = "SELECT * FROM comment_model c WHERE c.item_model_id = ?1", nativeQuery = true)
	Page<CommentModel> findByItemId(int itemId, PageRequest pr);

	@Query(value = "SELECT * FROM comment_model c WHERE c.comment_parent_id = ?1", nativeQuery = true)
	List<CommentModel> findAllByParentId(Long commentId);
}
