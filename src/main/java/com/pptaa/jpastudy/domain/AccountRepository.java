package com.pptaa.jpastudy.domain;

import org.springframework.data.jpa.repository.JpaRepository;

// sql mapper������ Dao �� �Ҹ��� DB Layer������ 
// JpaRepository<Entity Ŭ����, PK Ÿ��>
public interface AccountRepository extends JpaRepository<AccountVO, Long> {

}
