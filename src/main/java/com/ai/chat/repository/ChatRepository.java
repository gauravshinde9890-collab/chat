package com.ai.chat.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ai.chat.model.appuser;
import com.ai.chat.model.chatmessage;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<chatmessage, Long> {
	List<chatmessage> findByUserOrderByCreatedAtAsc(appuser user);
	

}


