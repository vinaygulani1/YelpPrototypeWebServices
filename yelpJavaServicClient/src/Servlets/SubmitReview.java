package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Connection.Review;
import Connection.ServiceProxy;

/**
 * Servlet implementation class SubmitReview
 */
@WebServlet("/View/SubmitReview")
public class SubmitReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServiceProxy proxy=new ServiceProxy();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitReview() {
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
		String category=request.getParameter("category");
		String name=request.getParameter("name");
		String description=request.getParameter("description");
		String rating=request.getParameter("rating");
		String review=request.getParameter("review");
		HttpSession session= request.getSession();
		proxy.setEndpoint("http://localhost:8080/yelpJavaService/services/Service");
		try{
		boolean isCategoryExists = 	proxy.isCategoryExists(category, name);
		if(!isCategoryExists){
			proxy.insertCategoryName(category, name);
			}
			proxy.insertReview(name, rating,review, (String)session.getAttribute("fname"), (String)session.getAttribute("lname"), description);
		}
	catch(Exception e){
		e.printStackTrace();
		System.out.println("Exception Occured");
	}
		Review reviews[]= proxy.getUserReviews((String)session.getAttribute("fname"), (String)session.getAttribute("lname"));
	 	request.setAttribute("reviews", reviews);
		RequestDispatcher dispatcher= request.getRequestDispatcher("showReview.jsp");
		dispatcher.include(request, response);
	}

}
