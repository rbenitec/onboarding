package com.utp.hackaton.onborading.user_service.service.impl;

import com.utp.hackaton.onborading.user_service.entity.TestEntity;
import com.utp.hackaton.onborading.user_service.entity.UserEntity;
import com.utp.hackaton.onborading.user_service.model.ReponseUpdateTestDto;
import com.utp.hackaton.onborading.user_service.model.UpdateTestDto;
import com.utp.hackaton.onborading.user_service.repository.TestRepository;
import com.utp.hackaton.onborading.user_service.repository.UserRepository;
import com.utp.hackaton.onborading.user_service.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {
    private final TestRepository testRepository;
    private final UserRepository userRepository;
    @Override
    public TestEntity getTest(Integer id) {
        return null;
    }

    @Override
    public TestEntity saveTest(TestEntity testEntity) {
        return testRepository.save(testEntity);
    }

    @Override
    public ReponseUpdateTestDto updateTest(UpdateTestDto updateTestDto) {
        Optional<UserEntity> user = userRepository.findByUsername(updateTestDto.getUsername());
        if (user.isPresent()){
            Optional<TestEntity> test = testRepository.findTestByUserId(user.get().getId());
            if(test.isPresent()){
                TestEntity testUpdate = updateTestOfUser(test.get(), updateTestDto);
                testRepository.save(testUpdate);
                return buildResponseUpdateTest(testUpdate, user.get());
            }
        }
        return null;
    }

    private ReponseUpdateTestDto buildResponseUpdateTest(TestEntity testUpdate, UserEntity user) {
        return ReponseUpdateTestDto.builder()
                .testA(testUpdate.getTestA())
                .testB(testUpdate.getTestB())
                .testC(testUpdate.getTestC())
                .testD(testUpdate.getTestD())
                .average(testUpdate.getAverage())
                .username(user.getUsername())
                .build();
    }

    private TestEntity updateTestOfUser(TestEntity test, UpdateTestDto updateTestDto) {
        String nombreNota = updateTestDto.getNombreTest().toUpperCase();
        if(nombreNota.contains("TESTA")){
            test.setTestA(updateTestDto.getValorNota());
        } else if (nombreNota.contains("TESTB")) {
            test.setTestB(updateTestDto.getValorNota());
        } else if (nombreNota.contains("TESTC")){
            test.setTestC(updateTestDto.getValorNota());
        } else {
            test.setTestD(updateTestDto.getValorNota());
        }
        if(test.getTestA()>=0 && test.getTestB()>=0 && test.getTestC() >=0 && test.getTestD()>=0){
            double newAvarage = (test.getTestA() + test.getTestB() + test.getTestC() + test.getTestD())/4;
            test.setAverage(newAvarage);
        }
        return test;
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
