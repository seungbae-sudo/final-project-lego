package org.kosta.finalproject.lego.controller;

import java.util.List;

import org.kosta.finalproject.lego.serivce.MasterService;
import org.kosta.finalproject.lego.vo.CategoryVO;
import org.kosta.finalproject.lego.vo.MasterDetailVO;
import org.kosta.finalproject.lego.vo.MasterVO;
import org.kosta.finalproject.lego.vo.ReviewVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MasterController {	
	private final MasterService masterService;

	
	@RequestMapping("/master/masterRegister")
	public String masterRegister(Model model, String id) {
		model.addAttribute("id", id);	
		model.addAttribute("category", masterService.getCategory());
		return "master_register_form";
	}
	
	@PostMapping("masterRegisterGo")
	public String masterRegisterGo(Model model,MasterVO masterVO, int categoryNo) {
		CategoryVO categoryVO = new CategoryVO();
		categoryVO.setCategoryNo(categoryNo);
		masterVO.setCategory(categoryVO);
		masterService.registerMaster(masterVO);
		return "redirect:masterRegisterSkill?id="+masterVO.getId()+"&categoryNo="+categoryNo;	
	}
	
	@RequestMapping("masterRegisterSkill")
	public String masterRegisterSkill(Model model, String id, int categoryNo) {	
		model.addAttribute("categoryNo",categoryNo);
		model.addAttribute("id", id);
		model.addAttribute("skills", masterService.getSkills());
		model.addAttribute("day", masterService.getDays());
		model.addAttribute("times", masterService.getTimes());
		return "master-register-skill";	
	}
	
	@PostMapping("masterRegisterSkillGo")
	public String masterRegisterGo(int[] skills, int [] days, int [] times, String id) {
		MasterDetailVO mdv = new MasterDetailVO();
		  mdv.setId(id);
		
		  for(int i=0;i<skills.length;i++) { 
			  mdv.setSkillsId(skills[i]);
		  masterService.registerSkills(mdv);
		  }
		 
		for(int i=0;i<days.length;i++) {
			mdv.setDaysId(days[i]);
			masterService.registerDays(mdv);
		}
		
		  for(int i=0;i<times.length;i++) { 
			 mdv.setTimesId(times[i]);
			 masterService.registerTimes(mdv); 
		  }
		 
		return "redirect:/loginForm";	
	}
	@RequestMapping("/findMasterByKeyword")
	public String findMasterByKeyword() {
		return "find-master-list";
	}
	
	
	
	//고수 랭킹 5위까지 
	@RequestMapping("find-master-raking")
	public String findMasterRaking(Model model) {
		List<ReviewVO> list =masterService.findMasterRanking();


		
		model.addAttribute("rankingList", list);
		return "master-raking-list";
	}
	
	
}
