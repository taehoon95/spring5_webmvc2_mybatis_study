package spring5_webmvc2_mybatis_study.service;

import java.util.List;

import org.springframework.stereotype.Service;

import spring5_webmvc2_mybatis_study.dto.Member;

@Service
public interface RestMemberService{

	Member showById(Long memId);
	
	List<Member> showMembers();
}
