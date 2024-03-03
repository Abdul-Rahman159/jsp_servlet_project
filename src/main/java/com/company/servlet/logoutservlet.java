package com.company.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logoutservlet")
public class logoutservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logoutservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                        System.out.print("Call toh ho raha hai bhai");
                        HttpSession session = request.getSession(false);
                        if(session!=null) {
                        	session.removeAttribute("username");
                        session.invalidate();    
                        request.logout();
                        response.sendRedirect("index.html");
                        }else {
                        	 response.sendRedirect("login.jsp");
                        }
	      
}

}
