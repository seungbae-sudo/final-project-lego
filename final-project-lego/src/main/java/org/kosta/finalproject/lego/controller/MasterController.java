package org.kosta.finalproject.lego.controller;

import org.kosta.finalproject.lego.vo.masterDetailVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MasterController {	
	@PostMapping("masterRegisterGo")
	public String masterRegisterGo(masterDetailVO masterDetailVO) {
		
		
		return "redirect:/";	
	}
}
