package com.home.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.home.bean.MySqlUser;
import com.home.constant.Constants;
import com.home.dao.UserDao;
import com.home.repository.MySqlUserRepository;
import com.home.utils.DbConnection;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private MySqlUserRepository mySqlUserRepository;

	@Autowired
	private DbConnection dbConection;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);
	String message = Constants.ERROR;

	@Override
	public List<MySqlUser> getMySqlUsers() {
		LOGGER.info("UserDaoImpl getMySqlUsers method   :: START");
		return mySqlUserRepository.findAll();
	}
	@Override
	public Optional<MySqlUser> getUserById(int id) {
		LOGGER.info("UserDaoImpl getUserById method :: START");
		return mySqlUserRepository.findById(id);
	}

	@Override
	public MySqlUser saveUser(MySqlUser user) {
		LOGGER.info("UserDaoImpl saveUser method    :: START");
		return mySqlUserRepository.save(user);
	}

	@Override
	public String deleteUser(int id) {
		LOGGER.info("UserDaoImpl deleteUser method  :: START");
		mySqlUserRepository.deleteById(id);
		Optional<MySqlUser> response = mySqlUserRepository.findById(id);
		LOGGER.info("UserDaoImpl deleteUser method  :: END");
		return response.toString();
	}

	@Override
	public MySqlUser loginUser(MySqlUser user) {
		LOGGER.info("UserDaoImpl loginUser method   :: START");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		MySqlUser userResponse = new MySqlUser();

		try {
			connection = dbConection.getDbConnection();
			String sql = "SELECT Id,Name,Password FROM user WHERE Name =" + " '" + user.getName() + "' "
					+ " AND Password = " + " '" + user.getPassword() + "' ";
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				userResponse.setId(rs.getInt("Id"));
				userResponse.setName(rs.getString("Name"));
				userResponse.setPassword(rs.getString("Password"));
			}

		} catch (Exception e) {
			LOGGER.error("UserDaoImpl loginUser method catch block :: Exception :: ", e);
		} finally {
			try {
				if (connection != null && preparedStatement != null) {
					preparedStatement.close();
					connection.close();
				}

			} catch (SQLException e) {

				LOGGER.error("UserDaoImpl loginUser method finally block :: SQLException :: ", e);
			}
		}
		LOGGER.info("UserDaoImpl loginUser method  :: END");
		return userResponse;
	}

}
