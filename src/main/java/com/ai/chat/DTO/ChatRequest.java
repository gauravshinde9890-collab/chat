package com.ai.chat.DTO;


public class ChatRequest {
	
	private String message;
	
	public ChatRequest() {
		
	}
	
	public ChatRequest(String m) {
		this.message = m;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}