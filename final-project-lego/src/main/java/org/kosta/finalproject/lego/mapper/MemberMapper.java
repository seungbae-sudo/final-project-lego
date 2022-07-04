package org.kosta.finalproject.lego.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.finalproject.lego.vo.Authority;
import org.kosta.finalproject.lego.vo.CategoryVO;
import org.kosta.finalproject.lego.vo.DaysVO;
import org.kosta.finalproject.lego.vo.MemberVO;
import org.kosta.finalproject.lego.vo.SkillsVO;
import org.kosta.finalproject.lego.vo.TimesVO;

@Mapper
public interface MemberMapper {

	void registerMember(MemberVO memberVO);

	void memberRegisterRole(Authority aurhority);
	
	List<CategoryVO> getCategory();

	List<SkillsVO> getSkills();

	List<DaysVO> getDays();

	List<TimesVO> getTimes();

	MemberVO findMemberById(String id);

	List<Authority> findAuthorityByUsername(String id);

	int getMemberCount();

	int idcheck(String id);
	
	
}
