package com.dj.controllers;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dj.dto.RegistrationDTO;

public class RegistrationServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out = null;
		RegistrationDTO dto = new RegistrationDTO();
		dto.setfName(request.getParameter("fn"));
		dto.setsName(request.getParameter("sn"));
		dto.setGender(request.getParameter("gender"));
		dto.setPhone(Long.parseLong(request.getParameter("ph")));
		dto.setEmail(request.getParameter("mail"));
		response.setContentType("text/html");
	}
}
