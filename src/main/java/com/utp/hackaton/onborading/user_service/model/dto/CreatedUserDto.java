package com.utp.hackaton.onborading.user_service.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedUserDto {
    @NotBlank
    private String names;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String dni;
    @Email
    @NotBlank
    private String email;
    @NotNull
    private String avatar;
    @NotBlank
    private String campus;
}
