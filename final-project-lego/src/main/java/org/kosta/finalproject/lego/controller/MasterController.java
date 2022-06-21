package org.kosta.finalproject.lego.controller;

import org.kosta.finalproject.lego.serivce.MemberService;
import org.kosta.finalproject.lego.vo.masterDetailVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MasterController {	
	private final MemberService memberService;
	
	@PostMapping("masterRegisterGo")
	public String masterRegisterGo(Model model,masterDetailVO masterDetailVO) {

		return "redirect:masterRegisterSkill";	
	}
	
	@RequestMapping("masterRegisterSkill")
	public String masterRegisterSkill(Model model,masterDetailVO masterDetailVO) {	
		model.addAttribute("skills", memberService.getSkills());
		model.addAttribute("day", memberService.getDays());
		model.addAttribute("times", memberService.getTimes());
		return "master-register-skill";	
	}
}
