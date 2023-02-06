package com.example.restservice.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.example.restservice.models.PrivilegeModel;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface PrivilegeRepository extends PagingAndSortingRepository<PrivilegeModel, String> {
/*
	PrivilegeModel findByName(String name);
	Collection<PrivilegeModel> findAllByNames(ArrayList<String> name);
	*/
	//@Override
	//void delete(PrivilegeModel privilege);

}