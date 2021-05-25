package spring5_webmvc2_mybatis_study.service;

import org.springframework.stereotype.Service;

import spring5_webmvc2_mybatis_study.dto.RegisterRequest;

@Service
public interface MemberRegisterService {

	Long regist(RegisterRequest req);

}
