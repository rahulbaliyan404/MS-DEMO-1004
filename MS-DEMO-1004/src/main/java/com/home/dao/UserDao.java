package com.home.dao;

import java.util.List;
import java.util.Optional;

import com.home.bean.MySqlUser;

public interface UserDao {

	List<MySqlUser> getMySqlUsers();

	Optional<MySqlUser> getUserById(int id);

	MySqlUser saveUser(MySqlUser user);

	String deleteUser(int id);

	MySqlUser loginUser(MySqlUser user);

}
