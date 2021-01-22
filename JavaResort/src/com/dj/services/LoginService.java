package com.dj.services;

import com.dj.bo.LoginBO;
import com.dj.dto.LoginDTO;

import TechHut.javaResort.dao.LoginDAO;
import TechHut.javaResort.dao.LoginDAOInf;

public class LoginService implements LoginServiceInf {

	@Override
	public boolean loginAthentication(LoginDTO dto) {
		boolean status = false;
		if (dto != null) {
			LoginBO bo = new LoginBO();
			bo.setUserName(dto.getUserName());
			bo.setPassword(dto.getPassword());
			
			LoginDAOInf logdao = new LoginDAO();
			status = logdao.getAthenticationValues(bo);
		}
		return status;
	}

}
