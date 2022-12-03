package lesson.j2ee.ex3;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author chenjing
 */
public class ColorSort extends SimpleTagSupport {

    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        HttpSession session = ((PageContext)getJspContext()).getSession();
        String sessionList = (String)session.getAttribute("sessionList");
//        System.out.println(sessionList);
        StringTokenizer tokenizer = new StringTokenizer(sessionList, ", ");
        Map<String, Integer> hash = new HashMap<>();
        while (tokenizer.hasMoreTokens()) {
            String s = tokenizer.nextToken();
            if (!hash.containsKey(s)) {
                hash.put(s, 0);
            }
            hash.put(s, hash.get(s) + 1);
        }
        for (String s : hash.keySet()) {
            out.write(s + ": " + hash.get(s) + "<hr>");
        }
    }
}
