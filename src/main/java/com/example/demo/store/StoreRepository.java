package com.example.demo.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

// 매
public interface StoreRepository
    extends JpaRepository<Store, Long> {
//   select * from tbl where name like "%?%"
    List<Store> findByNameContainingOrderByIdDesc(String name);
//  JPQL jakarta persistence Query language
//    SELECT * FROM classname
    @Query("SELECT s FROM Store s WHERE s.name LIKE %?1%")
    List<Store> findByNameContain(String name);

//  @Modifying
//  1. 이름으로 삭제
//  엔드포인트 설계

//   2. 아이디 가 5 이상의 것들 출력
//  엔드포인트 설계

//   3. 매 라고 입력했을때 name 이나 address 둘중 하나라도 들어가있는 것 출력
//  엔드포인트 설계

}
