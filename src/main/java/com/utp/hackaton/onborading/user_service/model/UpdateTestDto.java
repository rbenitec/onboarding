package com.utp.hackaton.onborading.user_service.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateTestDto {
    private String nombreTest;
    private Double valorNota;
    private String username;
}
