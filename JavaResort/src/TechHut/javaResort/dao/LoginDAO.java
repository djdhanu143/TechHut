package TechHut.javaResort.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dj.bo.LoginBO;

public class LoginDAO implements LoginDAOInf {
	static Connection con = null;
	static PreparedStatement ps = null;
	static String QUERY = "select * from registration_tb where userName = ? and password = ?";
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.43.223:1521:xe", "system", "tiger");
			ps = con.prepareStatement(QUERY);
		} catch (Exception e) {
			e.printStackTrace();;
		}
	}

	@Override
	public boolean getAthenticationValues(LoginBO bo) throws Exception {
		if (bo != null) {
			ps.setString(1, bo.getUserName());
			ps.setString(2, bo.getPassword());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return true;
			}
		}
		return false;
	}
}
