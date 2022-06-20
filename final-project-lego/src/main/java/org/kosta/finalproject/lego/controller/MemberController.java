package org.kosta.finalproject.lego.controller;

import java.util.List;

import org.kosta.finalproject.lego.serivce.MemberService;
import org.kosta.finalproject.lego.vo.CategoryVO;
import org.kosta.finalproject.lego.vo.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
	private final MemberService memberService;
	
	@PostMapping("/register")
	public String register(Model model,MemberVO memberVO,String member) {
		memberService.registerMember(memberVO);
		List<CategoryVO> list = memberService.getCategory();
		model.addAttribute("category",list);
		model.addAttribute("category1","asdfasdf");
		
		if(member.equals("1") ) {
		
			return "redirect:/";
		}else{		
			return "redirect:masterRegister";
		}
	}
	@RequestMapping("masterRegister")
	public String masterRegister(Model model) {
		
		return "master_register_form";
	}
}
