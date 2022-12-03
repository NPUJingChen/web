package lesson.j2ee.ex2_1;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

/**
 * @author chenjing
 */
public class CodeReturn extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        response.setContentType("application/jar");
        ServletContext ctx = getServletContext();
        InputStream is = ctx.getResourceAsStream("/resources/bookCode.jar");
        int read = 0;
        byte[] bytes = new byte[1024];
        OutputStream os = response.getOutputStream();
        while ((read = is.read(bytes)) != -1) {
            os.write(bytes, 0, read);
        }
        os.flush();
        os.close();
    }

}
