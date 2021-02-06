package com.dj.controllers;

import com.dj.services.RegistrationService;
import com.dj.services.RegistrationServiceInf;

public class ControllerFactoryClass {
	public static RegistrationServiceInf getRegistrationServiceInstance() {
		return new RegistrationService();
	}

}
