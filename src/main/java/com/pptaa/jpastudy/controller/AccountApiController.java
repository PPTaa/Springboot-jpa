package com.pptaa.jpastudy.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pptaa.jpastudy.domain.AccountSaveRequestDto;
import com.pptaa.jpastudy.service.AccountService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class AccountApiController {
	
	private final AccountService accountService;
	
	@PostMapping("/api/v1/posts")
	public Long save(@RequestBody AccountSaveRequestDto requestDto) {
		return accountService.save(requestDto);
	}

}
