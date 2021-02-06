package com.dj.frontcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = null;
		String registrationReq = null;
		String loginrequest = null;
		out = response.getWriter();
		response.setContentType("text/html");
		registrationReq = request.getParameter("submit");
		loginrequest = request.getParameter("button");

		if (registrationReq != null) {
			if (registrationReq.equals("submit")) {
				// ServletContext sc = getServletContext();
				RequestDispatcher rdToRegSer = request.getRequestDispatcher("/registrationSer");
				rdToRegSer.include(request, response);
				if ((boolean) request.getAttribute("flag")) {

				} else {
					RequestDispatcher rdToRegHtml = request.getRequestDispatcher("registrationpage.html");
					rdToRegHtml.include(request, response);
				}
			}
		} else if (loginrequest != null) {
			if (loginrequest.equals("login")) {
				RequestDispatcher rd1 = request.getRequestDispatcher("/loginSer");
				rd1.forward(request, response);
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
