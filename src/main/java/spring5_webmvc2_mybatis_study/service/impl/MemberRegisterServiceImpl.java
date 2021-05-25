package spring5_webmvc2_mybatis_study.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_webmvc2_mybatis_study.dto.Member;
import spring5_webmvc2_mybatis_study.dto.RegisterRequest;
import spring5_webmvc2_mybatis_study.exception.DupulicateMemberException;
import spring5_webmvc2_mybatis_study.mapper.MemberMapper;
import spring5_webmvc2_mybatis_study.service.MemberRegisterService;

@Service
public class MemberRegisterServiceImpl implements MemberRegisterService {
	@Autowired
	private MemberMapper memberMapper;

	public Long regist(RegisterRequest req) {
		Member member = memberMapper.selectByEmail(req.getEmail());
		if (member != null) {
			throw new DupulicateMemberException("dup email " + req.getEmail());
		}
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now());
		memberMapper.insertMember(newMember);
		return newMember.getId();
	}

}