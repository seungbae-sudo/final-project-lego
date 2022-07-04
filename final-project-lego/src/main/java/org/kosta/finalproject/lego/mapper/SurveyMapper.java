package org.kosta.finalproject.lego.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.finalproject.lego.vo.BookingVO;
import org.kosta.finalproject.lego.vo.DaysVO;
import org.kosta.finalproject.lego.vo.MasterVO;
import org.kosta.finalproject.lego.vo.SkillsVO;
import org.kosta.finalproject.lego.vo.TimesVO;

@Mapper
public interface SurveyMapper {
	
	List<SkillsVO> getSkills();

	List<DaysVO> getDays();

	List<TimesVO> getTimes();
	
	List<MasterVO> findMasterList(int[] skills, int[] days, int[] times,String categoryNo);

	List<MasterVO> findMasterList2(String [] id,int categoryNo);
	
	MasterVO findMasterDetailList(String id);
	
	List<BookingVO> findBookingDayByMasterId(String masterId);
	
	void BookingToMaster(BookingVO bookingVO);
	
	List<MasterVO> findMasterByKeyword(String keyword, String keyword2);

	List<MasterVO> findMasterByKeyword(Map<String, String> map);
	
	Integer findcount(int[] skills, int[] days, int[] times,String categoryNo);
}
