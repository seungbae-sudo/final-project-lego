package org.kosta.finalproject.lego.controller;

import org.kosta.finalproject.lego.mapper.MemberMapper;
import org.kosta.finalproject.lego.vo.masterDetailVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MasterController {	
	private final MemberMapper memberMapper;
	
	@PostMapping("masterRegisterGo")
	public String masterRegisterGo(int[] skills, int [] days, int [] times, String id) {
		masterDetailVO mdv = new masterDetailVO();
		mdv.setId(id);
		
		  for(int i=0;i<skills.length;i++) { 
			  mdv.setSkillsId(skills[i]);
		  memberMapper.registerSkills(mdv);
		  }
		 
		for(int i=0;i<days.length;i++) {
			mdv.setDaysId(days[i]);
			memberMapper.registerDays(mdv);
		}
		
		  for(int i=0;i<times.length;i++) { 
			 mdv.setTimesId(times[i]);
		  memberMapper.registerTimes(mdv); 
		  }
		 
		return "redirect:/";	
	}
}
