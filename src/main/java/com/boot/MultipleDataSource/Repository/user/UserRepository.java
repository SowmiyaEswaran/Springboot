package com.boot.MultipleDataSource.Repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.MultipleDataSource.domain.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
