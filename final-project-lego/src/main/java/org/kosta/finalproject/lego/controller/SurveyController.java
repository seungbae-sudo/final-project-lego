package org.kosta.finalproject.lego.controller;

import org.kosta.finalproject.lego.mapper.CartMapper;
import org.kosta.finalproject.lego.mapper.MasterMapper;
import org.kosta.finalproject.lego.mapper.SurveyMapper;
import org.kosta.finalproject.lego.vo.MasterVO;
import org.kosta.finalproject.lego.vo.MemberVO;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SurveyController {
	private final SurveyMapper surveyMapper;
	private final MasterMapper masterMapper;
	private final CartMapper cartMapper;
	

	@RequestMapping("/findMaster")
	public String findMaster(Model model, String id, int categoryNo) {
		model.addAttribute("categoryNo", categoryNo);
		model.addAttribute("id", id);
		model.addAttribute("skills", surveyMapper.getSkills());
		model.addAttribute("day", surveyMapper.getDays());
		model.addAttribute("times", surveyMapper.getTimes());
		return "survey-list-form";
	}

	@RequestMapping("/findMasterList")
	public String findMasterList(int[] skills, int[] days, int[] times, Model model, String categoryNo) {
		System.out.println(categoryNo);
		model.addAttribute("skllis", skills);
		model.addAttribute("days", days);
		model.addAttribute("times", times);
		model.addAttribute("categoryNo", categoryNo);
		model.addAttribute("masterList",surveyMapper.findMasterList(skills, days, times,categoryNo));
		return "find-master-list";
	}
	
	@RequestMapping("/addCart")
	public String findMasterList2(String [] id , int categoryNo,Model model, String masterId,Authentication authentication) {
		System.out.println(masterId);
		System.out.println(id[1]);
		MemberVO memberVO = (MemberVO)authentication.getPrincipal();
		MasterVO masterVO = masterMapper.findMasterById(masterId);
		cartMapper.addCart(memberVO.getId(), masterVO.getId());
		model.addAttribute("categoryNo", categoryNo);		
		model.addAttribute("masterList", surveyMapper.findMasterList2(id, categoryNo));
		return "find-master-list";
	}
	@RequestMapping("/surveyFindMasterById")
	public String surveyFindMasterById(Model model, String masterId) {
		model.addAttribute("masterList", surveyMapper.findMasterDetailList(masterId));

		return "master-detail";
	}
}
