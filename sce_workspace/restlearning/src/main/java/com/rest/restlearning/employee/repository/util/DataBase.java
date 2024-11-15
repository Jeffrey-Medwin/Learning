package com.rest.restlearning.employee.repository.util;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.rest.restlearning.Constants;

public class DataBase {
	private static File file = new File(System.getProperty("user.dir") + "/src/main/resources/database.properties");
	private static Properties properties = null;
	private static ComboPooledDataSource dataSource = null;

	static {
		try {
			properties = new Properties();
			properties.load(new FileInputStream(file));

			dataSource = new ComboPooledDataSource();

			dataSource.setDriverClass(properties.getProperty(Constants.DRIVER));
			dataSource.setJdbcUrl(properties.getProperty(Constants.URl));
			dataSource.setUser(properties.getProperty(Constants.USER_NAME));
			dataSource.setPassword(properties.getProperty(Constants.PASSWORD));

			dataSource.setMinPoolSize(2);
			dataSource.setMaxPoolSize(10);
			dataSource.setAcquireIncrement(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		try {
			System.out.println(file);
			return dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
