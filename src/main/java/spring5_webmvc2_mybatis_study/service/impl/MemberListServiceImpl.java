package spring5_webmvc2_mybatis_study.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_webmvc2_mybatis_study.dto.ListCommand;
import spring5_webmvc2_mybatis_study.dto.Member;
import spring5_webmvc2_mybatis_study.mapper.MemberMapper;
import spring5_webmvc2_mybatis_study.service.MemberListService;

@Service
public class MemberListServiceImpl implements MemberListService {
	@Autowired
    private MemberMapper memberMapper;
	
	@Override
	public List<Member> showMemberByRegdate(ListCommand listCommand) {
		return memberMapper.selectByRegdate(listCommand);
	}



}
