package org.kosta.finalproject.lego.controller;



import java.util.List;

import org.kosta.finalproject.lego.mapper.CommunityBoardMapper;
import org.kosta.finalproject.lego.serivce.MemberService;
import org.kosta.finalproject.lego.vo.BoardCategoryVO;
import org.kosta.finalproject.lego.vo.BoardVO;
import org.kosta.finalproject.lego.vo.MemberVO;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CommunityBoardController {
	private final CommunityBoardMapper communityBoardMapper;
	
	
	@RequestMapping("/writeForm")
	public String boardWrite() {
		return "board-write-form";
	}
	
	@PostMapping("/posting")
	public String boardPosting(@AuthenticationPrincipal MemberVO memberVO,BoardVO boardVO,int categoryNo,Model model) {
		
		BoardCategoryVO bcvo= communityBoardMapper.findBCVO(categoryNo);
		boardVO.setBcvo(bcvo);
		boardVO.setMvo(memberVO);
		
		communityBoardMapper.posting(boardVO);
		
		return "redirect:board-posting-result";
	}
	
	//이 메서드는 커뮤니티 리스트로 돌아가는 모든 return을 처리한다.
	@RequestMapping(value={"/board-posting-result"})
	public String boardPostingResult() {
		
		
		return "community-list";
	}
	
	//이건 나중에 위에 있는 community-list와 view가 같으므로 합쳐야함 (요구하는 파라미터값이 다름)
	//하지만 현재는 역량이 매우부족하여 스미마셍 ;; 
	@RequestMapping(value={"/goCommunity"})
	public String goCommunity(Model model,int categoryNo) {
		
		List<BoardVO>list=communityBoardMapper.findAllCommunityList(categoryNo);
		System.out.println(list);
		model.addAttribute("CategoryList",list);
		
		return "community-list";
	}

	@RequestMapping("/board-update")
	public String boardUpdate() {
		return "board-update";
	}
	
	@RequestMapping("/board-detail")
	public String boradDetail(int boardNo,Model model) {
		BoardVO bvo=communityBoardMapper.findBoardDetailByBoardNo(boardNo);
		model.addAttribute("bvo",bvo);
		return "board-detail";
	}

}
