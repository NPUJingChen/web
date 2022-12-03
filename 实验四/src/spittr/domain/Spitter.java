package spittr.domain;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 吐槽者对象类
 * 
 * @author wben
 * @version v1.0
 */
public class Spitter {

	private Long id;

	@NotNull
	@Size(min = 5, max = 16)
	private String userName;

	@NotNull
	@Size(min = 5, max = 25)
	private String password;

	@NotNull
	@Size(min = 2, max = 30)
	private String firstName;

	@NotNull
	@Size(min = 2, max = 30)
	private String lastName;

	@NotNull
	@Email
	private String email;

	public Spitter() {
	}

	/**
	 * 构造方法
	 * 
	 * @param userName
	 *            用户名（登录名）
	 * @param password
	 *            密码
	 * @param firstName
	 *            姓
	 * @param lastName
	 *            名
	 * @param email
	 *            邮箱
	 */
	public Spitter(String userName, String password, String firstName, String lastName, String email) {
		this(null, userName, password, firstName, lastName, email);
	}

	/**
	 * 构造方法
	 * 
	 * @param id
	 *            主键
	 * @param userName
	 *            用户名（登录名）
	 * @param password
	 *            密码
	 * @param firstName
	 *            姓
	 * @param lastName
	 *            名
	 * @param email
	 *            邮箱
	 */
	public Spitter(Long id, String userName, String password, String firstName, String lastName, String email) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	/**
	 * 取得用户名（登录名）
	 * 注意！当JSP页面采用${spitter.userName}调用一个对象的属性时，会调用此方法，必须严格按照命名规则具有此方法，
	 * 不然会报找不到方法。建议采用IDE工具自动生成
	 * 
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置用户名（登录名）
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
	 * 取得ID主键
	 * 
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置ID主键
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Spitter other = (Spitter) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	// @Override
	// public boolean equals(Object that) {
	// return EqualsBuilder.reflectionEquals(this, that, "firstName",
	// "lastName", "userName", "password", "email");
	// }

	// @Override
	// public int hashCode() {
	// return HashCodeBuilder.reflectionHashCode(this, "firstName", "lastName",
	// "userName", "password", "email");
	// }

}
