package com.pptaa.jpastudy.domain;

import lombok.Getter;

@Getter
public class AccountResponseDto {

	private Long idx;
	private String id;
	private String password;
	private String email;
	
	public AccountResponseDto(AccountVO entity) {
		this.idx = entity.getIdx();
		this.id = entity.getId();
		this.password = entity.getPassword();
		this.email = entity.getEmail();
	}
}
