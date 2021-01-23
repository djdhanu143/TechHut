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
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = null;
//		try {
		out = response.getWriter();
//		} catch (IOException e) {
//			e.getMessage();
//		}
		response.setContentType("text/html");
		RegistrationDTO dto = new RegistrationDTO();
		dto.setfName(request.getParameter("fn"));
		dto.setsName(request.getParameter("sn"));
		dto.setGender(request.getParameter("gender"));
		String ph = request.getParameter("ph");
		dto.setEmail(request.getParameter("mail"));
		dto.setUserName(request.getParameter("un"));
		dto.setPassword(request.getParameter("psw"));
		if (dto.getfName() == null || dto.getfName().equals("") || dto.getfName().length() == 0) {
			out.print("<h2 style='color:red;'>firstName should not be empty</h2>");
			RequestDispatcher rd = request.getRequestDispatcher("registrationpage.html");
			rd.include(request, response);
		} else if (dto.getsName() == null || dto.getsName().equals("") || dto.getsName().length() == 0) {
			out.print("<h2 style='color:red;'>secondName should not be empty</h2>");
			RequestDispatcher rd = request.getRequestDispatcher("registrationpage.html");
			rd.include(request, response);
		}
//			else if(dto.getPhone()<10) {
//				out.print("<h2 style='color:red;'>enter10 digits phone num</h2>");
//				RequestDispatcher rd = request.getRequestDispatcher("registrationpage.html");
//				rd.include(request, response);
//			}
		 else if (dto.getUserName() == null || dto.getUserName().equals("") || dto.getUserName().length() == 0) {
			out.print("<h2 style='color:red;'>userName should not be empty</h2>");
			RequestDispatcher rd = request.getRequestDispatcher("registrationpage.html");
			rd.include(request, response);
		} else if (dto.getPassword() == null || dto.getPassword().equals("") || dto.getPassword().length() == 0) {
			out.print("<h2 style='color:red;'>password should not be empty</h2>");
			RequestDispatcher rd = request.getRequestDispatcher("registrationpage.html");
			rd.include(request, response);
		} else if (dto.getPassword().length() < 8) {
			out.print("<h2 style='color:red;'>password min have 8 characters</h2>");
			RequestDispatcher rd = request.getRequestDispatcher("registrationpage.html");
			rd.include(request, response);
		} else {
			RegistrationServiceInf register = new RegistrationService();
			int status = register.registerValues(dto);
			if (status > 0) {
				out.print("<h2 style='color:green'>your registration is successfull</h2>");
//				try {
				RequestDispatcher rd = request.getRequestDispatcher("loginpage.html");
				rd.include(request, response);
//				} catch (Exception e) {
//					e.getMessage();
//				}
			} else {
				out.print("<h2>your registration has failed try again</h2>");
//				try {
				RequestDispatcher rd = request.getRequestDispatcher("registrationpage.html");
				rd.include(request, response);
//				} catch (Exception e) {
//					e.getMessage();
//				}
			}

		}
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}