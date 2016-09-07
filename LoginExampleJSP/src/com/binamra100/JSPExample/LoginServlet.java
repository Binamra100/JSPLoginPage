package com.binamra100.JSPExample;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.binamra100.JSPExample.Services.LoginService;
import com.binamra100.JSPExample.dbo.User;


@WebServlet(description = "A simple Servlet which works as controller.", urlPatterns = { "/Login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username, password;
		LoginService auth = new LoginService();
		Boolean result;
		username = request.getParameter("username");
		password = request.getParameter("password");
		result = auth.authentication(username, password);
		if (result){
			User user =auth.getUserDetail(username);
			request.setAttribute("user", user);
			RequestDispatcher dp = request.getRequestDispatcher("Success.jsp");
			dp.forward(request, response);
			return;
		}
		else{
			response.sendRedirect("LoginPage.jsp");
			return;
		}
	}

}
