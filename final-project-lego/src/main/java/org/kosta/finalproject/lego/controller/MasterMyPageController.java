package org.kosta.finalproject.lego.controller;

import java.util.List;

import org.kosta.finalproject.lego.mapper.MasterMyPageMapper;
import org.kosta.finalproject.lego.serivce.MasterService;
import org.kosta.finalproject.lego.vo.BoardCategoryVO;
import org.kosta.finalproject.lego.vo.BoardVO;
import org.kosta.finalproject.lego.vo.BookingVO;
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
public class MasterMyPageController {
	private final MasterMyPageMapper masterMyPageMapper;
	private final MasterService masterService;
	
	

	@RequestMapping("/mastermypage")
	public String mastermypage(@AuthenticationPrincipal MemberVO memberVO,Model model) {
		model.addAttribute("member", memberVO);
		model.addAttribute("masterDetail", masterMyPageMapper.findMasterDetailList(memberVO.getId()));
		return "master-mypage";
	}
	
	@RequestMapping("/mastermypage-cart")
	public String mastermypageCart(@AuthenticationPrincipal MemberVO memberVO,Model model) {
		String id=memberVO.getId();
		List<BoardVO> list= masterMyPageMapper.findMyBoard(id);
		System.out.println(list.get(0));
		model.addAttribute("BoardList", list);
		model.addAttribute("member", memberVO);
		model.addAttribute("masterDetail", masterMyPageMapper.findMasterDetailList(memberVO.getId()));
		return "mastermypage-cart";
	}

	@RequestMapping("/mastermypage-review")
	public String mastermypageReview(@AuthenticationPrincipal MemberVO memberVO,Model model) {
		model.addAttribute("member", memberVO);
		model.addAttribute("masterDetail", masterMyPageMapper.findMasterDetailList(memberVO.getId()));
		List<ReviewVO> rvo = masterMyPageMapper.findMyReview(memberVO.getId());
		model.addAttribute("review",rvo);
		return "mastermypage-review";
	}

	@RequestMapping("/mastermypage-consult")
	public String mastermypageConsult(@AuthenticationPrincipal MemberVO memberVO,Model model,BookingVO bookingVO) {
		model.addAttribute("member", memberVO);
		BookingVO bkvo = masterMyPageMapper.findMyBooking(memberVO.getId());
	
		model.addAttribute("masterDetail", masterMyPageMapper.findMasterDetailList(memberVO.getId()));
		model.addAttribute("Booking", bkvo);
		return "mastermypage-consult";
	}
	
	@RequestMapping("/mastermypage-consult-detail")
	public String mastermypageConsultDetail(@AuthenticationPrincipal MemberVO memberVO,Model model,BookingVO bookingVO, String bcd) {
		model.addAttribute("member", memberVO);
		BookingVO bkvo = masterMyPageMapper.findMyBooking(memberVO.getId());
		model.addAttribute("masterDetail", masterMyPageMapper.findMasterDetailList(memberVO.getId()));
		model.addAttribute("Booking", bkvo);
		model.addAttribute("bcd", bcd);
		return "mastermypage-consult-detail";
	}
	
	@RequestMapping("/mastermypage-message")
	public String mastermypageMessage(@AuthenticationPrincipal MemberVO memberVO,Model model) {
		model.addAttribute("member", memberVO);
		model.addAttribute("masterDetail", masterMyPageMapper.findMasterDetailList(memberVO.getId()));
		return "mastermypage-Message";
	}

	@RequestMapping("masterUpdateForm")
	//@AuthenticationPrincipal : Spring Security를 통해 로그인한 인증정보를 받아오는 어노테이션 
	public String updateForm(@AuthenticationPrincipal MemberVO memberVO,Model model) {
		model.addAttribute("member", memberVO);
		model.addAttribute("masterDetail", masterMyPageMapper.findMasterDetailList(memberVO.getId()));
		return "masterUpdateForm";
	}

	@PostMapping("updateMaster")
	//첫번째 매개변수 Authentication : Spring Security 인증 정보 , 두번째 매개변수 memberVO : 수정폼에서 전달받는 데이터 
	public String updateMemberAction(Authentication authentication,String specifications, String career, MemberVO memberVO) {
//		System.out.println(specifications+career);
//		System.out.println(memberVO);
		
		MemberVO vo = (MemberVO)authentication.getPrincipal();	
		MasterVO mvo = new MasterVO();
		mvo.setId(vo.getId());
		mvo.setCareer(career);
		mvo.setSpecifications(specifications);
		masterService.updateMember(memberVO);
		masterService.updateMaster(mvo);//service에서 변경될 비밀번호를 암호화한다 
		// 수정한 회원정보로 Spring Security 회원정보를 업데이트한다
		vo.setPassword(memberVO.getPassword());
		vo.setName(memberVO.getName());
		vo.setAddress(memberVO.getAddress());	
		vo.setTel(memberVO.getTel());	
		return "redirect:mastermypage";
	}
		
	
	
	
	
	}