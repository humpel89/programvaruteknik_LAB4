package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletColectData
 */

//Är bara en test servlet som kanske kan användas

@WebServlet("/ServletColectData")
public class ServletCollectData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCollectData() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void prettyProcess( HttpServletRequest request){
    
    }
    protected void process() {
		
    	
	}
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean prettyRequest = Boolean.parseBoolean(request.getParameter("pretty"));
		if(prettyRequest){
			prettyProcess(request);
		}
		else{
			process();
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
