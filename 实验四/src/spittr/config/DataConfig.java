package spittr.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * 数据库配置
 * 
 * @author wben
 * @version v1.0
 */
@Configuration
public class DataConfig {

	/**
	 * 数据源设置，采用spring自带的内嵌数据库h2
	 * 
	 * @return
	 */
	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("schema.sql")
				.setScriptEncoding("UTF-8").build();
	}

	/**
	 * jdbc模板配置，采用spring默认的JdbcTemplate模板
	 * 
	 * @param dataSource
	 *            数据源
	 * @return
	 */
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

}
