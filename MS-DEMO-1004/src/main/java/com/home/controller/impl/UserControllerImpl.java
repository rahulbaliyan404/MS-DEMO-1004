package com.home.controller.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.home.bean.MySqlUser;
import com.home.controller.UserController;
import com.home.logic.UserLogic;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserControllerImpl implements UserController {
	
	@Autowired
	private UserLogic userLogic;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserControllerImpl.class);

	@Override
	public MySqlUser loginUser(MySqlUser user) {
		LOGGER.info("UserControllerImpl loginUser method  :: START");
		return userLogic.loginUser(user);
	}

	@Override
	public Optional<MySqlUser> getUserById(int id) {
		LOGGER.info("UserControllerImpl getUserById method :: START");
		return userLogic.getUserById(id);
	}

	@Override
	public List<MySqlUser> getUsers() {
		LOGGER.info("UserControllerImpl getUsers method    :: START");
		return userLogic.getUsers();
	}

	@Override
	public String saveUser(MySqlUser user) {
		LOGGER.info("UserControllerImpl saveUser method    :: START");
		return userLogic.saveUser(user);
	}

	@Override
	public String deleteUser(int id) {
		LOGGER.info("UserControllerImpl deleteUser method  :: START");
		return userLogic.deleteUser(id);
	}

	@Override
	public String updateUser(MySqlUser user,int id) {
		
		System.out.println(user.getId());
		System.out.println(user.getName());
		System.out.println(id);
		
		return null;
	}

}
