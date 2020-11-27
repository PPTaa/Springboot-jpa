package com.pptaa.jpastudy.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AccountSaveRequestDto {

	private String id;
	private String password;
	private String email;
	
	@Builder
	public AccountSaveRequestDto(String id, String password, String email) {
		this.id = id;
		this.password = password;
		this.email = email;
	}
	
	public AccountVO toEntity() {
		return AccountVO.builder()
				.id(id)
				.password(password)
				.email(email)
				.build();
	}
}
