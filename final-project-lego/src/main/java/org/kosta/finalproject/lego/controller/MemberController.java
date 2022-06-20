package org.kosta.finalproject.lego.controller;

import org.kosta.finalproject.lego.serivce.MemberService;
import org.kosta.finalproject.lego.vo.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
	private final MemberService memberService;
	
	@PostMapping("/register")
	public String register(MemberVO memberVO,String member) {
		memberService.registerMember(memberVO);
		if(member.equals("1") ) {
			
			return "redirect:/";
		}else{
			return "";
		}
	}
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "login";
	}
}
