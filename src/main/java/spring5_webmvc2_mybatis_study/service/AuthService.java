package spring5_webmvc2_mybatis_study.service;

import org.springframework.stereotype.Service;

import spring5_webmvc2_mybatis_study.dto.AuthInfo;

@Service
public interface AuthService {
	
    AuthInfo authenicate(String email, String password);

}
