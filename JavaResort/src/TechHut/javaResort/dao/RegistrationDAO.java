package TechHut.javaResort.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.dj.DBUtility.DBUtility;
import com.dj.bo.RegistrationBO;

public class RegistrationDAO implements RegistrationDAOInf {

	public int saveRegistration(RegistrationBO bo) {
		//Connection con = null;
		//PreparedStatement ps = null;
		String QUERY = "INSERT INTO REGISTRATION VALUES(?,?,?,?,?,?,?)";
		int status = 0;
		if (bo != null) {
			try(Connection con = DBUtility.getConncetion();PreparedStatement ps = con.prepareStatement(QUERY);) {
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
				return status;
			} catch (Exception e) {
				e.printStackTrace();
				return status;
			} 
		}else {
			return status;
		}
	}
}
