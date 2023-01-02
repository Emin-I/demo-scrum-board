package com.example.restservice.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.example.restservice.models.UserModel;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends PagingAndSortingRepository<UserModel, Long> {

	UserModel findByUsername(String username);

}