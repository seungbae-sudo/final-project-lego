package org.kosta.finalproject.lego;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kosta.finalproject.lego.mapper.MemberMapper;
import org.kosta.finalproject.lego.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FinalProjectLegoApplicationTests {
	
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
}
