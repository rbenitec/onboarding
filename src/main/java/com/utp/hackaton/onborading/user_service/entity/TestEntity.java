package com.utp.hackaton.onborading.user_service.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "test")
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nota1")
    private Double testA;
    @Column(name = "nota2")
    private Double testB;
    @Column(name = "nota3")
    private Double testC;
    @Column(name = "nota4")
    private Double testD;
    private Double average;
    @Column(name = "user_id")
    private Integer userId;
}
