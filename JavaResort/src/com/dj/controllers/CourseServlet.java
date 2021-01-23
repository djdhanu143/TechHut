package com.dj.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/CourseService")
public class CourseServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = null;
		HttpSession session = null;

		response.setContentType("text/html");
		out = response.getWriter();
		session = request.getSession(false);
		if (session != null) {

			out.print(
					"<h1 style='float:left;'>Welcome To <spam style='color:white;'>Tech Hut </spam> Mr/Mrs <spam style='color:yellow';>'"
							+ session.getAttribute("userName") + "'</spam></h1>");
			RequestDispatcher rd = request.getRequestDispatcher("course.html");
			rd.include(request, response);
		} else {
			out.print("<h1>your session has expaired login again</h1>");
			RequestDispatcher rd = request.getRequestDispatcher("loginpage.html");
			rd.include(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
