package spring5_webmvc2_mybatis_study.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//controll용
@Configuration
@ComponentScan(basePackages = {"spring5_webmvc2_mybatis_study.controller"
													  , "spring5_webmvc2_mybatis_study.service"
                                               		  , "spring5_webmvc2_mybatis_study.mapper"
                                               		  })
public class ControllerConfig {
	
}
