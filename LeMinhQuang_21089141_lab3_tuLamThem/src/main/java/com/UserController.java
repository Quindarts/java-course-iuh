package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<User> users = new ArrayList<>();

	public UserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String birthday = request.getParameter("birthday");
		String gender = request.getParameter("gender");
		System.out.println(firstName);
		User newUser = new User(firstName, lastName, email, birthday, gender);
		System.out.println(newUser.toString());
		users.add(newUser);

		request.setAttribute("users", users);
		request.getRequestDispatcher("listUserPage.jsp").forward(request, response);
		;
		doGet(request, response);
	}

}
