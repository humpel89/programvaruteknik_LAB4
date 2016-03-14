package servlet;

import com.owlike.genson.Genson;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import static org.mockito.Mockito.*;

/**
 *
 * @author thomas
 */
public class ServletCollectDataTest {
    ServletCollectData instance;
    HttpServletRequest request;
    HttpServletResponse response;
    StringWriter resultingWriter = new StringWriter();
    
    private Map<String, Object> asMap() {
        return new Genson().deserialize(resultingWriter.toString(), Map.class);
    }
    
    @Before
    public void setupTest() {
        instance = new ServletCollectData();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        try {
            when(response.getWriter()).thenReturn(new PrintWriter(resultingWriter));
        } catch (IOException ex) {
            fail("Unexpected Exception thrown");
        }
    }

    @Test
    public void testPrettyIsTrue() throws ServletException {
    	runTestWithParameter("true", "testTrueParameter");
    }
    
    @Test
    public void testEmptyParameter() {
    	runTestWithParameter("", "testEmptyParameter");
    }
    
    @Test
    public void testNullParameter() {
        runTestWithParameter(null, "testNullParameter");
    }

	private void runTestWithParameter(String pretty, String testTypeMessage) {
		System.out.println(testTypeMessage + "...");
        when(request.getParameter("pretty")).thenReturn(null);
        try {
            instance.doGet(request, response);
            } catch (ServletException | IOException ex) {
            fail("Unexpected Exception thrown");
        }
        System.out.println(testTypeMessage + ": done.");
	}

}