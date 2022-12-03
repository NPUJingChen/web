package lesson.j2ee.ex3;

import java.io.IOException;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

/**
 * 计数标签
 *
 * @author chenjing
 *
 */
public class CounterTag extends SimpleTagSupport {

	private static int counter = 1;
	//重载doTag方法
	public void doTag() throws JspException, IOException{
		getJspContext().getOut().print(counter);
		counter++;
	}
}
