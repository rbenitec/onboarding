package com.utp.hackaton.onborading.user_service.repository;

import com.utp.hackaton.onborading.user_service.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    @Query(value = "select * from users u where u.username = :username AND u.password = :password", nativeQuery = true)
    Optional<UserEntity> authenticate(@Param("username") String username, @Param("password") String password);

    @Query(value = "select * from users u where u.username = :username", nativeQuery = true)
    Optional<UserEntity> findByUsername(@Param("username") String username);
}
