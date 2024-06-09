package com.utp.hackaton.onborading.user_service.service;

import com.utp.hackaton.onborading.user_service.entity.UserEntity;
import com.utp.hackaton.onborading.user_service.model.ReponseUpdateTestDto;
import com.utp.hackaton.onborading.user_service.model.dto.CreatedUserDto;
import com.utp.hackaton.onborading.user_service.model.dto.RankingDto;
import com.utp.hackaton.onborading.user_service.model.dto.UserRequestDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserEntity saveUser (UserEntity userDto);
    Optional<UserEntity> getUserById(Integer id);
    List<UserEntity> getAllUser();
    List<RankingDto> getUserRanking();
    Optional<ReponseUpdateTestDto> getTestUser(String username);
    void deleteUser(Integer id);
    UserEntity getUserByCampus(String campus);


    /***********/
    Optional<UserEntity> authenticateUser(String username, String password);
    Optional<UserEntity> findByUsername(String username);
    Optional<UserEntity> initializeUserAndTest(CreatedUserDto userDto);
}
