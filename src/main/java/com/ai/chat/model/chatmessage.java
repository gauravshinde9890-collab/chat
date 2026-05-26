package com.ai.chat.model;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class chatmessage {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String role;
	@Column(columnDefinition = "TEXT")
	private String content;
	private LocalDateTime orderCreatedAt = LocalDateTime.now();
	
	@ManyToOne
	private appuser user;
	
	public chatmessage() {}
	
	public chatmessage(Long i, String r, String c, appuser u) {
		this.id = i;
		this.role =r;
		this.content = c;
		this.user = u;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreatedAt() {
		return orderCreatedAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.orderCreatedAt = createdAt;
	}

	public appuser getUser() {
		return user;
	}

	public void setUser(appuser user) {
		this.user = user;
	}
	
	
}  

