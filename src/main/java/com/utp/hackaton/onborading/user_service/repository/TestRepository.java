package com.utp.hackaton.onborading.user_service.repository;

import com.utp.hackaton.onborading.user_service.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Integer> {
}
