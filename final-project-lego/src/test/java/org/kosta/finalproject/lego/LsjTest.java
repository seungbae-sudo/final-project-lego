package org.kosta.finalproject.lego;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kosta.finalproject.lego.mapper.CommunityBoardMapper;
import org.kosta.finalproject.lego.serivce.MemberService;
import org.kosta.finalproject.lego.vo.BoardCategoryVO;
import org.kosta.finalproject.lego.vo.BoardVO;
import org.kosta.finalproject.lego.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class LsjTest {

	CommunityBoardMapper communityBoardMapper;

	@Autowired
	public LsjTest(CommunityBoardMapper communityBoardMapper) {
		super();
		this.communityBoardMapper = communityBoardMapper;
	}

	@Test
	void posting() {
		BoardVO bvo = new BoardVO();

		MemberVO mvo = new MemberVO();
		mvo.setId("mac@naver.com");
		mvo.setPassword("a");
		mvo.setName("맥규");
		mvo.setAddress("신림");
		mvo.setTel("0518");

		BoardCategoryVO bcvo = new BoardCategoryVO();
		bcvo = communityBoardMapper.findBCVO(1);

		bvo.setBoardNo(111);
		bvo.setBoardTitle("왜 안되는걸까요");
		bvo.setBoardContent("제발 알려주세요 제발");
		bvo.setBoardDate("날짜입니다");
		bvo.setBcvo(bcvo);
		bvo.setMvo(mvo);

		System.out.println(bvo);

		communityBoardMapper.posting(bvo); // Assertions.assertNotEquals(1, result);
	}

	/*
	 * @Test void list() { List<BoardVO> list =
	 * communityBoardMapper.findAllCommunityList(1); Assertions.assertEquals(11,
	 * list.size()); }
	 */

	@Test
	void findDetail() {

		int boardNo = 3;
		BoardVO bvo = communityBoardMapper.findBoardDetailByBoardNo(boardNo);
		System.out.println(bvo);
		Assertions.assertNotNull(bvo);
	}

}
