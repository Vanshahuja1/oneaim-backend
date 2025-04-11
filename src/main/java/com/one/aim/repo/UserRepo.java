package com.one.aim.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.one.aim.bo.UserBO;

@Repository
public interface UserRepo extends JpaRepository<UserBO, Long> {

	public Optional<UserBO> findById(Long docId);

	public UserBO findByEmail(String Email);
}
