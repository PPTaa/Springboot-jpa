package com.pptaa.jpastudy.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.log4j.Log4j2;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Log4j2
public class AccountRepositoryTest {

	@Autowired
	AccountRepository accountRepository;
	
	@AfterEach
	public void cleanup() {
		accountRepository.deleteAll();
	}
	
	@Test
	public void account_save() {
		//given
		String id = "testID";
		String password = "testPASSWORD";
		
		accountRepository.save(AccountVO.builder()
				.id(id)
				.password(password)
				.email("testEMAIL")
				.build());
		
		//when
		List<AccountVO> accountVOList = accountRepository.findAll();
		
		//then
		AccountVO accountVO = accountVOList.get(0);
		assertThat(accountVO.getId()).isEqualTo(id);
		assertThat(accountVO.getPassword()).isEqualTo(password);
		
	}
}
