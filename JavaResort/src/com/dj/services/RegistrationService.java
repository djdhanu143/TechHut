package com.dj.services;

import com.dj.bo.RegistrationBO;
import com.dj.dto.RegistrationDTO;

import TechHut.javaResort.dao.DAOFactoryClass;
import TechHut.javaResort.dao.RegistrationDAO;
import TechHut.javaResort.dao.RegistrationDAOInf;

public class RegistrationService implements RegistrationServiceInf {

	@Override
	public int registerValues(RegistrationDTO dto) {
		int status = 0;
		if (dto != null) {
			RegistrationBO bo = new RegistrationBO();
			bo.setfName(dto.getfName());
			bo.setsName(dto.getsName());
			bo.setGender(dto.getGender());
			bo.setPhone(dto.getPhone());
			bo.setUserName(dto.getUserName());
			bo.setPassword(dto.getPassword());
			bo.setEmail(dto.getEmail());
			
			RegistrationDAOInf dao = DAOFactoryClass.getRegistrationDAOInfInstance();
			status = dao.saveRegistration(bo);
			return status;
		}
		return status;
	}
}
