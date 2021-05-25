package spring5_webmvc2_mybatis_study.service;

import org.springframework.stereotype.Service;

@Service
public interface ChangePasswordService {

	void changePassword(String email, String oldPwd, String newPwd);
}
