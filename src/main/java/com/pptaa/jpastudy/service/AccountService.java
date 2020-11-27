package com.pptaa.jpastudy.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pptaa.jpastudy.domain.AccountRepository;
import com.pptaa.jpastudy.domain.AccountSaveRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AccountService {
	
	private final AccountRepository accountRepository;
	
	@Transactional
	public Long save(AccountSaveRequestDto requestDto) {
		return accountRepository.save(requestDto.toEntity()).getIdx();
	}
}
