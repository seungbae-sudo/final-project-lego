package org.kosta.finalproject.lego.controller;

import org.kosta.finalproject.lego.serivce.MasterService;
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
	private final MasterService masterService;
	
	@PostMapping("/register")
	public String register(MemberVO memberVO,String member) {
			
		if(member.equals("1") ) {
			memberService.registerMember(memberVO);	
			return "redirect:/";
		}else{		
			masterService.registerMember(memberVO);
			return "redirect:masterRegister?id="+memberVO.getId();
		}
	}
	@RequestMapping("/loginFail")
	public String loginFail() {
		return "login_fail";
	}
}
