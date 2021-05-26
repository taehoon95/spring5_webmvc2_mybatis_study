package spring5_webmvc2_mybatis_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import spring5_webmvc2_mybatis_study.dto.Member;
import spring5_webmvc2_mybatis_study.exception.MemberNotFoundException;
import spring5_webmvc2_mybatis_study.mapper.MemberMapper;
import spring5_webmvc2_mybatis_study.service.MemberDetailService;

@Controller
public class MemberDetailController {
	@Autowired
	private MemberDetailService memberDetailService;
	
	@GetMapping("/members/{id}")
	public ModelAndView detail(@PathVariable("id") Long memId) {
		Member member = memberDetailService.showById(memId);
		if(member == null) {
			throw new MemberNotFoundException();
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("member", member);
		mav.setViewName("member/memberDetail");
		return mav;
	}
}
