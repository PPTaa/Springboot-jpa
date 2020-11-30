package com.pptaa.jpastudy.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pptaa.jpastudy.domain.AccountRepository;
import com.pptaa.jpastudy.domain.AccountResponseDto;
import com.pptaa.jpastudy.domain.AccountSaveRequestDto;
import com.pptaa.jpastudy.domain.AccountUpdateRequestDto;
import com.pptaa.jpastudy.domain.AccountVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AccountService {
	
	private final AccountRepository accountRepository;
	
	@Transactional
	public Long save(AccountSaveRequestDto requestDto) {
		return accountRepository.save(requestDto.toEntity()).getIdx();
	}
	
	@Transactional
	public Long update(Long idx, AccountUpdateRequestDto requestDto) {
		AccountVO accountVO = accountRepository.findById(idx)
				.orElseThrow(() -> new IllegalArgumentException("해당 아이디가 없습니다. idx ="+idx));
		accountVO.update(requestDto.getId(), requestDto.getPassword());
		return idx;
	}
	
	public AccountResponseDto findById(Long idx) {
		AccountVO entity = accountRepository.findById(idx)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. idx ="+idx));
				
		return new AccountResponseDto(entity);
	}

}
