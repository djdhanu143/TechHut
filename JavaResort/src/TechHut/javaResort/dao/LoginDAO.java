package TechHut.javaResort.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dj.DBUtility.DBUtility;
import com.dj.bo.LoginBO;

public class LoginDAO implements LoginDAOInf {
	@Override
	public boolean getAthenticationValues(LoginBO bo) throws Exception {
		//Connection con = null;
		//PreparedStatement ps = null;
		String QUERY = "SELECT * FROM REGISTRATION_TB WHERE USERNAME  = ? AND PASSWORD = ?";
		if (bo != null) {
			try(Connection con = DBUtility.getConncetion();PreparedStatement ps = con.prepareStatement(QUERY)){
			ps.setString(1, bo.getUserName());
			ps.setString(2, bo.getPassword());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return true;
			}
			return false;
			}catch(Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}
}
