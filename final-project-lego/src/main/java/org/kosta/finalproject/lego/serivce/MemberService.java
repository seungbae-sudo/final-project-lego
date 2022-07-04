package org.kosta.finalproject.lego.serivce;

import java.util.List;

import org.kosta.finalproject.lego.vo.Authority;
import org.kosta.finalproject.lego.vo.CategoryVO;
import org.kosta.finalproject.lego.vo.DaysVO;
import org.kosta.finalproject.lego.vo.MemberVO;
import org.kosta.finalproject.lego.vo.SkillsVO;
import org.kosta.finalproject.lego.vo.TimesVO;

public interface MemberService {

	void registerMember(MemberVO memberVO);

	
	List<CategoryVO> getCategory();
	
	List<SkillsVO> getSkills();

	List<DaysVO> getDays();
	
	List<TimesVO> getTimes();

	MemberVO findMemberById(String id);

	List<Authority> findAuthorityByUsername(String username);


	String idcheck(String id);


	int getMemberCount();
	
	
}