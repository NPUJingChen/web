package spittr.db.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import spittr.db.ManagerRepository;
import spittr.domain.Manager;
import spittr.domain.Spitter;
import spittr.web.PaginationSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 管理员资源库接口的jdbc实现类
 * @author chenjing
 */
@Repository
public  class JdbcManagerRepository implements ManagerRepository {


    private JdbcTemplate jdbc;

    @Autowired
    public JdbcManagerRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }
    @Override
    public Manager save(Manager manager){
        jdbc.update(INSERT_MANGER, manager.getUserName(), manager.getPassword(), manager.getFullName(),
                manager.getEmail(), manager.getPhoneNo());
        return manager;
    }



    @Override
    public Manager findByUserName(String userName) {
        Manager manager = null;
        try{
            manager = jdbc.queryForObject(SELECT_MANGER + " where userName=?", new ManagerRowMapper(),userName);

        }catch (DataAccessException e){

        }
        return manager;
    }
    @Override
    public Manager findByUserName(String userName, String password){
        Manager manager = null;
        try{
            manager = jdbc.queryForObject(SELECT_MANGER + " where userName=? and password=?", new ManagerRowMapper(),
                    userName,password);
        }catch (DataAccessException e){

        }
        return manager;
    }

    @Override
    public List<Manager> findAll() {
        return jdbc.query(SELECT_MANGER + " order by id", new ManagerRowMapper());
    }


    @Override
    public long count(){
        return jdbc.queryForLong("select count (id) from Manager");
    }

    @Override
    public Manager findOne(long id) {
        Manager manager = null;
        try{
            manager = jdbc.queryForObject(SELECT_MANGER + " where id=?", new ManagerRowMapper(),id);
        }catch (DataAccessException e){

        }
        return manager;
    }

    @Override
    public PaginationSupport<Manager> findPage(int pageNo, int pageSize){
        int totalCount = (int) count();
        int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize);
        if (totalCount < 1)
            return new PaginationSupport<Manager>(new ArrayList<Manager>(0), 0);

        List<Manager> items = jdbc.query(SELECT_PAGE_MANAGER, new JdbcManagerRepository.ManagerRowMapper(), pageSize, startIndex);
        PaginationSupport<Manager> ps = new PaginationSupport<Manager>(items, totalCount, pageSize, startIndex);
        return ps;
    }

    public boolean updatePasswd(String username, String password, String email,String phoneNo) {
        return jdbc.update(UPDATE_MANAGER, password, email, phoneNo, username) != 0;
    }

    public boolean DeleteM(String username, int isDelete) {
        return jdbc.update(DELETE_MANAGER, isDelete,username) != 0;
    }


    private static class ManagerRowMapper implements RowMapper<Manager>{
        public Manager mapRow(ResultSet rs, int rowNum) throws SQLException{
            return new Manager(rs.getLong("id"), rs.getString("userName"), null, rs.getString("fullName"),
                    rs.getString("email"),rs.getString("phoneNo"),rs.getInt("isDelete"));
        }
    }

    private static class SpitterRowMapper implements RowMapper<Spitter> {
        public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Spitter(rs.getLong("id"), rs.getString("username"), null, rs.getString("first_name"),
                    rs.getString("last_name"), rs.getString("email"));
        }
    }

    private static final String INSERT_MANGER = "insert into Manager(userName,password,fullName,email,phoneNo,isDelete) values (?, ?, ?, ?, ?, 1)";
    private static final Object SELECT_MANGER = "select id, userName, fullName, email, phoneNo, isDelete from Manager";
    private static final String UPDATE_MANAGER = "update Manager set password = ?,email = ?,phoneNo = ? where userName = ?";
    private static final String SELECT_PAGE_MANAGER = SELECT_MANGER + " order by id  limit ? offset  ?";
    private static final String DELETE_MANAGER = "update Manager set isDelete = ? where userName = ?";

}
