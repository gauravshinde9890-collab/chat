package com.ai.chat.controllers;


import java.util.List;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ai.chat.DTO.ChatRequest;
import com.ai.chat.DTO.ChatResponse;
import com.ai.chat.model.appuser;
import com.ai.chat.model.chatmessage;
import com.ai.chat.repository.ChatRepository;
import com.ai.chat.repository.userrepository;
import com.ai.chat.services.SarvamAiService;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
	
	@Autowired
	private ChatRepository chatrepo;
	@Autowired
	private userrepository user_repo;
	@Autowired
	private SarvamAiService sarvamAiService;
	
	@PostMapping("/response")
	public ChatResponse chat(@RequestBody ChatRequest request, Principal principal) {
		appuser user = user_repo.findByUsername(principal.getName()).orElseThrow();
		
		List<chatmessage> history = chatrepo.findByUserOrderByCreatedAtAsc(user);
		chatmessage userMsg = new chatmessage();
		userMsg.setRole("user");
		userMsg.setContent(request.getMessage());
		userMsg.setUser(user);
		chatrepo.save(userMsg);
		
		String ai_reply = sarvamAiService.askSarvam(history,  request.getMessage());
		chatmessage aiMsg = new chatmessage();
		aiMsg.setRole("assistant");
		aiMsg.setContent(ai_reply);
		aiMsg.setUser(user);
		chatrepo.save(aiMsg);
		
		return new ChatResponse(ai_reply);
		
	}
	
	@GetMapping("/history")
	public List<chatmessage> history(Principal principal){
		appuser user = user_repo.findByUsername(principal.getName()).orElseThrow();
		return chatrepo.findByUserOrderByCreatedAtAsc(user);
	}
	
}