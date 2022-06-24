package org.kosta.finalproject.lego.controller;

import java.util.List;

import org.kosta.finalproject.lego.mapper.MemberMyPageMapper;
import org.kosta.finalproject.lego.serivce.MemberMypageService;
import org.kosta.finalproject.lego.serivce.MemberService;
import org.kosta.finalproject.lego.vo.BoardVO;
import org.kosta.finalproject.lego.vo.MemberVO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberMyPageController {
	private final MemberMyPageMapper memberMyPageMapper;
	private final MemberMypageService  memberMypageService;
	
	//mypage로 가는 건 homeController에서 !
	
	
	//탭 이동 컨트롤러***************
	@RequestMapping("/mypage-cart")
	public String mypageCart() {
		return "mypage-cart";
	}
	//모델넣어야함
	@RequestMapping("mypage-wrote")
	public String mypageWrote(@AuthenticationPrincipal MemberVO memberVO,Model model) {
		String id =memberVO.getId();
		List<BoardVO> wroteList= memberMyPageMapper.findWroteList(id);
		model.addAttribute("wroteList",wroteList);
		System.out.println(wroteList);
		return "mypage-wrote";
	}
	
	@RequestMapping("mypage-booking")
	public String mypageBooking() {
		return "mypage-booking";
	}
	
	//마이페이지 회원정보 수정
	@RequestMapping("memberUpdateForm")
	public String memberUpdateForm(@AuthenticationPrincipal MemberVO memberVO,Model model) {
		
		model.addAttribute("member", memberVO);
		return "mypage-update-form";
	}
	
	@PostMapping("UpdateMember")
	public String UpdateMember(Authentication authentication,MemberVO memberVO) {
		MemberVO vo = (MemberVO)authentication.getPrincipal();	
		memberMypageService.updateMember(memberVO);
		vo.setPassword(memberVO.getPassword());
		vo.setName(memberVO.getName());
		vo.setAddress(memberVO.getAddress());	
		vo.setTel(memberVO.getTel());
		return"redirect:updateResult";
	}
	
	@RequestMapping("updateResult")
	public String UpdateResult() {
		return "mypage";
	}
}

