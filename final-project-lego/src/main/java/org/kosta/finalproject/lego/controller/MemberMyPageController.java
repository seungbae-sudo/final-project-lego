package org.kosta.finalproject.lego.controller;

import org.kosta.finalproject.lego.mapper.MemberMyPageMapper;
import org.kosta.finalproject.lego.serivce.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberMyPageController {
	private final MemberMyPageMapper memberMyPageMapper;
	
	//mypage로 가는 건 homeController에서 !
	
	@RequestMapping("/mypage-cart")
	public String mypageCart() {
		return "mypage-cart";
	}
}

