package fr.domiq.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@PropertySource(value = { "classpath:application.properties" })
@ComponentScan(basePackages = "fr.domiq")
public class MainConfig {

	@Autowired
	private Environment env;

	@Bean
	public DataSource getDataSource() {
		return new HikariDataSource(getHikariConfig());
	}

	@Bean
	public HikariConfig getHikariConfig() {
		HikariConfig config = new HikariConfig();

		config.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
		config.setJdbcUrl(env.getProperty("spring.datasource.jdbcUrl"));
		config.setUsername(env.getProperty("spring.datasource.username"));
		config.setPassword(env.getProperty("spring.datasource.password"));

		config.setPoolName(env.getProperty("spring.datasource.hikari.poolName"));
		config.setAutoCommit(Boolean.valueOf(env.getProperty("spring.datasource.hikari.autoCommit")));
		config.setMaximumPoolSize(Integer.valueOf(env.getProperty("spring.datasource.hikari.maximumPoolSize")));
		config.setLeakDetectionThreshold(Long.valueOf(env.getProperty("spring.datasource.hikari.leakDetectionThreshold")));
		config.setMinimumIdle(Integer.valueOf(env.getProperty("spring.datasource.hikari.minimumIdle")));
		config.setConnectionTestQuery(env.getProperty("spring.datasource.hikari.connectionTestQuery"));

		return config;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(getDataSource());
	}

	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
		return new NamedParameterJdbcTemplate(getDataSource());
	}

	@Bean
	public DataSourceTransactionManager getTransactionManager() {
		return new DataSourceTransactionManager(getDataSource());
	}
}