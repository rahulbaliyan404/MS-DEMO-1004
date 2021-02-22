package com.home.logic.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.home.bean.MySqlUser;
import com.home.constant.Constants;
import com.home.dao.UserDao;
import com.home.logic.UserLogic;

@Component
public class UserLogicImpl implements UserLogic {

	@Autowired
	private UserDao userDao;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserLogicImpl.class);
	String message = null;

	@Override
	public Optional<MySqlUser> getUserById(int id) {
		LOGGER.info("UserLogicImpl getUserById method :: START");
		return userDao.getUserById(id);
	}

	@Override
	public List<MySqlUser> getUsers() {
		LOGGER.info("UserLogicImpl getUsers method :: START");

		List<MySqlUser> mysqlUserList = userDao.getMySqlUsers();
		/*
		 * List<PgSqlUser> pgSqlUserList = userDao.getPgSqlUsers();
		 * 
		 * for (PgSqlUser pgSqlUserData : pgSqlUserList) {
		 * System.out.println(pgSqlUserData.getName());
		 * System.out.println(pgSqlUserData.getPassword());
		 * System.out.println(pgSqlUserData.getEmail()); }
		 */
		return mysqlUserList;

	}

	@Override
	public String saveUser(MySqlUser user) {
		LOGGER.info("UserLogicImpl saveUser method :: START");
		MySqlUser response = userDao.saveUser(user);

		if (response != null) {
			message = Constants.SUCCESS;
		}

		return message;
	}

	@Override
	public String deleteUser(int id) {
		LOGGER.info("UserLogicImpl deleteUser method :: START");
		return userDao.deleteUser(id);
	}

	@Override
	public MySqlUser loginUser(MySqlUser user) {
		LOGGER.info("UserLogicImpl loginUser method :: START");
		return userDao.loginUser(user);
	}

}
