package TechHut.javaResort.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.dj.bo.LoginBO;

public class LoginDAO implements LoginDAOInf {
	static Connection con = null;
	static PreparedStatement ps = null;
	static String QUERY = "select * from registration_tb where userName = ? && password = ?";
	static {
		try {
			Class.forName("oracle.jdbc.driver.OralceDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
			ps = con.prepareStatement(QUERY);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Override
	public boolean getAthenticationValues(LoginBO bo) {
		boolean status = true;
		try {
			ps.setString(1, bo.getUserName());
			ps.setString(2, bo.getPassword());
			status = ps.execute();
			return status;
		} catch (Exception e) {
			return status;
		}
	}

}
