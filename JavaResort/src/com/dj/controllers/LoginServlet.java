package com.dj.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dj.dto.RegistrationDTO;
public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = null;
		out = response.getWriter();
		RegistrationDTO dto = new RegistrationDTO();
		dto.setUserName(request.getParameter("UN"));
		dto.setPassword(request.getParameter(""));
		if (dto.getUserName() == null || dto.getUserName().equals("") || dto.getUserName().length() == 0) {
			out.print("<h2 style='color:red;'>userName should not be empty</h2>");
			RequestDispatcher rd = request.getRequestDispatcher("loginpage.html");
			rd.include(request, response);
			
		}else if (dto.getPassword() == null || dto.getPassword().equals("") || dto.getPassword().length() == 0) {
				out.print("<h2 style='color:red;'>password should not be empty</h2>");
				RequestDispatcher rd = request.getRequestDispatcher("loginpage.html");
				rd.include(request, response);
			}else {
			RequestDispatcher disp=request.getRequestDispatcher("loginSer");
			disp.include(request, response);
				
			}

	}
}
