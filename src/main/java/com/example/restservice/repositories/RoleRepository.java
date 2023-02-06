
package com.example.restservice.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.example.restservice.models.RoleModel;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface RoleRepository extends PagingAndSortingRepository<RoleModel, Long> {

	RoleModel findByName(String name);

	@Override
	void delete(RoleModel role);
}