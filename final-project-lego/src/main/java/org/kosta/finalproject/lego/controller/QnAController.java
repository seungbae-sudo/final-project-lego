package org.kosta.finalproject.lego.controller;

import org.kosta.finalproject.lego.mapper.QnAMapper;
import org.kosta.finalproject.lego.vo.MemberVO;
import org.kosta.finalproject.lego.vo.QnACommentVO;
import org.kosta.finalproject.lego.vo.QnAVO;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class QnAController {
	private final QnAMapper qnaMapper;
	@RequestMapping("/QnAList")
	public String QnAList(Model model) {
		model.addAttribute("qnaList", qnaMapper.findQnAList());
		model.addAttribute("qnaCommentList", qnaMapper.findQnACommentList());
		return "QnA-list";
	}
	@RequestMapping("/QnAWriteFrom")
	public String QnAWriteFrom() {
				
		return "QnA-write-form";
	}
	@PostMapping("/QnAWrite")
	public String QnAWrite(@AuthenticationPrincipal MemberVO memberVO, String ask) {
		QnAVO qnaVO = new QnAVO();
		qnaVO.setAsk(ask);
		qnaVO.setMemberVO(memberVO);
		qnaMapper.writeQnA(qnaVO);
		return "redirect:/QnAList";
	}
	@RequestMapping("/QnADetail")
	public String QnADetail(int qnaNo,Model model) {
		model.addAttribute("qnaNo", qnaNo);
		model.addAttribute("qnaDetail",qnaMapper.qnaDetail(qnaNo));
		return "QnA-detail";
	}
	@PostMapping("/QnACommentWrite")
	public String QnACommentWrite(QnACommentVO qnaCommentVO,@AuthenticationPrincipal MemberVO memberVO,int qnaNo) {
		QnAVO qnaVO= new QnAVO();
		qnaVO.setQnaNo(qnaNo);
		qnaCommentVO.setQnaVO(qnaVO);
		qnaCommentVO.setMemberVO(memberVO);
		qnaMapper.writeQnAComment(qnaCommentVO);
		return "redirect:/QnAList";
	}
}
