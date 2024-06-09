package com.utp.hackaton.onborading.user_service.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReponseUpdateTestDto {
    private Double testA;
    private Double testB;
    private Double testC;
    private Double testD;
    private Double average;
    private String username;
}
