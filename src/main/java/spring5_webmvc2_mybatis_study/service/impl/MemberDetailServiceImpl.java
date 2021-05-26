package spring5_webmvc2_mybatis_study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_webmvc2_mybatis_study.dto.Member;
import spring5_webmvc2_mybatis_study.mapper.MemberMapper;
import spring5_webmvc2_mybatis_study.service.MemberDetailService;

@Service
public class MemberDetailServiceImpl implements MemberDetailService{

	@Autowired
	private MemberMapper memberMapper;

	@Override
	public Member showById(Long memId) {
		return memberMapper.selectById(memId);
	}
	
	
}
