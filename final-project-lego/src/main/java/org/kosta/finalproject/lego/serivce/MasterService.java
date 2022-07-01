package org.kosta.finalproject.lego.serivce;

import java.util.List;

import org.kosta.finalproject.lego.vo.CategoryVO;
import org.kosta.finalproject.lego.vo.DaysVO;
import org.kosta.finalproject.lego.vo.MasterDetailVO;
import org.kosta.finalproject.lego.vo.MasterVO;
import org.kosta.finalproject.lego.vo.MemberVO;
import org.kosta.finalproject.lego.vo.ReviewVO;
import org.kosta.finalproject.lego.vo.SkillsVO;
import org.kosta.finalproject.lego.vo.TimesVO;

public interface MasterService {

	void registerMember(MemberVO memberVO);
	
	List<CategoryVO> getCategory();
	
	List<SkillsVO> getSkills();

	List<DaysVO> getDays();
	
	List<TimesVO> getTimes();
	
	void registerMaster(MasterVO masterVO);
	
	void registerSkills(MasterDetailVO masterDetailVO);
	
	void registerDays(MasterDetailVO masterDetailVO);
	
	void registerTimes(MasterDetailVO masterDetailVO);
	
	void updateMaster(MasterVO mvo);

	void updateMember(MemberVO memberVO);

	List<ReviewVO> findMasterRanking();
}