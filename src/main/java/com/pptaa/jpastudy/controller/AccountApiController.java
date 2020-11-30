package com.pptaa.jpastudy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pptaa.jpastudy.domain.AccountResponseDto;
import com.pptaa.jpastudy.domain.AccountSaveRequestDto;
import com.pptaa.jpastudy.domain.AccountUpdateRequestDto;
import com.pptaa.jpastudy.service.AccountService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class AccountApiController {
	
	private final AccountService accountService;
	
	@PostMapping("/api/v1/account")
	public Long save(@RequestBody AccountSaveRequestDto requestDto) {
		return accountService.save(requestDto);
	}
	
	@PutMapping("/api/v1/account/{idx}")
	public Long update(@PathVariable Long idx, @RequestBody AccountUpdateRequestDto requestDto) {
		return accountService.update(idx, requestDto);
	}
	
	@GetMapping("/api/v1/account/{idx}")
	public AccountResponseDto findById (@PathVariable Long idx) {
		
		return accountService.findById(idx);
	}

}
