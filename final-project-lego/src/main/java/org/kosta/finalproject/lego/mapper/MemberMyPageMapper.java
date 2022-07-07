package org.kosta.finalproject.lego.mapper;

import java.util.HashMap;
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

	List<BoardVO> findWroteList(HashMap<String, Object> wroteMap);

	List<BookingVO> findMyBookingList(HashMap<String, Object> bookingMap);

	String findSkillNameBySkillId(int skillsId);

	List<ReviewVO> findCartList(HashMap<String, Object> cartMap);

	List<MessageVO> findMessageList(String id);

	List<MessageVO> findMyMessageDetailByMessageVO(MessageVO messageVO);

	ImageVO getImageById(String id);

	void updateImage(ImageVO imageVO);

	void reviewWrite(ReviewVO reviewVO);

	
	//페이지네이션
	int getTotalPostCountFromCart(String id);

	int getTotalPostCountFromWrote(String id);

	int getTotalPostCountFromBooking(String id);

	

}
