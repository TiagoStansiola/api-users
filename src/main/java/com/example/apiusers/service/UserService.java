package com.example.apiusers.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apiusers.model.UserEntity;
import com.example.apiusers.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public ArrayList<UserEntity> obtenerUsuarios(){
		return (ArrayList<UserEntity>) userRepository.findAll();
	}
	
	public UserEntity guardarUsuario(UserEntity user) {
		return userRepository.save(user);
	}
	
	public Optional<UserEntity> obtenerPorId(Long id){
		return userRepository.findById(id);
	}
	
	public  ArrayList<UserEntity> obtenerPorPrioridad(Integer prioridad){
		return userRepository.findByPrioridad(prioridad);
	}
	
	public boolean eliminarUsuario(Long id) {
		try {
			userRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

}
