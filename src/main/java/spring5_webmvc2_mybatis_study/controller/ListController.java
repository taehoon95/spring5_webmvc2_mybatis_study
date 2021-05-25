package spring5_webmvc2_mybatis_study.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import spring5_webmvc2_mybatis_study.dto.ListCommand;
import spring5_webmvc2_mybatis_study.dto.Member;
import spring5_webmvc2_mybatis_study.mapper.MemberMapper;

@Controller
public class ListController {

	@Autowired
	private MemberMapper memberMapper;
	
	@RequestMapping("/members")
	public String list(@Valid @ModelAttribute("cmd") ListCommand listCommand,Errors errors , Model model) {
		if(errors.hasErrors()) {
			return "member/memberList";
		}
		if(listCommand.getFrom() != null & listCommand.getTo() != null) {
			List<Member> members = memberMapper.selectByRegdate(listCommand);
			model.addAttribute("members", members);
		}
		return "member/memberList";
	}
}
