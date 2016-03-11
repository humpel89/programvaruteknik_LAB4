package testServlet;

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
public class ServletCollectData {
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
    public void testCommonCase() {
        System.out.println("Testing common case");
        Integer expResult = 22;
        when(request.getParameter("a")).thenReturn("12");
        when(request.getParameter("b")).thenReturn("10");
        try {
            instance.processRequest(request, response);
        } catch (IOException ex) {
            fail("Unexpected Exception thrown");
        }
        Integer result = Integer.parseInt(asMap().get("result").toString());
        assertEquals(expResult, result);
        System.out.println("Testing common case done");
    }
    
    @Test
    public void testMissingParameter() {
        System.out.println("Testing missing parameter");
        when(request.getParameter("a")).thenReturn("12");
        try {
            instance.doGet(request, response);
            fail("NumberFormatException not thrown");
        } catch (ServletException | IOException ex) {
            fail("Unexpected Exception thrown");
        } catch (NumberFormatException ex) {
            System.out.println("NumberFormatException thrown as expected");
        }
        System.out.println("Testing missing parameter done");
    }
}