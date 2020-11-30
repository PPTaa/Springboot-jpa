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
@Entity //���̺�� ����� Ŭ�������� ���
public class AccountVO {

	@Id // �ش� �÷��� ���̺��� PK���� ���
	@GeneratedValue(strategy = GenerationType.IDENTITY) // PK ������Ģ���� Identity�� �������־�� auto_increment�� �ȴ�.
	private Long idx;
	
	@Column(length = 500, nullable = false) // ���̺��� �÷��� ��Ÿ����, �������� �ʾƵ� �� Ŭ������ �ʵ�� ��� �÷��� �ȴ�. �ʿ��� �ɼ��� ������ ���
	private String id;
	
	@Column(columnDefinition = "", nullable = false)
	private String password;
	
	private String email;
	
	@Builder // �� Ŭ������ �������� Ŭ������ ����, constructor ��ܿ� �����ϸ� constructor�� ���Ե� �ʵ常 ������ ���Ե�
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
