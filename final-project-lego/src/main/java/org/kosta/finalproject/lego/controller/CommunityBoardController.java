package org.kosta.finalproject.lego.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.finalproject.lego.mapper.CommunityBoardMapper;
import org.kosta.finalproject.lego.vo.BoardCategoryVO;
import org.kosta.finalproject.lego.vo.BoardVO;
import org.kosta.finalproject.lego.vo.CommentVO;
import org.kosta.finalproject.lego.vo.MemberVO;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String boardPosting(@AuthenticationPrincipal MemberVO memberVO, BoardVO boardVO, int categoryNo, Model model,
			RedirectAttributes redirect) {

		BoardCategoryVO bcvo = communityBoardMapper.findBCVO(categoryNo);
		boardVO.setBcvo(bcvo);
		boardVO.setMvo(memberVO);

		communityBoardMapper.posting(boardVO);
		redirect.addAttribute("categoryNo", categoryNo);
		return "redirect:board-posting-result";
	}

	@RequestMapping(value = { "/goCommunity", "/board-posting-result" ,"/boardUpdateResult","/boardDeleteResult"})
	public String goCommunity(Model model, @RequestParam("categoryNo") int categoryNo,HttpServletRequest request) {
		List<BoardVO> list =communityBoardMapper.findAllCommunityList(categoryNo);
		model.addAttribute("CategoryList", list);

		return "community-list";
	}

	@RequestMapping("/updateForm")
	public String boardUpdateFrom(@AuthenticationPrincipal MemberVO memberVO, Model model, int boardNo) {
		BoardVO bvo = communityBoardMapper.findBoardDetailByBoardNo(boardNo);
		
		model.addAttribute("boardNo", boardNo);
		model.addAttribute("bvo", bvo);
		return "board-update-form";
	}
	
	@PostMapping("/board-update")
	public String boardUpdate(@AuthenticationPrincipal MemberVO memberVO,BoardVO bvo,int categoryNo,RedirectAttributes redirect) {
		BoardCategoryVO bcvo= communityBoardMapper.findBCVO(categoryNo);
		bvo.setBcvo(bcvo);
		
		communityBoardMapper.updateByBoardVO(bvo);
		redirect.addAttribute("categoryNo", categoryNo);
		
		return "redirect:boardUpdateResult";
	}
	
	@PostMapping("/deleteForm")
	public String boardDelete(@AuthenticationPrincipal MemberVO memberVO,BoardVO bvo,int categoryNo,RedirectAttributes redirect) {
		BoardCategoryVO bcvo= communityBoardMapper.findBCVO(categoryNo);
		bvo.setBcvo(bcvo);
		
		communityBoardMapper.deleteByBoardVO(bvo);
		redirect.addAttribute("categoryNo", categoryNo);
		
		return "redirect:boardDeleteResult";
	}

	

	@RequestMapping("/boardDetail")
	public String boradDetail(int boardNo, Model model, int categoryNo,CommentVO commentVO,@AuthenticationPrincipal MemberVO memberVO,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		BoardCategoryVO bcvo = new BoardCategoryVO();
		bcvo.setCategoryNo(categoryNo);
		BoardVO bvo = communityBoardMapper.findBoardDetailByBoardNo(boardNo);
		bvo.setBcvo(bcvo);
		model.addAttribute("bvo", bvo);
		model.addAttribute("categoryNo", categoryNo);
		List<CommentVO> list=communityBoardMapper.findCommentList(boardNo);
		model.addAttribute("commentList", list);
		model.addAttribute("mvo", memberVO);
		@SuppressWarnings("unchecked")
		ArrayList<Integer> list1 = (ArrayList<Integer>) session.getAttribute("CommunityBoardNoList");
		if(!list1.contains(boardNo)) {
			communityBoardMapper.updateHits(boardNo);
			list1.add(boardNo);		
		}
		
		return "board-detail";
	}
	
	//comment  관련 controller
	
	@PostMapping("/CommentWrite")
	public String CommentWrite(CommentVO commentVO,@AuthenticationPrincipal MemberVO memberVO, int boardNo, int categoryNo) {
		
		System.out.println(boardNo);
		BoardVO bvo=new BoardVO();
		bvo.setBoardNo(boardNo);
		commentVO.setBvo(bvo);
		commentVO.setMvo(memberVO);
		System.out.println(commentVO);
		communityBoardMapper.writeComment(commentVO);
		return "redirect:/boardDetail?boardNo="+boardNo+"&categoryNo="+categoryNo;
	}

}
