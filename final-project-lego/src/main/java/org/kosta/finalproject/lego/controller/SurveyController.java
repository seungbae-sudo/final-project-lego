package org.kosta.finalproject.lego.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kosta.finalproject.lego.mapper.CartMapper;
import org.kosta.finalproject.lego.mapper.MasterMapper;
import org.kosta.finalproject.lego.mapper.MasterMyPageMapper;
import org.kosta.finalproject.lego.mapper.SurveyMapper;
import org.kosta.finalproject.lego.vo.BookingVO;
import org.kosta.finalproject.lego.vo.ImageVO;
import org.kosta.finalproject.lego.vo.MasterDetailVO;
import org.kosta.finalproject.lego.vo.MasterVO;
import org.kosta.finalproject.lego.vo.MemberVO;
import org.kosta.finalproject.lego.vo.ReviewVO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SurveyController {
	private final SurveyMapper surveyMapper;
	private final MasterMapper masterMapper;
	private final MasterMyPageMapper masterMyPageMapper;
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
		model.addAttribute("count", surveyMapper.findcount(skills, days, times, categoryNo));
		System.out.println(surveyMapper.findcount(skills, days, times, categoryNo));
		return "find-master-list";
	}
	
	@RequestMapping("/addCart")
	public String findMasterList2(String [] id , int categoryNo,Model model, String masterId,Authentication authentication) {
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
	
	@RequestMapping("/reviewForMember")
	public String reviewForMember(Model model, String masterId) {
		model.addAttribute("masterList", surveyMapper.findMasterDetailList(masterId));
		
		
		List<ReviewVO> rvo = masterMyPageMapper.findMyReview(masterId);
		model.addAttribute("review", rvo);

		return "mastermypage-review-for-member";
	}
	
	
	@RequestMapping("/bookingForm")
	public String bookingFrom(String masterId, Model model, String masterName) {
		List<BookingVO> bvo = surveyMapper.findBookingDayByMasterId(masterId);
		List<String> list = new ArrayList<String>();
		for(int i = 0;i<bvo.size();i++) {
			list.add(bvo.get(i).getBookingDay());
		}
		System.out.println(list);
		model.addAttribute("Day", list);
		model.addAttribute("masterId",masterId);
		model.addAttribute("masterName",masterName);
		return "booking-form";
	}
	@PostMapping("/bookingGo")
	public String booking(Model model,@AuthenticationPrincipal MemberVO memberVO,BookingVO bookingVO,String masterId) {
		bookingVO.setMvo(memberVO);
		MasterDetailVO mdvo = new MasterDetailVO();
		mdvo.setId(masterId);
		bookingVO.setMdVO(mdvo);
		surveyMapper.BookingToMaster(bookingVO);
	return "redirect:/mypage";
	}
	
	@RequestMapping("/searchKeyword")
	public String search(Model model, String keyword) {
		System.out.println(keyword);
		Map<String, String> map = new HashMap<String, String>();
		map.put("KEYWORD", keyword);
		map.put("KEYWORD2", keyword);
		List<MasterVO> list = surveyMapper.findMasterByKeyword(map);
		model.addAttribute("masterList", list);
		
		model.addAttribute("userSearchKeyword", keyword);
		
		return "search-master-list";
	}
}
