package com.company.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.User;
import com.company.dao.UserDao;
import com.company.dao.UserDaoImpl;

@WebServlet("/Registerservlet")
public class Registerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDao usrDao= new UserDaoImpl();
       
    public Registerservlet() {
        super();
        System.out.println("Welcome Adil");
      
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        System.out.println(username+email+password+"Welcome Adil");
		if (usrDao.addUser(user)) {
            response.sendRedirect("login.jsp?registration=success");
        } else {
            response.sendRedirect("Register.jsp?error=1");

        }
    }
}