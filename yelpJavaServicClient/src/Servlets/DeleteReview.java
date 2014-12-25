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

/**
 * Servlet implementation class DeleteReview
 */
@WebServlet("/View/DeleteReview")
public class DeleteReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServiceProxy proxy=new ServiceProxy();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteReview() {
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
		// TODO Auto-generated method stub
		proxy.setEndpoint("http://localhost:8080/yelpJavaService/services/Service");
		HttpSession session= request.getSession();
		String fname=(String)session.getAttribute("fname");
		String lname=(String)session.getAttribute("lname");
		String name=request.getParameter("name");
		boolean validateDelete=proxy.deleteReview(fname, lname, name);
		
		System.out.println("Delete Done "+ validateDelete);
		RequestDispatcher dispatcher= request.getRequestDispatcher("showReview.jsp");
		dispatcher.include(request, response);
	}

}
