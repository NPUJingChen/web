package spittr.db.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spittr.db.SpitterRepository;
import spittr.domain.Spitter;

/**
 * 吐槽者资源库接口的jdbc实现类
 * 
 * @author wben
 * @version v1.0
 */
// 注解类作为DAO对象（数据访问对象，Data Access Objects），这些类可以直接对数据库进行操作
// 有这些分层操作的话，代码之间就实现了松耦合，代码之间的调用也清晰明朗，便于项目的管理；
@Repository
public class JdbcSpitterRepository implements SpitterRepository {

	private JdbcTemplate jdbc;

	@Autowired
	public JdbcSpitterRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public Spitter save(Spitter spitter) {
		jdbc.update(INSERT_SPITTER, spitter.getUserName(), spitter.getPassword(), spitter.getFirstName(),
				spitter.getLastName(), spitter.getEmail());
		return spitter;
	}

	@Override
	public Spitter findByUserName(String userName) {
		Spitter spitter = null;
		try {
			spitter = jdbc.queryForObject(SELECT_SPITTER + " where username=?", new SpitterRowMapper(), userName);
		} catch (DataAccessException e) {
		}
		return spitter;
	}

	@Override
	public Spitter findByUserName(String userName, String password) {
		Spitter spitter = null;
		try {
			spitter = jdbc.queryForObject(SELECT_SPITTER + " where username=? and password=?", new SpitterRowMapper(),
					userName, password);
		} catch (DataAccessException e) {
		}
		return spitter;
	}

	@Override
	public long count() {
		return jdbc.queryForLong("select count(id) from Spitter");
	}

	@Override
	public Spitter findOne(long id) {
		Spitter spitter = null;
		try {
			spitter = jdbc.queryForObject(SELECT_SPITTER + " where id=?", new SpitterRowMapper(), id);
		} catch (DataAccessException e) {
		}
		return spitter;
	}

	@Override
	public List<Spitter> findAll() {
		return jdbc.query(SELECT_SPITTER + " order by id", new SpitterRowMapper());
	}

	private static class SpitterRowMapper implements RowMapper<Spitter> {
		public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Spitter(rs.getLong("id"), rs.getString("username"), null, rs.getString("first_name"),
					rs.getString("last_name"), rs.getString("email"));
		}
	}

	private static final String INSERT_SPITTER = "insert into Spitter (username, password, first_name, last_name, email) values (?, ?, ?, ?, ?)";

	private static final String SELECT_SPITTER = "select id, username, first_name, last_name, email from Spitter";

}
