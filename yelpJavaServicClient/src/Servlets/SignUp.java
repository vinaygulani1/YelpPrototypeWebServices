package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Connection.ServiceProxy;

/**
 * Servlet implementation class SignUp
 */
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServiceProxy proxy=new ServiceProxy();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
	 
		 try{			
			 	String fname = request.getParameter("fname");
			 	String lname = request.getParameter("lname");
			 	String email = request.getParameter("email");
			 	String pswd = request.getParameter("pswd");
			 	String time=time();
			 	proxy.setEndpoint("http://localhost:8080/yelpJavaService/services/Service");
				boolean validateSignup = proxy.signUp(fname,lname,email,pswd);
				proxy.insertLastLoginTime(email, time);
				HttpSession session = request.getSession();
				System.out.println("Valid Successfully");
				session=request.getSession();
				session.setAttribute("fname",fname );
				session.setAttribute("lname", lname);
				session.setAttribute("email",email );
				session.setAttribute("pswd", pswd);
				session.setAttribute("time", time);
				
				
				RequestDispatcher dispatcher= request.getRequestDispatcher("details.jsp");
				dispatcher.include(request, response);
		 }
		 catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	}

	public String time(){	
		Date currentdate = new Date(); 
		int year=currentdate.getYear()+1900;
		String datetime = "Last login time: " + currentdate.getDate() + "/"
	                + (currentdate.getMonth()+1)  + "/" 
	                + year + " @ "  
	                + currentdate.getHours() + ":"  
	                + currentdate.getMinutes() + ":" 
	                + currentdate.getSeconds();
		System.out.println(datetime);
	return datetime;
	}
}
