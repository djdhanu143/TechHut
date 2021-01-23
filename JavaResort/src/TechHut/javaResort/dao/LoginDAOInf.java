package TechHut.javaResort.dao;

import com.dj.bo.LoginBO;

public interface LoginDAOInf {
	public boolean getAthenticationValues(LoginBO lbo)throws Exception;

}
