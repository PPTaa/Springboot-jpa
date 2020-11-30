package com.pptaa.jpastudy.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity //테이블과 연결될 클래스임을 명시
public class AccountVO {

	@Id // 해당 컬럼이 테이블의 PK임을 명시
	@GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성규칙으로 Identity를 선언해주어야 auto_increment가 된다.
	private Long idx;
	
	@Column(length = 500, nullable = false) // 테이블의 컬럼을 나타내며, 선언하지 않아도 이 클래스의 필드는 모두 컬럼이 된다. 필요한 옵션이 있으면 사용
	private String id;
	
	@Column(columnDefinition = "", nullable = false)
	private String password;
	
	private String email;
	
	@Builder // 이 클래스의 빌더패턴 클래스를 생성, constructor 상단에 선언하면 constructor에 포함된 필드만 빌더에 들어가게됨
	public AccountVO(String id, String password, String email) {
		this.id = id;
		this.password = password;
		this.email = email;
	}
	
	public void update(String id, String password) {
		this.id = id;
		this.password = password;
	}
}
