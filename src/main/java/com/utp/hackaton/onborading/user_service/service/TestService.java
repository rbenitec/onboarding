package com.utp.hackaton.onborading.user_service.service;

import com.utp.hackaton.onborading.user_service.entity.TestEntity;
import com.utp.hackaton.onborading.user_service.model.ReponseUpdateTestDto;
import com.utp.hackaton.onborading.user_service.model.UpdateTestDto;

import java.util.List;
import java.util.Optional;

public interface TestService {
    TestEntity getTest (Integer id);
    TestEntity saveTest(TestEntity testEntity);
    ReponseUpdateTestDto updateTest(UpdateTestDto updateTestDto);
    Optional<TestEntity> getTestByUserId(Integer userId);
    List<TestEntity> getAllTest();

    void deleteTest(Integer id);
}
