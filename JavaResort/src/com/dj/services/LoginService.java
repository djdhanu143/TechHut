package com.dj.services;

import com.dj.bo.LoginBO;
import com.dj.dto.LoginDTO;

public class LoginService  implements LoginServiceInf{

	@Override
	public int loginValues(LoginDTO ldto) {
		int status = 0;
		if (ldto != null) {
			LoginBO lbo=new LoginBO();
			lbo.setUserName(ldto.getUserName());
			lbo.setPassword(ldto.getPassword());
		}
		
		return 0;
	}
	

}
