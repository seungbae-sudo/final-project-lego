package org.kosta.finalproject.lego.controller;

import java.util.List;

import org.kosta.finalproject.lego.mapper.MemberMapper;
import org.kosta.finalproject.lego.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	MemberMapper memberMapper;
	
	@Autowired
	public MemberController(MemberMapper memberMapper) {
		super();
		this.memberMapper = memberMapper;
	}

	@RequestMapping("master1")
	public void category(Model model){
		model.addAttribute("category",memberMapper.getCategory());
	}
}
package org.kosta.finalproject.lego.controller;

import org.kosta.finalproject.lego.serivce.MemberService;
import org.kosta.finalproject.lego.vo.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
	private final MemberService memberService;
	
	@PostMapping("/register")
	public String register(MemberVO memberVO,String member) {
		memberService.registerMember(memberVO);
		if(member.equals("1") ) {
			
			return "redirect:/";
		}else{
			return "";
		}
	}

}
