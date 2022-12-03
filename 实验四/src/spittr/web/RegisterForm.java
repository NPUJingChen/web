package spittr.web;

import spittr.domain.Spitter;

/**
 * 注册表单类，是作用view层的对象类，便于传递数据
 * 
 * @author wben
 * @version v1.0
 */
public class RegisterForm {

	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String passwordConfirm;
	private String email;

	/**
	 * 取得姓
	 * 
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * 设置姓
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * 取得名
	 * 
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * 设置名
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * 取得登录名
	 * 
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置登录名
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 取得密码
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置密码
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 取得密码确认
	 * 
	 * @return
	 */
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	/**
	 * 设置密码确认
	 * 
	 * @param passwordConfirm
	 */
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	/**
	 * 取得邮箱
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 设置邮箱
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 转换到吐槽者对象
	 * 
	 * @return
	 */
	public Spitter toSpitter() {
		return new Spitter(userName, password, firstName, lastName, email);
	}

}
