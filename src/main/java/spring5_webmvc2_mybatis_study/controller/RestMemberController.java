package spring5_webmvc2_mybatis_study.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import spring5_webmvc2_mybatis_study.dto.Member;
import spring5_webmvc2_mybatis_study.service.MemberDetailService;
import spring5_webmvc2_mybatis_study.service.MemberListService;

@RestController
public class RestMemberController {

	@Autowired
	private MemberDetailService memberService;
	
	@GetMapping("/api/members")
	public List<Member> members(){
		return memberService.showMembers();
	}
	
	@GetMapping("/api/members/{id}")
	public Member member(@PathVariable Long id, HttpServletResponse response) throws IOException{
		Member member = memberService.showById(id);
		if(member == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return member;
	}
	
}
