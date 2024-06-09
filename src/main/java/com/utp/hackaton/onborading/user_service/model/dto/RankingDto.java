package com.utp.hackaton.onborading.user_service.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RankingDto {
    private String names;
    private String photo;
    private Double average;
}
