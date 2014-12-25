package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.Review;
import Connection.ServiceProxy;

/**
 * Servlet implementation class ShowAllReview
 */
@WebServlet("/View/ShowAllReview")
public class ShowAllReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServiceProxy proxy=new ServiceProxy(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllReview() {
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
	 	Review[] reviews=proxy.getAllReviews(request.getParameter("name1"));
	 	request.setAttribute("reviews", reviews);
		RequestDispatcher dispatcher= request.getRequestDispatcher("details.jsp");
		dispatcher.include(request, response);
	}

}
