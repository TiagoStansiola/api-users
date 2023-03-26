package com.example.apiusers.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.apiusers.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
	public abstract ArrayList<UserEntity> findByPrioridad(Integer prioridad);
	

}
