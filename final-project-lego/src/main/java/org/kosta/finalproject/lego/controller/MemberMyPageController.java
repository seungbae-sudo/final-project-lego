package org.kosta.finalproject.lego.controller;

import java.util.List;

import org.kosta.finalproject.lego.mapper.MemberMyPageMapper;
import org.kosta.finalproject.lego.mapper.MessageMapper;
import org.kosta.finalproject.lego.serivce.MemberMypageService;
import org.kosta.finalproject.lego.serivce.MemberService;
import org.kosta.finalproject.lego.vo.BoardVO;
import org.kosta.finalproject.lego.vo.BookingVO;
import org.kosta.finalproject.lego.vo.ImageVO;
import org.kosta.finalproject.lego.vo.MemberVO;
import org.kosta.finalproject.lego.vo.MessageVO;
import org.kosta.finalproject.lego.vo.ReviewVO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberMyPageController {
	private final MemberMyPageMapper memberMyPageMapper;
	private final MemberMypageService  memberMypageService;
	private final MessageMapper messageMapper;
	
	
	//mypage로 가는 건 homeController에서 ! 옮김!
	@RequestMapping("/mypage")
	public String mypage(@AuthenticationPrincipal MemberVO memberVO,Model model) {
//		ImageVO image= memberMyPageMapper.getImageById(memberVO.getId());
//		model.addAttribute("image", image);
		return "mypage";
	}
	
	//탭 이동 컨트롤러***************
	//내 찜목록
	@RequestMapping("/mypage-cart")
	public String mypageCart(@AuthenticationPrincipal MemberVO memberVO,Model model) {
		String id =memberVO.getId();
		List<ReviewVO> cartList=memberMyPageMapper.findCartList(id);
		model.addAttribute("cartList", cartList);
		return "mypage-cart";
	}
	
	//내가 쓴 글  
	@RequestMapping("mypage-wrote")
	public String mypageWrote(@AuthenticationPrincipal MemberVO memberVO,Model model) {
		String id =memberVO.getId();
		List<BoardVO> wroteList= memberMyPageMapper.findWroteList(id);
		model.addAttribute("wroteList",wroteList);
		System.out.println(wroteList);
		return "mypage-wrote";
	}
	
	//내 상담 목록
	@RequestMapping("mypage-booking")
	public String mypageBooking(@AuthenticationPrincipal MemberVO memberVO, Model model) {
		List<BookingVO> CartList =  memberMyPageMapper.findMyBookingList(memberVO.getId());
		System.out.println(CartList);
		
		model.addAttribute("CartList", CartList);
		
		
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
	
	@RequestMapping("mypage-message")
	public String mypageMessage(@AuthenticationPrincipal MemberVO memberVO,Model model) {
		List<MessageVO> list =memberMyPageMapper.findMessageList( memberVO.getId());
		model.addAttribute("messageList", list);
		return "mypage-message";
	}
	
	@RequestMapping(value={"message-detail","sendMessageResult"})
	public String mypageMessageDetail(@AuthenticationPrincipal MemberVO memberVO,String receiveId,String receiveName,Model model) {
		MessageVO messageVO=new MessageVO();
		MemberVO reMvo= new MemberVO();
		reMvo.setId(receiveId);
		MemberVO sendMvo= new MemberVO();
		sendMvo.setId(memberVO.getId());
		messageVO.setReMvo(reMvo);
		messageVO.setSendMvo(sendMvo); //보내는 사람 

		
		List<MessageVO> message = memberMyPageMapper.findMyMessageDetailByMessageVO(messageVO);
		System.out.println(message);
		model.addAttribute("receiveName",receiveName);
		model.addAttribute("messageDetail",message);
		
		model.addAttribute("receiveId", receiveId);
		model.addAttribute("sendId", memberVO.getId());
		return "mypage-message-detail";
	}
	
	
	@PostMapping("sendMessage")
	public String sendMessage(Model model,MessageVO messageVO,String receiveId,String sendId, String receiveName,RedirectAttributes redirect) {
		MemberVO reVO = new MemberVO();
		MemberVO seVO = new MemberVO();
		reVO.setId(receiveId);
		seVO.setId(sendId);
		messageVO.setReMvo(reVO);
		messageVO.setSendMvo(seVO);
		messageMapper.message(messageVO);
		
		redirect.addAttribute("receiveId", receiveId);
		redirect.addAttribute("receiveName", receiveName);
		return "redirect:sendMessageResult";
	}
	
	
}

