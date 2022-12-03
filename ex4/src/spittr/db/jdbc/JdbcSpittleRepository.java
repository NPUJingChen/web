package spittr.db.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import spittr.db.SpittleRepository;
import spittr.domain.Spitter;
import spittr.domain.Spittle;

/**
 * 吐槽内容资源库接口的jdbc实现类
 * 
 * @author wben
 * @version v1.0
 */
// 注解类作为DAO对象（数据访问对象，Data Access Objects），这些类可以直接对数据库进行操作
// 有这些分层操作的话，代码之间就实现了松耦合，代码之间的调用也清晰明朗，便于项目的管理；
@Repository
public class JdbcSpittleRepository implements SpittleRepository {

	private JdbcTemplate jdbc;

	@Autowired
	public JdbcSpittleRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public long count() {
		return jdbc.queryForLong("select count(id) from Spittle");
	}

	@Override
	public List<Spittle> findRecent() {
		return findRecent(10);
	}

	@Override
	public List<Spittle> findRecent(int count) {
		return jdbc.query(SELECT_RECENT_SPITTLES, new SpittleRowMapper(), count);
	}

	@Override
	public Spittle findOne(long id) {
		try {
			return jdbc.queryForObject(SELECT_SPITTLE_BY_ID, new SpittleRowMapper(), id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Spittle> findBySpitterId(long spitterId) {
		return jdbc.query(SELECT_SPITTLES_BY_SPITTER_ID, new SpittleRowMapper(), spitterId);
	}

	@Override
	public Spittle save(Spittle spittle) {
		long spittleId = insertSpittleAndReturnId(spittle);
		return new Spittle(spittleId, spittle.getSpitter(), spittle.getMessage(), spittle.getPostedTime());
	}

	private long insertSpittleAndReturnId(Spittle spittle) {
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbc).withTableName("Spittle");
		jdbcInsert.setGeneratedKeyName("id");
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("spitter", spittle.getSpitter().getId());
		args.put("message", spittle.getMessage());
		args.put("postedTime", spittle.getPostedTime());
		long spittleId = jdbcInsert.executeAndReturnKey(args).longValue();
		return spittleId;
	}

	@Override
	public void delete(long id) {
		jdbc.update("delete from Spittle where id=?", id);
	}

	private static final class SpittleRowMapper implements RowMapper<Spittle> {
		public Spittle mapRow(ResultSet rs, int rowNum) throws SQLException {
			long id = rs.getLong("id");
			String message = rs.getString("message");
			Date postedTime = rs.getTimestamp("postedTime");
			long spitterId = rs.getLong("spitterId");
			String userName = rs.getString("username");
			String password = rs.getString("password");
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			String email = rs.getString("email");
			Spitter spitter = new Spitter(spitterId, userName, password, firstName, lastName, email);
			return new Spittle(id, spitter, message, postedTime);
		}
	}

	private static final String SELECT_SPITTLE = "select sp.id, s.id as spitterId, s.username, s.password, s.first_name, s.last_name, s.email, sp.message, sp.postedTime from Spittle sp, Spitter s where sp.spitter = s.id";
	private static final String SELECT_SPITTLE_BY_ID = SELECT_SPITTLE + " and sp.id=?";
	private static final String SELECT_SPITTLES_BY_SPITTER_ID = SELECT_SPITTLE
			+ " and s.id=? order by sp.postedTime desc";
	private static final String SELECT_RECENT_SPITTLES = SELECT_SPITTLE + " order by sp.postedTime desc limit ?";
}
