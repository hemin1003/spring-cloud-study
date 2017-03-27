package com.minbo.cloud.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minbo.cloud.study.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
