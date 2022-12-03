package lesson.j2ee.ex3;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

/**
 * 自定义选择标签
 * 
 * @author liyong
 *
 */
public class CreateSelectTag extends TagSupport {

	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			String outPrint = "";
			String[] color = { "light", "amber", "brown", "dark" };
			outPrint += "<select name='color' size='1'>";
			for (int i = 0; i < color.length; i++) {
				outPrint += "<option>";
				outPrint += color[i];
				outPrint += "</option>";
			}
			outPrint += "</select>";
			out.print(outPrint);
		} catch (java.io.IOException e) {
			throw new JspTagException(e.getMessage());
		}
		return SKIP_BODY;
	}
}
