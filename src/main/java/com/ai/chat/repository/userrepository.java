package com.ai.chat.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ai.chat.model.appuser;

@Repository
public interface userrepository extends JpaRepository<appuser, Long>{
	Optional<appuser> findByUsername(String username);

}