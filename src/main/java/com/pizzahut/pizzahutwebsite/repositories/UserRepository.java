package com.pizzahut.pizzahutwebsite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pizzahut.pizzahutwebsite.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity , Long >{

}
