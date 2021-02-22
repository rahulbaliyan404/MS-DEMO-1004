package com.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.home.bean.MySqlUser;

public interface MySqlUserRepository extends JpaRepository<MySqlUser, Integer> {

}
