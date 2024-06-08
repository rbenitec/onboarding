package com.utp.hackaton.onborading.user_service.service.impl;

import com.utp.hackaton.onborading.user_service.entity.UserEntity;
import com.utp.hackaton.onborading.user_service.model.dto.UserRequestDto;
import com.utp.hackaton.onborading.user_service.repository.UserRepository;
import com.utp.hackaton.onborading.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

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
}
