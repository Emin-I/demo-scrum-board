package com.example.restservice.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.example.restservice.models.ColumnModel;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ColumnRepository extends PagingAndSortingRepository<ColumnModel, Long> {

	@Query(value = "SELECT * FROM column_model c WHERE c.team_model_id = ?1", nativeQuery = true)
	List<ColumnModel> findByTeamId(Long teamModelId);

}