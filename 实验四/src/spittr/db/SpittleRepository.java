package spittr.db;

import java.util.Date;
import java.util.List;

import spittr.domain.Spittle;
import spittr.web.PaginationSupport;

/**
 * 吐槽内容资源库接口
 * 
 * @author wben
 * @version v1.0
 */
public interface SpittleRepository {

	/**
	 * 取得吐槽数量
	 * 
	 * @return 吐槽数量
	 */
	long count();

	/**
	 * 依据页码和指定页面大小，返回吐槽列表
	 * @param pageNo 起始位置
	 * @param pageSize 每页数量
	 * @return 分页对象
	 */
	PaginationSupport<Spittle> findPage(int pageNo,int pageSize);

	/**
	 * 依据id查找吐槽
	 * 
	 * @param id
	 *            吐槽ID
	 * @return 吐槽
	 */
	Spittle findOne(long id);

	/**
	 * 新建一个吐槽
	 * 
	 * @param spittle
	 *            吐槽
	 * @return 以保存的吐槽
	 */
	Spittle save(Spittle spittle);

	/**
	 * 取得指定吐槽者的全部吐槽
	 * 
	 * @param spitterId
	 *            吐槽者ID
	 * @return 指定吐槽者的全部吐槽
	 */
	List<Spittle> findBySpitterId(long spitterId);

	/**
	 * 删除指定ID的吐槽
	 * 
	 * @param id
	 *            吐槽ID
	 */
	boolean updateSpittle(long checker_id, Date check_time, long id);

	void delete(long id);

}
