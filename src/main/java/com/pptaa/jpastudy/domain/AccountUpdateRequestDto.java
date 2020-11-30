package com.pptaa.jpastudy.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AccountUpdateRequestDto {

	private String id;
	private String password;
	
	@Builder
	public AccountUpdateRequestDto(String id, String password) {
		this.id = id;
		this.password = password;
	}
}
