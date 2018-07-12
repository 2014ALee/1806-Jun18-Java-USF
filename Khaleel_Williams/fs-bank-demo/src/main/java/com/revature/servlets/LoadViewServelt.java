package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.util.RequestViewHelper;

@WebServlet("*.view")
public class LoadViewServelt extends HttpServlet{

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			System.out.println("[LOG] - Request sent to fron controller, LoadViewServlet.doGet()");
			
			String nextView = new RequestViewHelper().process(req, resp);
			System.out.println(nextView);
			
			req.getRequestDispatcher(nextView).forward(req, resp);
			
		}
}
