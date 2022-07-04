package org.kosta.finalproject.lego.controller;

import java.util.List;

import org.kosta.finalproject.lego.mapper.QnAMapper;
import org.kosta.finalproject.lego.vo.MemberVO;
import org.kosta.finalproject.lego.vo.QnACommentVO;
import org.kosta.finalproject.lego.vo.QnAVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
	public String QnAList(Model model, @PageableDefault(page = 0, size = 10, sort = "q.qna_no", direction = Sort.Direction.DESC) Pageable pageable) {
	
		Page<QnAVO> list =  qnaMapper.findQnAList(pageable);

		model.addAttribute("qnaList", list);
		//model.addAttribute("qnaCommentList", qnaMapper.findQnACommentList(pageable1));
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
	public String QnADetail(int qnaNo, Model model) {
		model.addAttribute("qnaNo", qnaNo);
		model.addAttribute("qnaDetail", qnaMapper.qnaDetail(qnaNo));
		return "QnA-detail";
	}

	@PostMapping("/QnACommentWrite")
	public String QnACommentWrite(QnACommentVO qnaCommentVO, @AuthenticationPrincipal MemberVO memberVO, int qnaNo) {
		QnAVO qnaVO = new QnAVO();
		qnaVO.setQnaNo(qnaNo);
		qnaCommentVO.setQnaVO(qnaVO);
		qnaCommentVO.setMemberVO(memberVO);
		qnaMapper.writeQnAComment(qnaCommentVO);
		return "redirect:/QnAList";
	}

	@PostMapping("/QnAdelete")
	public String QnAdelete(int qnaNo) {
	//	qnaMapper.deleteQna(qnaNo);
		return "redirect:./QnAList";
	}

	@RequestMapping("/QnAupdateForm")
	public String QnAupdate(int qnaNo, Model model) {
		model.addAttribute("qnaNo", qnaNo);
		model.addAttribute("qnaDetail", qnaMapper.qnaDetail(qnaNo));
		return "QnA-update-form";
	}
	@PostMapping("/QnAUpdate")
	public String QnAUpdate(String ask, int qnaNo) {
		QnAVO qnaVO = new QnAVO();
		qnaVO.setAsk(ask);
		qnaVO.setQnaNo(qnaNo);
		qnaMapper.updateQnA(qnaVO);
		return "redirect:/QnADetail?qnaNo="+qnaNo;
	}
}
