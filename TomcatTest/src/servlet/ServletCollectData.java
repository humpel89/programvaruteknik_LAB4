package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataHandler.DataSourcesToJsonConverter;
import dataHandler.PrettyJsonFormatter;

/**
 * Servlet implementation class ServletColectData
 */

@WebServlet("/ServletCollectData")
public class ServletCollectData extends HttpServlet {
	PrettyJsonFormatter formatter = new PrettyJsonFormatter();
	DataSourcesToJsonConverter jsonGetter = new DataSourcesToJsonConverter();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCollectData() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String result = jsonGetter.getString();

		if ("true".equalsIgnoreCase(request.getParameter("pretty"))) {

			result = formatter.format(result);
		}

		response.getWriter().append(result);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
