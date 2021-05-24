package spring5_webmvc2_mybatis_study.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

//DB연결용
@Configuration
@EnableTransactionManagement
public class ContextDataSource {

	@Bean(destroyMethod = "close")
	   public DataSource dataSource() {
	      HikariConfig hikariConfig = new HikariConfig();
	      hikariConfig.setDriverClassName("com.mysql.jdbc.Driver");
	      hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/spring5?useSSL=false");
	      hikariConfig.setUsername("user_spring5");
	      hikariConfig.setPassword("rootroot");

	      hikariConfig.setMaximumPoolSize(5);
	      hikariConfig.setPoolName("springHikariCP");

	      hikariConfig.addDataSourceProperty("dataSource.cachePrepStmts", "true");
	      hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSize", "250");
	      hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", "2048");
	      hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts", "true");

	      HikariDataSource dataSource = new HikariDataSource(hikariConfig);

	      return dataSource;
	   }
	
//	@Bean(destroyMethod = "close")
//	public DataSource dataSource() {
//		HikariDataSource dataSource = null;
//		try {
//			Properties prop = Resources.getResourceAsProperties("application.properties");
//			HikariConfig cfg = new HikariConfig(prop);
//			dataSource = new HikariDataSource(cfg);
//			dataSource.setMinimumIdle(10);
//			dataSource.setMaximumPoolSize(100);
//		}catch (IOException e) {
//			e.printStackTrace();
//		}
//		return dataSource();
//	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
}
