package org.kosta.finalproject.lego.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.finalproject.lego.vo.BoardVO;
import org.kosta.finalproject.lego.vo.BookingVO;
import org.kosta.finalproject.lego.vo.CategoryVO;
import org.kosta.finalproject.lego.vo.ImageVO;
import org.kosta.finalproject.lego.vo.MasterVO;
import org.kosta.finalproject.lego.vo.MemberVO;
import org.kosta.finalproject.lego.vo.MessageVO;
import org.kosta.finalproject.lego.vo.ReviewVO;
import org.kosta.finalproject.lego.vo.SkillsVO;

@Mapper
public interface MasterMyPageMapper {

	void updateMember(MemberVO memberVO);
	
	MasterVO findMasterDetailList(String id);

	void updateMaster(MasterVO mvo);

	List<BoardVO> findMyBoard(String id);
	
	List<BookingVO> findMyBooking(String id);

	List<ReviewVO> findMyReview(Map<String, Object> map);

	List<MessageVO> findMyMessage(String id);
	
	List<MessageVO> findMyMessageDetail(MessageVO messageVO);

	void message(MessageVO messageVO);

	ImageVO getImageId(String id);

	CategoryVO MyCategory(String id);

	List<SkillsVO> MySkills(String id);

	BookingVO findMyBookingDetail(int bookingNo);

	List<ReviewVO> MyReview(String id);
	
	int findTotalList(String id);
	
	
}
