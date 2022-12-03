package spittr.db;

import java.util.List;

import spittr.domain.Spitter;

/**
 * 吐槽者资源库接口
 * 
 * @author wben
 * @version v1.0
 */
public interface SpitterRepository {

	/**
	 * 取得吐槽者数量
	 * 
	 * @return
	 */
	long count();

	/**
	 * 新建一个吐槽者
	 * 
	 * @param spitter
	 *            新建的吐槽者
	 * @return 吐槽者
	 */
	Spitter save(Spitter spitter);

	/**
	 * 依据id查找吐槽者
	 * 
	 * @param id
	 *            吐槽者ID
	 * @return 吐槽者
	 */
	Spitter findOne(long id);

	/**
	 * 依据用户名（登录名）查找吐槽者
	 * 
	 * @param userName
	 *            用户名（登录名）
	 * @return 吐槽者
	 */
	Spitter findByUserName(String userName);

	/**
	 * 依据用户名（登录名），密码查找吐槽者
	 * 
	 * @param userName
	 *            用户名（登录名）
	 * @param password
	 *            密码
	 * @return 吐槽者
	 */
	Spitter findByUserName(String userName, String password);

	/**
	 * 取得全部吐槽者
	 * 
	 * @return 全部吐槽者
	 */
	List<Spitter> findAll();

}
