package spittr.web;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 吐槽内容表单类，是作用view层的对象类，便于传递数据
 * 
 * @author wben
 * @version v1.0
 */
public class SpittleForm {

	@NotNull
	@Size(min = 1, max = 2000)
	private String message;

	/**
	 *  取得吐槽内容
	 * @return
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 设置吐槽内容
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
