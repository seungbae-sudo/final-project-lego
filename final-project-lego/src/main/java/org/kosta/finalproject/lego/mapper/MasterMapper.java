package org.kosta.finalproject.lego.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.finalproject.lego.vo.Authority;
import org.kosta.finalproject.lego.vo.CategoryVO;
import org.kosta.finalproject.lego.vo.DaysVO;
import org.kosta.finalproject.lego.vo.MasterDetailVO;
import org.kosta.finalproject.lego.vo.MasterVO;
import org.kosta.finalproject.lego.vo.MemberVO;
import org.kosta.finalproject.lego.vo.SkillsVO;
import org.kosta.finalproject.lego.vo.TimesVO;

@Mapper
public interface MasterMapper {
	
	
	void masterRegisterRole(Authority aurhority);
	
	List<CategoryVO> getCategory();

	List<SkillsVO> getSkills();

	List<DaysVO> getDays();

	List<TimesVO> getTimes();
	
	void masterRegister(MasterDetailVO masterDetailVO);

	void registerMember(MemberVO memberVO);
	
	void registerMaster(MasterVO masterVO);
	
	void registerSkills(MasterDetailVO masterDetailVO);
	
	void registerDays(MasterDetailVO masterDetailVO);
	
	void registerTimes(MasterDetailVO masterDetailVO);
	
	MasterVO findMasterById(String id);
}
