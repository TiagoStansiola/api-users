package com.example.apiusers.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiusers.model.UserEntity;
import com.example.apiusers.service.UserService;

@RestController
@RequestMapping("/usuario")
public class UserController {
	@Autowired
	UserService userService;
	
	
	@GetMapping
	public ArrayList<UserEntity> obtenerUsuarios(){
		return userService.obtenerUsuarios();
	}
	
	@PostMapping
	public UserEntity guardarUsuario(@RequestBody UserEntity user) {
		return this.userService.guardarUsuario(user);
	}
	
	@GetMapping(path = "/{id}")
	public Optional<UserEntity> obtenerPorId(@PathVariable("id") Long id){
		return userService.obtenerPorId(id);
	}
	
	@GetMapping(path = "/query")
	public ArrayList<UserEntity> obtenerPorPrioridad(@RequestParam("prioridad") Integer prioridad){
		return userService.obtenerPorPrioridad(prioridad);
	}
	
	@DeleteMapping(path = ("/{id}"))
	public String eliminarPorId(@PathVariable("id") Long id) {
		boolean ok = userService.eliminarUsuario(id);
		
		if(ok) {
			return "Se elimino el usuario con id: " + id;
		}else {
			return "No se pudo eliminar el usuario con id: " +id;
		}
	}

}
