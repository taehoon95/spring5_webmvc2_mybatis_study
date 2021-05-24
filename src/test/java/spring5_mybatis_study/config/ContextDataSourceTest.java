package spring5_mybatis_study.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import spring5_webmvc2_mybatis_study.config.ContextRoot;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ContextRoot.class})
public class ContextDataSourceTest {

	
	//@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testDataSource() throws SQLException {
		System.out.println(dataSource);
	
	}

}
