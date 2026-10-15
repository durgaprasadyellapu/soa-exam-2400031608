package com.soa.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soa.ms.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
