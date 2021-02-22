package com.home.logic;

import java.util.List;
import java.util.Optional;

import com.home.bean.MySqlUser;

public interface UserLogic {

	Optional<MySqlUser> getUserById(int id);

	List<MySqlUser> getUsers();

	String saveUser(MySqlUser user);

	String deleteUser(int id);

	MySqlUser loginUser(MySqlUser user);

}
