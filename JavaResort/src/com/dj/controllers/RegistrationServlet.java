package com.dj.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dj.dto.RegistrationDTO;
import com.dj.services.RegistrationService;
import com.dj.services.RegistrationServiceInf;

public class RegistrationServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException  {
		
		PrintWriter out = null;
//		try {
			out = response.getWriter();
//		} catch (IOException e) {
//			e.getMessage();
//		}
		
		out.print("reg ser");
		response.setContentType("text/html");
		RegistrationDTO dto = new RegistrationDTO();
		dto.setfName(request.getParameter("fn"));
		dto.setsName(request.getParameter("sn"));
		dto.setGender(request.getParameter("gender"));
		dto.setPhone(Long.parseLong(request.getParameter("ph")));
		dto.setEmail(request.getParameter("mail"));
		dto.setUserName(request.getParameter("un"));
		dto.setPassword(request.getParameter("psw"));

		if (dto.getfName() == null || dto.getfName().equals("") || dto.getfName().length() == 0) {
			out.print("first name field should not be empty");
		} else if (dto.getsName() == null || dto.getsName().equals("0") || dto.getsName().length() == 0) {
			out.print("second name should not be empty");
		} else if (dto.getUserName() == null || dto.getUserName().equals("") || dto.getUserName().length() == 0) {
			out.print("userName fileds should not be empty");
		} else if (dto.getPassword() == null || dto.getPassword().equals("") || dto.getPassword().length() == 0) {
			out.print("userName fileds should not be empty");
		} else if (dto.getPassword().length() < 8) {
			out.print("password should be min 8 characterss");
		} else {
			RegistrationServiceInf register = new RegistrationService();
			int status = register.registerValues(dto);
			if (status > 0) {
				out.print("your registration is successfull");
//				try {
					RequestDispatcher rd = request.getRequestDispatcher("loginpage.html");
					rd.include(request, response);
//				} catch (Exception e) {
//					e.getMessage();
//				}
			} else {
				out.print("your registration has failed try again");
//				try {
					RequestDispatcher rd = request.getRequestDispatcher("registrationpage.html");
					rd.include(request, response);
//				} catch (Exception e) {
//					e.getMessage();
//				}
			}

		}
	}
}