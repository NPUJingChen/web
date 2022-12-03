package spittr.db;

import spittr.domain.Manager;
import spittr.web.PaginationSupport;

import java.util.List;

/**
 * 管理员资源库接口
 *
 * @author chenjing
 *
 */

public interface ManagerRepository {

    /**
     *获得管理员数量
     * @return
     */
    long count();

    /**
     * 新建一个管理员
     *
     * @param manager
     *              新建的管理员
     *
     * @return 管理员
     */
    Manager save(Manager manager);

    /**
     * 依据id查找管理员
     *
     * @param id
     *          管理员id
     * @return 管理员
     */
    Manager findOne(long id);

    /**
     * 依据管理员的登录名来查找管理员
     * @param userName
     *              登录名
     * @return 管理员
     */
    Manager findByUserName(String userName);

    /**
     * 依据用户名和密码来查找管理员
     * @param userName
     * @param password
     * @return 管理员
     */
    Manager findByUserName(String userName, String password);

    PaginationSupport<Manager> findPage(int pageNo, int pageSize);


    boolean updatePasswd(String username, String password, String email, String phoneNo);

    boolean DeleteM(String username, int isDelete);

    /**
     * 获取全部管理员
     *
     * @return 全部管理员
     */
    List<Manager> findAll();



}
