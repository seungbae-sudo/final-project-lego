package org.kosta.finalproject.lego.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.finalproject.lego.vo.BoardVO;
import org.kosta.finalproject.lego.vo.BookingVO;
import org.kosta.finalproject.lego.vo.ImageVO;
import org.kosta.finalproject.lego.vo.MemberVO;
import org.kosta.finalproject.lego.vo.MessageVO;
import org.kosta.finalproject.lego.vo.ReviewVO;

@Mapper
public interface MemberMyPageMapper {

	void updateMember(MemberVO memberVO);

	List<BoardVO> findWroteList(String id);

	List<BookingVO> findMyBookingList(String id);

	String findSkillNameBySkillId(int skillsId);

	List<ReviewVO> findCartList(String id);

	List<MessageVO> findMessageList(String id);

	List<MessageVO> findMyMessageDetailByMessageVO(MessageVO messageVO);

	ImageVO getImageById(String id);

}
