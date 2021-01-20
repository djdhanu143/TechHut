package com.dj.controllers;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dj.dto.RegistrationDTO;
import com.dj.services.RegistrationService;
import com.dj.services.RegistrationServiceInf;

public class RegistrationServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out = null;
		RegistrationDTO dto = new RegistrationDTO();
		dto.setfName(request.getParameter("fn"));
		dto.setsName(request.getParameter("sn"));
		dto.setGender(request.getParameter("gender"));
		dto.setPhone(Long.parseLong(request.getParameter("ph")));
		dto.setEmail(request.getParameter("mail"));
		dto.setUserName(request.getParameter("un"));
		dto.setPassword(request.getParameter("psw"));
		
		RegistrationServiceInf register = new RegistrationService();
		register.registerValues(dto);
		
		response.setContentType("text/html");
	}
}
