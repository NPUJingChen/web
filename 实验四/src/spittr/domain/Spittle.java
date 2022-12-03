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
	private final String ischecked;
	private final Long checker_id;
	private final Date check_time;

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
	public Spittle(Long id, Spitter spitter, String message, Date postedTime,String ischecked,Long checker_id,Date check_time) {
		this.id = id;
		this.spitter = spitter;
		this.message = message;
		this.postedTime = postedTime;
		this.ischecked = ischecked;
		this.checker_id = checker_id;
		this.check_time = check_time;
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
	public Date getCheck_time(){
		return this.check_time;
	}
	public String getIschecked(){
		return this.ischecked;
	}
	public Long getChecker_id(){
		return this.checker_id;
	}

	public Spitter getSpitter() {
		return this.spitter;
	}

}
