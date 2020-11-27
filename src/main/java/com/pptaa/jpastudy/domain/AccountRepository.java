package com.pptaa.jpastudy.domain;

import org.springframework.data.jpa.repository.JpaRepository;

// sql mapper에서는 Dao 로 불리는 DB Layer접근자 
// JpaRepository<Entity 클래스, PK 타입>
public interface AccountRepository extends JpaRepository<AccountVO, Long> {

}
