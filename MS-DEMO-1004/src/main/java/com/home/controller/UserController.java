package com.home.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.home.bean.MySqlUser;

import io.swagger.annotations.Api;

@RequestMapping(value = "/demo1004")
@Api(value = "demo1004", tags = "User Management.")
public interface UserController {

	@GetMapping(value = "/login")
	public MySqlUser loginUser(@RequestBody MySqlUser userPojo);

	@GetMapping(value = "/user/{id}")
	public Optional<MySqlUser> getUserById(@PathVariable("id") int id);

	@GetMapping(value = "/users")
	public List<MySqlUser> getUsers();

	@PostMapping(value = "/signup")
	public String saveUser(@RequestBody MySqlUser user);

	@DeleteMapping(value = "/delete/{id}")
	public String deleteUser(@PathVariable("id") int id);

	@PutMapping(value = "/update/{id}")
	public String updateUser(@RequestBody MySqlUser user, @PathVariable("id") int id);

}
