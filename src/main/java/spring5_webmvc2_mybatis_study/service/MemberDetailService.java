package spring5_webmvc2_mybatis_study.service;

import org.springframework.stereotype.Service;

import spring5_webmvc2_mybatis_study.dto.Member;

@Service
public interface MemberDetailService {

	Member showById(Long memId);
}
