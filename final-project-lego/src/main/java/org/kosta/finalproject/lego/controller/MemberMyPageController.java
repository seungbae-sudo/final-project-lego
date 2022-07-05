package org.kosta.finalproject.lego.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.kosta.finalproject.lego.mapper.CartMapper;
import org.kosta.finalproject.lego.mapper.MemberMyPageMapper;
import org.kosta.finalproject.lego.mapper.MessageMapper;
import org.kosta.finalproject.lego.serivce.MemberMypageService;
import org.kosta.finalproject.lego.serivce.MemberService;
import org.kosta.finalproject.lego.vo.BoardVO;
import org.kosta.finalproject.lego.vo.BookingVO;
import org.kosta.finalproject.lego.vo.ImageVO;
import org.kosta.finalproject.lego.vo.MasterVO;
import org.kosta.finalproject.lego.vo.MemberVO;
import org.kosta.finalproject.lego.vo.MessageVO;
import org.kosta.finalproject.lego.vo.Pagination;
import org.kosta.finalproject.lego.vo.ReviewVO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberMyPageController {
	private final MemberMyPageMapper memberMyPageMapper;
	private final MemberMypageService memberMypageService;
	private final MessageMapper messageMapper;
	private final CartMapper cartMapper;

	// mypage로 가는 건 homeController에서 ! 옮김!
	@RequestMapping(value={"/mypage","updateResult"})
	public String mypage(@AuthenticationPrincipal MemberVO memberVO, Model model) {
		// 프로필 이미지 경로 
		ImageVO image = memberMyPageMapper.getImageById(memberVO.getId());
		String src = "./images/" + image.getMemberVO().getId() + "/" + image.getImageName();
		model.addAttribute("src", src);
		
		return "mypage";
	}

	// 탭 이동 컨트롤러***************
	
	
	//북마크 삭제
	@RequestMapping("delete-cart")
	public String deleteCart(@AuthenticationPrincipal MemberVO memberVO,String masterId) {
		cartMapper.deleteCart(memberVO.getId(),masterId);
		return "redirect:mypage-cart";
	}
	
	

	
	// 내 찜목록
	@RequestMapping("/mypage-cart")
	public String mypageCart(@AuthenticationPrincipal MemberVO memberVO, Model model,Pagination p, String pageNo) {
		String id = memberVO.getId();
		
		if(pageNo==null) {// 클라이언트가 pageNo를 전달하지 않는 경우에는 첫 페이지를 보여준다.
			//memberMyPageMapper.getTotalPostCountFromCart() => 총 리스트의 갯수
			p = new Pagination(memberMyPageMapper.getTotalPostCountFromCart(id));
		}else {
			p = new Pagination(memberMyPageMapper.getTotalPostCountFromCart(id), Integer.parseInt(pageNo));
		}
		
		//파라미터로 페이지 네이션 객체와 아이디를 보내야하므로 map으로 구성해야한다. 
		
		HashMap<String, Object> cartMap=new HashMap<String, Object>();

		cartMap.put("pagination", p);
		cartMap.put("id", id);
		
		List<ReviewVO> cartList = memberMyPageMapper.findCartList(cartMap);
		
		//페이지네이션 객체 보내기
		model.addAttribute("pagination", p);
		
		System.out.println(cartList);
		
		//위 리스트에 있는 imageName은 '이미지파일명.jpg ' 이렇게 저장되어있다 
		//해당 이미지 파일명을 리스트 갯수 만큼 반복 문을 돌려 모든 imageName 명을 경로명으로 변경해주었다.
		ArrayList<String> imageSrcList=new ArrayList();
		for(int i=0;i<cartList.size();i++) {
			String imageName=cartList.get(i).getImageVo().getImageName();
			String listSrc = "./images/" +cartList.get(i).getMvo().getId()+ "/" + imageName;
			cartList.get(i).getImageVo().setImageName(listSrc);
		}
		
		
		
		System.out.println(cartList);
		
		model.addAttribute("cartList", cartList);
		
		// 프로필 이미지 경로 
		ImageVO image = memberMyPageMapper.getImageById(memberVO.getId());
		String src = "./images/" + image.getMemberVO().getId() + "/" + image.getImageName();
		model.addAttribute("src", src);
		
		return "mypage-cart";
	}
	
	

	// 내가 쓴 글**************************************************
	@RequestMapping("mypage-wrote")
	public String mypageWrote(@AuthenticationPrincipal MemberVO memberVO, Model model,Pagination p, String pageNo) {
		String id = memberVO.getId();
		
		//페이지네이션 
		
		if(pageNo==null) {// 클라이언트가 pageNo를 전달하지 않는 경우에는 첫 페이지를 보여준다.
			//memberMyPageMapper.getTotalPostCountFromCart() => 총 리스트의 갯수
			p = new Pagination(memberMyPageMapper.getTotalPostCountFromWrote(id));
		}else {
			p = new Pagination(memberMyPageMapper.getTotalPostCountFromWrote(id), Integer.parseInt(pageNo));
		}
		
		//파라미터로 페이지 네이션 객체와 아이디를 보내야하므로 map으로 구성해야한다. 
		
		HashMap<String, Object> wroteMap=new HashMap<String, Object>();

		wroteMap.put("pagination", p);
		wroteMap.put("id", id);
		
		//페이지네이션 객체 보내기
		model.addAttribute("pagination", p);
		
		
		List<BoardVO> wroteList = memberMyPageMapper.findWroteList(wroteMap);
		model.addAttribute("wroteList", wroteList);
		
		
		// 프로필 이미지 경로 
		ImageVO image = memberMyPageMapper.getImageById(memberVO.getId());
		String src = "./images/" + image.getMemberVO().getId() + "/" + image.getImageName();
		model.addAttribute("src", src);
		
		return "mypage-wrote";
	}

	// 내 상담 목록
	@RequestMapping(value={"mypage-booking","mypageReviewWriteResult"})
	public String mypageBooking(@AuthenticationPrincipal MemberVO memberVO, Model model,Pagination p, String pageNo) {
		
		String id = memberVO.getId();
		
		//페이지네이션 
		
		if(pageNo==null) {// 클라이언트가 pageNo를 전달하지 않는 경우에는 첫 페이지를 보여준다.
			//memberMyPageMapper.getTotalPostCountFromCart() => 총 리스트의 갯수
			p = new Pagination(memberMyPageMapper.getTotalPostCountFromBooking(id));
		}else {
			p = new Pagination(memberMyPageMapper.getTotalPostCountFromBooking(id), Integer.parseInt(pageNo));
		}
		
		//파라미터로 페이지 네이션 객체와 아이디를 보내야하므로 map으로 구성해야한다. 
		
		HashMap<String, Object> bookingMap=new HashMap<String, Object>();

		bookingMap.put("pagination", p);
		bookingMap.put("id", id);
		
		//페이지네이션 객체 보내기
		model.addAttribute("pagination", p);
		
		
		
		List<BookingVO> CartList = memberMyPageMapper.findMyBookingList(bookingMap);
		System.out.println(CartList);
		
		model.addAttribute("CartList", CartList);
		
		// 프로필 이미지 경로 
		ImageVO image = memberMyPageMapper.getImageById(memberVO.getId());
		String src = "./images/" + image.getMemberVO().getId() + "/" + image.getImageName();
		model.addAttribute("src", src);		
		
		return "mypage-booking";
	}
	

	   //상담목록에서 리뷰폼으로 가기
	   @RequestMapping("mypage-reviewWriteForm")
	   public String mypageReviewWriteForm(@AuthenticationPrincipal MemberVO memberVO, Model model,String masterId) {
	      // 프로필 이미지 경로 
	            ImageVO image = memberMyPageMapper.getImageById(memberVO.getId());
	            String src = "./images/" + image.getMemberVO().getId() + "/" + image.getImageName();
	            model.addAttribute("src", src);      
	            model.addAttribute("masterId", masterId);
	      return "mypage-reviewWriteForm";
	   }
	   
	   @PostMapping("mypage-reviewWrite")
	   public String mypageReviewWrite(@AuthenticationPrincipal MemberVO memberVO,Model model,String masterId,ReviewVO reviewVO) {
	      MasterVO masterVO=new MasterVO();
	      masterVO.setId(masterId);
	      reviewVO.setMsvo(masterVO);
	      reviewVO.setMvo(memberVO);
	      
	      memberMyPageMapper.reviewWrite(reviewVO);
	      
	      
	      return "redirect:mypageReviewWriteResult";
	   }
	//   
	//   @RequestMapping("mypageReviewWriteResult")
	//   public String mypageReviewWriteResult() {
//	      return "/";
	//   }
	

	// 마이페이지 회원정보 수정
	@RequestMapping("memberUpdateForm")
	public String memberUpdateForm(@AuthenticationPrincipal MemberVO memberVO, Model model) {

		model.addAttribute("member", memberVO);
		
		// 프로필 이미지 경로 
		ImageVO image = memberMyPageMapper.getImageById(memberVO.getId());
		String src = "./images/" + image.getMemberVO().getId() + "/" + image.getImageName();
		model.addAttribute("src", src);
		
		return "mypage-update-form";
	}

	@PostMapping("UpdateMember")
	public String UpdateMember(Authentication authentication,MemberVO memberVO ,@RequestBody MultipartFile file) {
		MemberVO vo = (MemberVO)authentication.getPrincipal();	
		memberMypageService.updateMember(memberVO);
		vo.setPassword(memberVO.getPassword());
		vo.setName(memberVO.getName());
		vo.setAddress(memberVO.getAddress());	
		vo.setTel(memberVO.getTel());
		
		
		// 회원 프로필 사진 변경

		ImageVO findImageVO = new ImageVO();
		findImageVO.setMemberVO(memberVO);
		
		findImageVO =memberMyPageMapper.getImageById(memberVO.getId());
		File folder = new File("C:\\finalproject\\final-project-lego\\final-project-lego\\src\\main\\resources\\static\\images\\"+memberVO.getId()+"\\"+findImageVO.getImageName());
		
		//수정전 
		System.out.println(findImageVO);
		
		//이제 findImageVO에 image_name을 파라미터값으로 받은 image name으로 설정
		findImageVO.setImageName(file.getOriginalFilename());
		
		//image name 이 바뀐 vo로 sql update 실행
		 memberMyPageMapper.updateImage(findImageVO);

			  try { 
				  //이전에 존재한 파일을 삭제
				  folder.delete(); 
				  
				  //update된 vo에서 imageName을 가져와 파일을 생성
				  file.transferTo(
						  new File( "C:\\finalproject\\final-project-lego\\final-project-lego\\src\\main\\resources\\static\\images\\"+memberVO.getId()+"\\" +file.getOriginalFilename()));
			  
			  } catch (IllegalStateException | IOException e) { 
				  e.printStackTrace(); 
				  }
			 
		  
		
		return"redirect:updateResult";
	}

	/*
	 * @RequestMapping("updateResult") 
	 * public String UpdateResult() {
	 * 
	 * return "mypage"; }
	 */

	@RequestMapping("mypage-message")
	public String mypageMessage(@AuthenticationPrincipal MemberVO memberVO, Model model) {
		List<MessageVO> list = memberMyPageMapper.findMessageList(memberVO.getId());
		
		//위 리스트에 있는 imageName은 '이미지파일명.jpg ' 이렇게 저장되어있다 
		//해당 이미지 파일명을 리스트 갯수 만큼 반복 문을 돌려 모든 imageName 명을 경로명으로 변경해주었다.
		ArrayList<String> imageSrcList=new ArrayList();
		for(int i=0;i<list.size();i++) {
			String imageName=list.get(i).getImageVo().getImageName();
			String listSrc = "./images/" +list.get(i).getReMvo().getId()+ "/" + imageName;
			list.get(i).getImageVo().setImageName(listSrc);
		}
		
		//메세지 고수 
		model.addAttribute("messageList", list);
		
		// 프로필 이미지 경로 
		ImageVO image = memberMyPageMapper.getImageById(memberVO.getId());
		String src = "./images/" + image.getMemberVO().getId() + "/" + image.getImageName();
		model.addAttribute("src", src);
		
		
		
		return "mypage-message";
	}

	@RequestMapping(value = { "message-detail", "sendMessageResult" })
	public String mypageMessageDetail(@AuthenticationPrincipal MemberVO memberVO, String receiveId, String receiveName,
			Model model) {
		MessageVO messageVO = new MessageVO();
		MemberVO reMvo = new MemberVO();
		reMvo.setId(receiveId);
		MemberVO sendMvo = new MemberVO();
		sendMvo.setId(memberVO.getId());
		messageVO.setReMvo(reMvo);
		messageVO.setSendMvo(sendMvo); // 보내는 사람

		List<MessageVO> message = memberMyPageMapper.findMyMessageDetailByMessageVO(messageVO);
		System.out.println(message);
		model.addAttribute("receiveName", receiveName);
		model.addAttribute("messageDetail", message);

		model.addAttribute("receiveId", receiveId);
		model.addAttribute("sendId", memberVO.getId());
		
		// 프로필 이미지 경로 
		ImageVO image = memberMyPageMapper.getImageById(memberVO.getId());
		String src = "./images/" + image.getMemberVO().getId() + "/" + image.getImageName();
		model.addAttribute("src", src);
		
		return "mypage-message-detail";
	}

	@PostMapping("sendMessage")
	public String sendMessage(Model model, MessageVO messageVO, String receiveId, String sendId, String receiveName,
			RedirectAttributes redirect) {
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
