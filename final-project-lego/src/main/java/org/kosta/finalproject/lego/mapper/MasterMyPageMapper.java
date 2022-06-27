package org.kosta.finalproject.lego.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.finalproject.lego.vo.BoardVO;
import org.kosta.finalproject.lego.vo.BookingVO;
import org.kosta.finalproject.lego.vo.MasterVO;
import org.kosta.finalproject.lego.vo.MemberVO;
import org.kosta.finalproject.lego.vo.ReviewVO;

@Mapper
public interface MasterMyPageMapper {

	void updateMember(MemberVO memberVO);
	
	MasterVO findMasterDetailList(String id);

	void updateMaster(MasterVO mvo);

	List<BoardVO> findMyBoard(String id);
	
	BookingVO findMyBooking(String id);

	List<ReviewVO> findMyReview(String id);
	


}
