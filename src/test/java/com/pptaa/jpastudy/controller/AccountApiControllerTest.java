package com.pptaa.jpastudy.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.pptaa.jpastudy.domain.AccountRepository;
import com.pptaa.jpastudy.domain.AccountSaveRequestDto;
import com.pptaa.jpastudy.domain.AccountUpdateRequestDto;
import com.pptaa.jpastudy.domain.AccountVO;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) //랜덤포트를 사용함
public class AccountApiControllerTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@AfterEach
	public void tearDown() throws Exception {
		accountRepository.deleteAll();
	}
	
	@Test
	public void RegisterAccount() {
		//given
		String id = "id";
		String password = "password";
		AccountSaveRequestDto requestDto = AccountSaveRequestDto.builder()
				.id(id)
				.password(password)
				.email("email")
				.build();
		String url = "http://localhost:"+port+"/api/v1/account";
		
		//when
		ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);
		
		//then
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isGreaterThan(0L);
		
		List<AccountVO> all = accountRepository.findAll();
		assertThat(all.get(0).getId()).isEqualTo(id);
		assertThat(all.get(0).getPassword()).isEqualTo(password);
		
		
	}
	
	@Test
	public void UpdateAccount() throws Exception {
		//given
		AccountVO saveAccount = accountRepository.save(AccountVO.builder()
				.id("id")
				.password("password")
				.email("email")
				.build());
		
		Long updateIdx = saveAccount.getIdx();
		String expectedId = "id2";
		String expectedPassword = "password2";
		AccountUpdateRequestDto requestDto = AccountUpdateRequestDto.builder()
				.id(expectedId)
				.password(expectedPassword)
				.build();
		String url = "http://localhost:"+port+"/api/v1/account/"+updateIdx;
		
		HttpEntity<AccountUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);
		
		//when
		ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);
		
		//then
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isGreaterThan(0L);
		
		List<AccountVO> all = accountRepository.findAll();
		assertThat(all.get(0).getId()).isEqualTo(expectedId);
		assertThat(all.get(0).getPassword()).isEqualTo(expectedPassword);
		
		
	}

}
