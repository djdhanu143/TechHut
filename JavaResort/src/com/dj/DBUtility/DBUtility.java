package com.dj.DBUtility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtility {
	// private Connection con = null;
	public static Connection getConncetion() throws Exception {
		Connection con = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
		return con;
	}
}
