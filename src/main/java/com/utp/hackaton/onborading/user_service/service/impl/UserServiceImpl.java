package com.utp.hackaton.onborading.user_service.service.impl;

import com.utp.hackaton.onborading.user_service.entity.TestEntity;
import com.utp.hackaton.onborading.user_service.entity.UserEntity;
import com.utp.hackaton.onborading.user_service.model.ReponseUpdateTestDto;
import com.utp.hackaton.onborading.user_service.model.dto.CreatedUserDto;
import com.utp.hackaton.onborading.user_service.model.dto.RankingDto;
import com.utp.hackaton.onborading.user_service.model.dto.UserRequestDto;
import com.utp.hackaton.onborading.user_service.repository.TestRepository;
import com.utp.hackaton.onborading.user_service.repository.UserRepository;
import com.utp.hackaton.onborading.user_service.service.TestService;
import com.utp.hackaton.onborading.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final TestService testService;

    @Override
    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<UserEntity> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public List<RankingDto> getUserRanking() {
        List<RankingDto> rankingDtos = new ArrayList<>();
        userRepository.findAll().forEach(user -> {
            Optional<TestEntity> testEntity = testService.getTestByUserId(user.getId());
            if(testEntity.isPresent() && Objects.nonNull(testEntity.get().getAverage())){
                RankingDto rankingDto =  RankingDto.builder()
                        .names(user.getNames())
                        .photo(user.getAvatar())
                        .average(testEntity.get().getAverage())
                        .build();
                rankingDtos.add(rankingDto);
            }
        });
        return rankingDtos;
    }

    @Override
    public Optional<ReponseUpdateTestDto> getTestUser(String username) {
        Optional<UserEntity> user = userRepository.findByUsername(username.toLowerCase());
        if(user.isPresent()){
            Optional<TestEntity> test = testService.getTestByUserId(user.get().getId());
            if(test.isPresent()){
                return Optional.of(buildResponseUpdateTest(test.get(), user.get()));
            }
        }
        return Optional.empty();
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserEntity getUserByCampus(String campus) {
        return null;
    }

    @Override
    public Optional<UserEntity> authenticateUser(String username, String password) {
        return userRepository.authenticate(username, password);
    }

    @Override
    public Optional<UserEntity> findByUsername(String username) {
        return userRepository.findByUsername(username);
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

    @Override
    public Optional<UserEntity> initializeUserAndTest(CreatedUserDto userDto) {
        Optional<UserEntity> userExist = userRepository.findByUsername(userDto.getUsername());
        if (userExist.isEmpty()) {
            UserEntity user = UserEntity.builder()
                    .username(userDto.getUsername())
                    .password(userDto.getPassword())
                    .email(userDto.getEmail())
                    .names(userDto.getNames())
                    .avatar(userDto.getAvatar())
                    .campus(userDto.getCampus())
                    .dni(userDto.getDni())
                    .createdAt(LocalDate.now())
                    .build();
            UserEntity user1 = userRepository.save(user);
            TestEntity test = TestEntity.builder()
                    .testA(-1.0)
                    .testB(-1.0)
                    .testC(-1.0)
                    .testD(-1.0)
                    .userId(user1.getId())
                    .build();
            testService.saveTest(test);
            return Optional.of(user1);
        }else {
            return Optional.empty();
        }
    }
}
