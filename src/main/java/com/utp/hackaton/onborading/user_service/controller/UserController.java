package com.utp.hackaton.onborading.user_service.controller;

import com.utp.hackaton.onborading.user_service.entity.EventEntity;
import com.utp.hackaton.onborading.user_service.entity.TestEntity;
import com.utp.hackaton.onborading.user_service.entity.UserEntity;
import com.utp.hackaton.onborading.user_service.model.ReponseUpdateTestDto;
import com.utp.hackaton.onborading.user_service.model.UpdateTestDto;
import com.utp.hackaton.onborading.user_service.model.dto.*;
import com.utp.hackaton.onborading.user_service.service.EventService;
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
    private final EventService eventService;

//    @CrossOrigin(origins = "http://localhost:3000")
//    @PostMapping("/created")
//    public ResponseEntity<WrapperResponse<UserEntity>> saveUser(@RequestBody UserEntity user) {
//        return new WrapperResponse<>(Boolean.TRUE, "SUCCESS", userService.saveUser(user)).createResponse();
//    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/get-all")
    public ResponseEntity<WrapperResponse<List<UserEntity>>> getAllUser() {
        return new WrapperResponse<>(Boolean.TRUE, "SUCCESS", userService.getAllUser()).createResponse();
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/test/get-all")
    public ResponseEntity<WrapperResponse<List<TestEntity>>> getAllTest() {
        return new WrapperResponse<>(Boolean.TRUE, "SUCCESS", testService.getAllTest()).createResponse();
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/ranking/get-all")
    public ResponseEntity<WrapperResponse<List<RankingDto>>> getUserRanking() {
        return new WrapperResponse<>(Boolean.TRUE, "SUCCESS", userService.getUserRanking()).createResponse();
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/get-all/{userId}")
    public ResponseEntity<WrapperResponse<UserEntity>> getUserById(@PathVariable("userId") Integer userId) {
        Optional<UserEntity> user = userService.getUserById(userId);
        if (user.isPresent()){
            return new WrapperResponse<>(Boolean.TRUE, "SUCCESS", user.get()).createResponse();
        } else {
            return new WrapperResponse<>(Boolean.FALSE, "FAILED", UserEntity.builder().build()).createResponse();
        }
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/user/get-test/{username}")
    public ResponseEntity<WrapperResponse<ReponseUpdateTestDto>> getTestOfUser(@PathVariable("username") String username) {
        Optional<ReponseUpdateTestDto> testUser = userService.getTestUser(username);
        if (testUser.isPresent()){
            return new WrapperResponse<>(Boolean.TRUE, "SUCCESS", testUser.get()).createResponse();
        } else {
            return new WrapperResponse<>(Boolean.FALSE, "El Usuario no tiene notas registradas", ReponseUpdateTestDto.builder().build()).createResponse();
        }
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/event/get-all")
    public ResponseEntity<WrapperResponse<List<EventEntity>>> getEvent() {
        return new WrapperResponse<>(Boolean.TRUE, "SUCCESS", eventService.findAllEvents()).createResponse();
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/created/test")
    public ResponseEntity<WrapperResponse<TestEntity>> registerTest(@RequestBody TestEntity test) {
        return new WrapperResponse<>(Boolean.TRUE, "SUCCESS", testService.saveTest(test)).createResponse();
    }
    @CrossOrigin(origins = "http://localhost:3000")
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
    @CrossOrigin(origins = "http://localhost:3000")
    @PatchMapping("/update/test")
    public ResponseEntity<WrapperResponse<ReponseUpdateTestDto>> updateTestUser (@RequestBody UpdateTestDto updateTestDto) {
        log.info("POST --> Se llamo al endPoint updateTestUser: {}", updateTestDto.toString());
        ReponseUpdateTestDto updateTest = testService.updateTest(updateTestDto);
        if(updateTest!=null){
            return new WrapperResponse<>(Boolean.TRUE, "SUCCESS", updateTest).createResponse();
        }else{
            return new WrapperResponse<>(Boolean.FALSE, "FAILED", ReponseUpdateTestDto.builder().build()).createResponse();
        }
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/created-user")
    public ResponseEntity<?> createdUser(@Valid @RequestBody CreatedUserDto userDto){
        Optional<UserEntity> userExist = userService.initializeUserAndTest(userDto);
        if(userExist.isPresent()){
            return ResponseEntity.ok(userExist.get());
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
