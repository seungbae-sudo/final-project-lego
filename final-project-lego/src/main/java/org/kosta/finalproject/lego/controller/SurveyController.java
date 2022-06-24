package org.kosta.finalproject.lego.controller;

import java.util.HashMap;
import java.util.Iterator;

import org.kosta.finalproject.lego.mapper.SurveyMapper;
import org.kosta.finalproject.lego.vo.MasterVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SurveyController {
	private final SurveyMapper surveyMapper;

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
		model.addAttribute("masterList",surveyMapper.findMasterList(skills, days, times,categoryNo));
		return "find-master-list";
	}
}
