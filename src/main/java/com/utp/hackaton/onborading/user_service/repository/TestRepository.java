package com.utp.hackaton.onborading.user_service.repository;

import com.utp.hackaton.onborading.user_service.entity.TestEntity;
import com.utp.hackaton.onborading.user_service.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Integer> {
    @Query(value = "select * from test t where t.user_id = :userId", nativeQuery = true)
    Optional<TestEntity> findTestByUserId(@Param("userId") Integer userId);
}
