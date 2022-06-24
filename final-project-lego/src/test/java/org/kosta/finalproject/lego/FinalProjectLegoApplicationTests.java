package org.kosta.finalproject.lego;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kosta.finalproject.lego.mapper.MemberMapper;
import org.kosta.finalproject.lego.serivce.MemberMypageService;
import org.kosta.finalproject.lego.vo.CategoryVO;
import org.kosta.finalproject.lego.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootTest
class FinalProjectLegoApplicationTests {
	MemberMypageService memberService;
	MemberMapper memberMapper;
	
	@Autowired
	public FinalProjectLegoApplicationTests(MemberMapper memberMapper) {
		super();
		this.memberMapper = memberMapper;
	}

	@Test
	void contextLoads() {
	}
	
	@Test
	void category() {

		List<CategoryVO> list=memberMapper.getCategory();

		Assertions.assertNotNull(list);
	}
	@Test
	void updateMember() {
		String id="kosta@naver.com";
		String password="aa";
		String name="손석구석구";
		String address="서울";
		String tel="10048888888";
		MemberVO mvo=new MemberVO(id,password,name,address,tel);
		System.out.println(mvo);
		memberService.updateMember(mvo);
		System.out.println(mvo);
	}
}
