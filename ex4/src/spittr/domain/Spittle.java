package spittr.domain;

import java.util.Date;

/**
 * 吐槽内容对象类
 * 
 * @author wben
 * @version v1.0
 */
public class Spittle {

	private final Long id;
	private final Spitter spitter;
	private final String message;
	private final Date postedTime;

	/**
	 * 构造方法
	 * 
	 * @param id
	 *            ID主键
	 * @param spitter
	 *            吐槽者
	 * @param message
	 *            内容
	 * @param postedTime
	 *            提交时间
	 */
	public Spittle(Long id, Spitter spitter, String message, Date postedTime) {
		this.id = id;
		this.spitter = spitter;
		this.message = message;
		this.postedTime = postedTime;
	}

	/**
	 * 取得id主键
	 * 
	 * @return
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * 取得吐槽内容
	 * 
	 * @return
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * 取得提交时间
	 * 
	 * @return
	 */
	public Date getPostedTime() {
		return this.postedTime;
	}

	/**
	 * 取得吐槽者
	 * 
	 * @return
	 */
	public Spitter getSpitter() {
		return this.spitter;
	}

}
