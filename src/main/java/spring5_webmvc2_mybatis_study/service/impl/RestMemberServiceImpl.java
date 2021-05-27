package spring5_webmvc2_mybatis_study.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import spring5_webmvc2_mybatis_study.dto.Member;
import spring5_webmvc2_mybatis_study.mapper.MemberMapper;
import spring5_webmvc2_mybatis_study.service.RestMemberService;
@Configuration
@Service
public class RestMemberServiceImpl implements RestMemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public Member showById(Long memId) {
		return memberMapper.selectById(memId);
	}

	@Override
	public List<Member> showMembers() {
			return memberMapper.selectAll();
	}

}
