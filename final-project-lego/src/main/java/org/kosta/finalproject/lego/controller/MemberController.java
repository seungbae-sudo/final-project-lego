package org.kosta.finalproject.lego.controller;

import org.kosta.finalproject.lego.serivce.MemberService;
import org.kosta.finalproject.lego.vo.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
	private final MemberService memberService;
	
	@PostMapping("/register")
	public String register(MemberVO memberVO,String member) {
		if(member.equals("1") ) {
			memberService.registerMember(memberVO);
			return "redirect:/";
		}else{
			return "";
		}
	}

}
