package com.dj.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dj.dto.LoginDTO;
import com.dj.dto.RegistrationDTO;
import com.dj.services.LoginService;

import oracle.net.ns.SessionAtts;

public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = null;
		
		response.setContentType("text/html");
		out = response.getWriter();
		LoginDTO dto = new LoginDTO();
		dto.setUserName(request.getParameter("UN"));
		dto.setPassword(request.getParameter("PWD"));
		if (dto.getUserName() == null || dto.getUserName().equals("") || dto.getUserName().length() == 0) {
			out.print("<h2 style='color:red;'>userName should not be empty</h2>");
			RequestDispatcher rd = request.getRequestDispatcher("loginpage.html");
			rd.include(request, response);

		} else if (dto.getPassword() == null || dto.getPassword().equals("") || dto.getPassword().length() == 0) {
			out.print("<h2 style='color:red;'>password should not be empty</h2>");
			RequestDispatcher rd = request.getRequestDispatcher("loginpage.html");
			rd.include(request, response);
		} else {
			LoginService logservice = new LoginService();
			boolean status = false;
			status = logservice.loginAthentication(dto);
			if (status) {
				HttpSession session = request.getSession(true);
				session.setAttribute("userName", dto.getUserName());
				out.print(
						"<h1 style='float:left;'>Welcome To <spam style='color:white;'>Tech Hut </spam> Mr/Mrs <spam style='color:yellow';>'"
								+ dto.getUserName() + "'</spam></h1>");
				RequestDispatcher rd = request.getRequestDispatcher("homepage.html");
				rd.include(request, response);
			} else {
				out.print("<h1>You Enter Details Or Wrong</h1>");
				RequestDispatcher rd = request.getRequestDispatcher("loginpage.html");
				rd.include(request, response);
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
