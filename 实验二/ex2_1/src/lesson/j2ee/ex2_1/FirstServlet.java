package lesson.j2ee.ex2_1;

import javax.servlet.http.*;
import java.io.*;

/**
 * @author chenjing
 */
public class FirstServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PrintWriter out = response.getWriter();
        java.util.Date today = new java.util.Date();
        out.println("<html> " + "<body>"
                + "<h1 align=center>My First Servlet</h1>" + "<br>"
                + today + "</body>" + "</html>");
    }
}