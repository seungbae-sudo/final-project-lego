package org.kosta.finalproject.lego.serivce;

import java.util.List;

import org.kosta.finalproject.lego.vo.CategoryVO;
import org.kosta.finalproject.lego.vo.MemberVO;

public interface MemberService {

	void registerMember(MemberVO memberVO);

	List<CategoryVO> getCategory();
}