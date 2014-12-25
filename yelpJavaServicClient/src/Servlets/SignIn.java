package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Connection.ServiceProxy;
import Connection.UserDetails;

/**
 * Servlet implementation class SignIn
 */
@WebServlet("/View/SignIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServiceProxy proxy=new ServiceProxy();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session;
		UserDetails userDetails=new UserDetails();
		String email=request.getParameter("inputUsername");
		String pswd=request.getParameter("inputPassword");
	 	proxy.setEndpoint("http://localhost:8080/yelpJavaService/services/Service");
		userDetails=proxy.getUserDetails(email, pswd);
		String lastLoginTime = proxy.getLastLoginTime(email); 
	 	boolean valid = proxy.signIn(email, pswd);
		
		if(valid){
			System.out.println("Valid Successfully");
			session=request.getSession();
			session.setAttribute("fname",userDetails.getFname() );
			session.setAttribute("lname", userDetails.getLname());
			session.setAttribute("email",userDetails.getEmail() );
			session.setAttribute("pswd", userDetails.getPswd());
			session.setAttribute("time", lastLoginTime);
			
			RequestDispatcher dispatcher= request.getRequestDispatcher("details.jsp");
			dispatcher.include(request, response);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session;
		UserDetails userDetails=new UserDetails();
		String email=request.getParameter("inputUsername");
		String pswd=request.getParameter("inputPassword");
	 	proxy.setEndpoint("http://localhost:8080/yelpJavaService/services/Service");
		userDetails=proxy.getUserDetails(email, pswd);
		String lastLoginTime = proxy.getLastLoginTime(email); 
	 	boolean valid = proxy.signIn(email, pswd);
		
		if(valid){
			System.out.println("Valid Successfully");
			session=request.getSession();
			session.setAttribute("fname",userDetails.getFname() );
			session.setAttribute("lname", userDetails.getLname());
			session.setAttribute("email",userDetails.getEmail() );
			session.setAttribute("pswd", userDetails.getPswd());
			session.setAttribute("time", lastLoginTime);
			
			RequestDispatcher dispatcher= request.getRequestDispatcher("details.jsp");
			dispatcher.include(request, response);
		}
	}

}
