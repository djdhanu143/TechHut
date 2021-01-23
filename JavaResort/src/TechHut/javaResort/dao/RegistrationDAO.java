package TechHut.javaResort.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.dj.bo.RegistrationBO;

public class RegistrationDAO implements RegistrationDAOInf {
	static Connection con = null;
	// int i =0;
	static PreparedStatement ps = null;
	static String QUERY = "insert into registration_tb values(?,?,?,?,?,?,?)";

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.43.223:1521:xe", "system", "tiger");
			ps = con.prepareStatement(QUERY);
		} catch (Exception e) {
			e.printStackTrace();
			;
		}
	}

	public int saveRegistration(RegistrationBO bo) {
		int status = 0;
		try {
			if (bo != null) {
				if (ps != null) {
					ps.setString(1, bo.getfName());
					ps.setString(2, bo.getsName());
					ps.setString(3, bo.getGender());
					ps.setLong(4, bo.getPhone());
					ps.setString(5, bo.getEmail());
					ps.setString(6, bo.getUserName());
					ps.setString(7, bo.getPassword());

					status = ps.executeUpdate();
					return status;
				}
				
			}
			return status;
		} catch (Exception e) {
			e.printStackTrace();
			return status;
		} finally {

			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
				e.getMessage();
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
	}
}
