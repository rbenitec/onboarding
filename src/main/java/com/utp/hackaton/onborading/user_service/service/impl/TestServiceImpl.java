package com.utp.hackaton.onborading.user_service.service.impl;

import com.utp.hackaton.onborading.user_service.entity.TestEntity;
import com.utp.hackaton.onborading.user_service.repository.TestRepository;
import com.utp.hackaton.onborading.user_service.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {
    private final TestRepository testRepository;
    @Override
    public TestEntity getTest(Integer id) {
        return null;
    }

    @Override
    public TestEntity saveTest(TestEntity testEntity) {
        return testRepository.save(testEntity);
    }

    @Override
    public Optional<TestEntity> getTestByUserId(Integer userId) {
        return testRepository.findTestByUserId(userId);
    }

    @Override
    public List<TestEntity> getAllTest() {
        return testRepository.findAll();
    }

    @Override
    public void deleteTest(Integer id) {
        testRepository.deleteById(id);
    }
}
