package org.kosta.finalproject.lego.controller;

import org.kosta.finalproject.lego.mapper.MessageMapper;
import org.kosta.finalproject.lego.vo.MemberVO;
import org.kosta.finalproject.lego.vo.MessageVO;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MessageController {
	private final MessageMapper messageMapper;
	@RequestMapping("/messageForm")
	public String messageForm(Model model, String receiveId,String masterId,@AuthenticationPrincipal MemberVO memberVO) {
		model.addAttribute("masterId", masterId);
		model.addAttribute("receiveId", receiveId);
		model.addAttribute("mvo", memberVO);
		return "message-form";
	}
	@PostMapping("/message")
	public String message(Model model,MessageVO messageVO,String receiveId,String sendId) {
		MemberVO reVO = new MemberVO();
		MemberVO seVO = new MemberVO();
		reVO.setId(receiveId);
		seVO.setId(sendId);
		messageVO.setReMvo(reVO);
		messageVO.setSendMvo(seVO);
		messageMapper.message(messageVO);
		return "redirect:/surveyFindMasterById?masterId="+receiveId;
	}
}
