package com.dj.frontcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.IOP.ServiceContext;

public class FrontController extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
		PrintWriter out = null;
		String registrationReq = null;
//		try {
		out= response.getWriter();
//		}catch(Exception e){
//			e.getMessage();
//		}
//		out.print("front");
		response.setContentType("text/html");
		registrationReq = request.getParameter("submit");
		
//		try {
			if (registrationReq.equals("submit")) {
				ServletContext sc = getServletContext();
				RequestDispatcher rd = sc.getRequestDispatcher("http://localhost:4040/JavaResort/registraionSer");
				rd.include(request, response);
			}
//		} catch (ServletException se) {
//			se.printStackTrace();
//		} catch (IOException ioe) {
//			ioe.printStackTrace();
//		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		doGet(request, response);
	}
}
