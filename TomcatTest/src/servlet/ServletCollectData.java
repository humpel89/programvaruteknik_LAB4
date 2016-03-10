package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataHandler.DataSourcesToJsonConverter;
import dataHandler.JsonFormatter;

/**
 * Servlet implementation class ServletColectData
 */

// Är bara en test servlet som kanske kan användas

@WebServlet("/ServletColectData")
public class ServletCollectData extends HttpServlet {
	JsonFormatter formatter = new JsonFormatter();
	DataSourcesToJsonConverter jsonGetter = new DataSourcesToJsonConverter();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCollectData() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String result = jsonGetter.getString();
		
		if ("true".equalsIgnoreCase(request.getParameter("pretty"))) {
			
			 result = formatter.format(result);
			
		}
			
		
		response.getWriter().append(result);
		System.out.println(result);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
