package Servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Connection.ServiceProxy;

/**
 * Servlet implementation class SignOut
 */
@WebServlet("/View/SignOut")
public class SignOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServiceProxy proxy=new ServiceProxy(); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		proxy.setEndpoint("http://localhost:8080/yelpJavaService/services/Service");
		HttpSession session= request.getSession();
		session.getAttribute("email");
		String email=(String) session.getAttribute("email");
		String datetime=time();
		proxy.updateLastLoginTime(email, datetime);
		RequestDispatcher dispatcher= request.getRequestDispatcher("signout.jsp");
		dispatcher.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
