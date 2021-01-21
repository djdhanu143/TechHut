package com.dj.frontcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out = null;
		String registrationReq = null;
		response.setContentType("text/html");
		registrationReq = request.getParameter("submit");
		try {
			if (registrationReq.equals("submit")) {
				RequestDispatcher rd = request.getRequestDispatcher("registraionSer");
				rd.include(request, response);
			}
		} catch (ServletException se) {
			se.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}
}
