/*
 package com.example.restservice.repositories;
 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.util.Date;
import java.util.stream.Stream;
import com.example.restservice.models.VerificationTokenModel;
import com.example.restservice.models.UserModel;

public interface VerificationTokenRepository extends JpaRepository<VerificationTokenModel, Long> {

	VerificationTokenModel findByToken(String token);

	VerificationTokenModel findByUser(UserModel user);

	Stream<VerificationTokenModel> findAllByExpiryDateLessThan(Date now);

	void deleteByExpiryDateLessThan(Date now);

	@Modifying
	@Query("delete from VerificationToken t where t.expiryDate <= ?1")
	void deleteAllExpiredSince(Date now);
}
*/