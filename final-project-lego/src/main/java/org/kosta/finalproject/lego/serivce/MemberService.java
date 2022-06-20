package org.kosta.finalproject.lego.serivce;

import java.util.List;

import org.kosta.finalproject.lego.vo.Authority;
import org.kosta.finalproject.lego.vo.MemberVO;

public interface MemberService {

	void registerMember(MemberVO memberVO);

	MemberVO findMemberById(String id);

	List<Authority> findAuthorityById(String id);

}