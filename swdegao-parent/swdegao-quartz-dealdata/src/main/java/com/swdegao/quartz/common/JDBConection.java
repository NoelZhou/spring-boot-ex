package com.swdegao.quartz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JDBConection {
	public Connection connection = null;
	public JDBConection() {
		ResourceBundle bundle = ResourceBundle.getBundle("quartz");
		String driver = bundle.getString("mysql_driver");
		String url = bundle.getString("mysql_url");
		String user = bundle.getString("mysql_user");
		String password = bundle.getString("mysql_password");
		try {
			Class.forName(driver).newInstance();
			connection = DriverManager.getConnection(url, user, password);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
