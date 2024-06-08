package com.utp.hackaton.onborading.user_service.controller;

import com.utp.hackaton.onborading.user_service.entity.TestEntity;
import com.utp.hackaton.onborading.user_service.entity.UserEntity;
import com.utp.hackaton.onborading.user_service.model.dto.*;
import com.utp.hackaton.onborading.user_service.service.TestService;
import com.utp.hackaton.onborading.user_service.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;
    private final TestService testService;

    @PostMapping("/created")
    public ResponseEntity<WrapperResponse<UserEntity>> saveUser(@RequestBody UserEntity user) {
        return new WrapperResponse<>(Boolean.TRUE, "SUCCESS", userService.saveUser(user)).createResponse();
    }

    @GetMapping("/get-all")
    public ResponseEntity<WrapperResponse<List<UserEntity>>> getAllUser() {
        return new WrapperResponse<>(Boolean.TRUE, "SUCCESS", userService.getAllUser()).createResponse();
    }
    @GetMapping("/test/get-all")
    public ResponseEntity<WrapperResponse<List<TestEntity>>> getAllTest() {
        return new WrapperResponse<>(Boolean.TRUE, "SUCCESS", testService.getAllTest()).createResponse();
    }
    @GetMapping("/ranking/get-all")
    public ResponseEntity<WrapperResponse<List<RankingDto>>> getUserRanking() {
        return new WrapperResponse<>(Boolean.TRUE, "SUCCESS", userService.getUserRanking()).createResponse();
    }
    @GetMapping("/get-all/{userId}")
    public ResponseEntity<WrapperResponse<UserEntity>> getUserById(@PathVariable("userId") Integer userId) {
        Optional<UserEntity> user = userService.getUserById(userId);
        if (user.isPresent()){
            return new WrapperResponse<>(Boolean.TRUE, "SUCCESS", user.get()).createResponse();
        } else {
            return new WrapperResponse<>(Boolean.FALSE, "FAILED", UserEntity.builder().build()).createResponse();
        }
    }
    @PostMapping("/created/test")
    public ResponseEntity<WrapperResponse<TestEntity>> registerTest(@RequestBody TestEntity test) {
        return new WrapperResponse<>(Boolean.TRUE, "SUCCESS", testService.saveTest(test)).createResponse();
    }
    @PostMapping("/authenticate")
    public ResponseEntity<WrapperResponse<ResponseUtpClient>> userAuthentication (@RequestBody RequestUtpClient requestUtpClient) {
        log.info("POST --> Se llamo al endPoint authenticate: {}", requestUtpClient.toString());
        Optional<UserEntity> user = userService.authenticateUser(requestUtpClient.getUsername(), requestUtpClient.getPassword());
        if(user.isPresent()){
            return new WrapperResponse<>(Boolean.TRUE, "SUCCESS", builResponseUtpClient(user.get())).createResponse();
        }else{
            return new WrapperResponse<>(Boolean.FALSE, "Usuario no existe", ResponseUtpClient.builder().build()).createResponse();
        }
    }
    @PostMapping("/created-user")
    public ResponseEntity<?> createdUser(@Valid @RequestBody CreatedUserDto userDto){
        Optional<UserEntity> userExist = userService.findByUsername(userDto.getUsername());
        if(userExist.isEmpty()){

            UserEntity user = UserEntity.builder()
                    .username(userDto.getUsername())
                    .password(userDto.getPassword())
                    .email(userDto.getEmail())
                    .names(userDto.getNames())
                    .dni(userDto.getDni())
                    .createdAt(LocalDate.now())
                    .build();

            userService.saveUser(user);
            return ResponseEntity.ok(user);
        }else {
            ResponseErrorDto responseErrorDto =  new ResponseErrorDto(202, "EL usuario ingresado ya existe");
            return ResponseEntity.accepted().body(responseErrorDto);
        }
    }

    private ResponseUtpClient builResponseUtpClient(UserEntity user) {
        return ResponseUtpClient.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .names(user.getNames())
                .build();
    }
}
