package spring5_webmvc2_mybatis_study.mapper;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import spring5_webmvc2_mybatis_study.config.ContextRoot;
import spring5_webmvc2_mybatis_study.dto.ListCommand;
import spring5_webmvc2_mybatis_study.dto.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ContextRoot.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
public class MemberDaoTest {
	
	@Autowired
	private MemberMapper mapper;
	 
	//@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	//@Test
	public void test01selectAll() {
		System.out.println("test01selectAll");
		List<Member> list = mapper.selectAll();
		list.stream().forEach(System.out::println);
		Assert.assertNotNull(list);
	}

	//@Test
	public void test02insertMember() {
		System.out.println("test02insertMember");
		Member addMember = new Member("22@22.co.kr", "123", "test");
		int res = mapper.insertMember(addMember);
		Assert.assertEquals(1,res);
		System.out.println(addMember);
	}
	
	//@Test
	public void test03selectMemberByEmail() {
		System.out.println("test03selectMemberByEmail");
		Member addMember = mapper.selectByEmail("22@22.co.kr");
		Assert.assertNotNull(addMember);
	}
	
	//@Test
	public void test05CountMember() {
		System.out.println("test05CountMember");
		int res = mapper.countMember();
		Assert.assertNotEquals(-1, res);
		System.out.println(res);
	}
	
	//@Test
	public void test04UpdateMember() {
		System.out.println("test04UpdateMember");
		Member member = new Member("22@22.co.kr", "222", "2222");
		int res = mapper.updateMember(member);
		Assert.assertEquals(1,res);
	}
	
	//@Test
	public void test06DeleteMember() {
		System.out.println("test06DeleteMember");
		Member member = new Member();
		member.setEmail("22@22.co.kr");
		int res = mapper.deleteMember(member);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test07SelectMemberByDate() {
		ListCommand listCommand = new ListCommand();
		LocalDateTime from = LocalDateTime.of(2021, 5, 20, 00, 00);
		LocalDateTime to = LocalDateTime.of(2021, 5, 25, 00, 00);
		listCommand.setFrom(from);
		listCommand.setTo(to);
		List<Member> list = mapper.selectByRegdate(listCommand);
		Assert.assertNotNull(list);
		System.out.println(list);
	}
}
