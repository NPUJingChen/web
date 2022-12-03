package lesson.j2ee.ex3;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author chenjing
 */
public class ShoppingCartTag extends SimpleTagSupport {
    public void doTag() throws JspException, IOException {
        // 取得Session对象
        // 如果Session不存在，为本次会话创建此对象
        HttpSession session = ((PageContext)getJspContext()).getSession();
        Integer itemCount = (Integer) session.getAttribute("itemCount");
        // 如果session是新的
        if (itemCount == null)
            itemCount = new Integer(0);

        PrintWriter out = ((PageContext)getJspContext()).getResponse().getWriter();
        ((PageContext)getJspContext()).getResponse().setContentType("text/html");

        // 接收传来的参数
        String[] itemsSelected;
        String itemName;
        itemsSelected = ((PageContext)getJspContext()).getRequest().getParameterValues("item");

        if (itemsSelected != null) {
            for (int i = 0; i < itemsSelected.length; i++) {
                itemName = itemsSelected[i];
                System.out.println(itemName);
                itemCount = new Integer(itemCount.intValue() + 1);
                // 购买的条目
                session.setAttribute("item" + itemCount, itemName);
                // 总条目
                session.setAttribute("itemCount", itemCount);
            }
        }

        out.println("<html>");
        out.println("<title>");
        out.println("item list");
        out.println("</title>");
        out.println("<body><h4>Session List:</h4><hr><br><br>");
        for (int i = 1; i <= itemCount.intValue(); i++) {
            out.println((String) session.getAttribute("item" + i) + "<hr>");
        }
        out.println("</body>");
        out.println("</html>");
        out.close();
        }
    }

