package org.kosta.finalproject.lego.controller;

import org.kosta.finalproject.lego.mapper.MasterMyPageMapper;
import org.kosta.finalproject.lego.vo.MemberVO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MasterMyPageController {
	private final MasterMyPageMapper masterMyPageMapper;

	@RequestMapping("/mastermypage-cart")
	public String mastermypageCart() {
		return "mastermypage-cart";
	}

	@RequestMapping("/mastermypage-review")
	public String mastermypageReview() {
		return "mastermypage-review";
	}

	@RequestMapping("/mastermypage-consult")
	public String mastermypageConsult() {
		return "mastermypage-consult";
	}

	@RequestMapping("masterUpdateForm")
	//@AuthenticationPrincipal : Spring Security를 통해 로그인한 인증정보를 받아오는 어노테이션 
	public String updateForm(@AuthenticationPrincipal MemberVO memberVO,Model model) {
		model.addAttribute("member", memberVO);
		return "masterUpdateForm";
	}

	@PostMapping("updateMaster")
	//첫번째 매개변수 Authentication : Spring Security 인증 정보 , 두번째 매개변수 memberVO : 수정폼에서 전달받는 데이터 
	public String updateMemberAction(Authentication authentication, MemberVO memberVO) {
		MemberVO vo = (MemberVO)authentication.getPrincipal();			
		masterMyPageMapper.updateMaster(memberVO);//service에서 변경될 비밀번호를 암호화한다 
		// 수정한 회원정보로 Spring Security 회원정보를 업데이트한다
		vo.setPassword(memberVO.getPassword());
		vo.setName(memberVO.getName());
		vo.setAddress(memberVO.getAddress());	
		vo.setTel(memberVO.getTel());	
		return "redirect:mastermypage";
	}
	}