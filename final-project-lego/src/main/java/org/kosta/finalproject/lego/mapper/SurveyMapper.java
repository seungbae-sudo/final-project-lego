package org.kosta.finalproject.lego.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.finalproject.lego.vo.BookingVO;
import org.kosta.finalproject.lego.vo.CartVO;
import org.kosta.finalproject.lego.vo.DaysVO;
import org.kosta.finalproject.lego.vo.MasterVO;
import org.kosta.finalproject.lego.vo.Pagination;
import org.kosta.finalproject.lego.vo.ReviewVO;
import org.kosta.finalproject.lego.vo.SkillsVO;
import org.kosta.finalproject.lego.vo.TimesVO;

@Mapper
public interface SurveyMapper {
	
	List<SkillsVO> getSkills();

	List<DaysVO> getDays();

	List<TimesVO> getTimes();
	
	List<MasterVO> findMasterList(int[] skills, int[] days, int[] times,String categoryNo,Pagination pagination);

	List<MasterVO> findMasterList2(String [] id,int categoryNo);
	
	MasterVO findMasterDetailList(String id);
	
	List<BookingVO> findBookingDayByMasterId(String masterId);
	
	void BookingToMaster(BookingVO bookingVO);

	List<MasterVO> findMasterByKeyword(String keyword, Pagination p);
	
	Integer findcount(int[] skills, int[] days, int[] times,String categoryNo);
	
	Integer getTotalFindList(int[] skills, int[] days, int[] times,String categoryNo);
	
	ReviewVO getScore(String id);
	
	Integer getTotalFindList2(String keyword);
	
	List<CartVO> findCartList(String id);
}
