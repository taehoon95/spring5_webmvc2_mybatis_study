package spring5_webmvc2_mybatis_study.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import spring5_webmvc2_mybatis_study.dto.ListCommand;
import spring5_webmvc2_mybatis_study.dto.Member;

@Component
public interface MemberMapper {

	Member selectByEmail(String email);
	
	List<Member> selectAll();
	
	int insertMember(Member member);
	
	int deleteMember(Member member);
	
	int updateMember(Member member);
	
	int countMember();
	
	List<Member> selectByRegdate(ListCommand listCommand);
	
	Member selectById(Long memId);
}
