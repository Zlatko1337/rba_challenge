package hr.rba.rba_challenge.repository;

import java.time.Instant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hr.rba.rba_challenge.exception.ResourceNotFoundException;
import hr.rba.rba_challenge.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, String> {

	UserModel findByOib(String oib) throws ResourceNotFoundException;
	
	@Transactional @Modifying
	@Query("UPDATE UserModel u SET u.deleted = true, u.lastModifiedDate = ?2 WHERE u.oib=?1")
	Integer deleteUserByOib(String oib, Instant lastModified);
	
}
