package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.Category;
import Connection.ServiceProxy;

/**
 * Servlet implementation class GetNames
 */
@WebServlet("/View/GetNames")
public class GetNames extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ServiceProxy proxy=new ServiceProxy();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetNames() {
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
	 	Category[] categoryNames=proxy.getCatNames(request.getParameter("category"));
	 	request.setAttribute("categoryNames", categoryNames);
		RequestDispatcher dispatcher= request.getRequestDispatcher("details.jsp");
		dispatcher.include(request, response);
	}

}
