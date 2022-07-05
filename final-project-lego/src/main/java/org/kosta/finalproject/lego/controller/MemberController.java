package org.kosta.finalproject.lego.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.kosta.finalproject.lego.mapper.ImageMapper;
import org.kosta.finalproject.lego.serivce.MasterService;
import org.kosta.finalproject.lego.serivce.MemberService;
import org.kosta.finalproject.lego.vo.ImageVO;
import org.kosta.finalproject.lego.vo.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
	private final MemberService memberService;
	private final MasterService masterService;
	private final ImageMapper imageMapper;

	@PostMapping("/register")
	public String register(MemberVO memberVO, String member, HttpServletRequest request,
			@RequestBody MultipartFile file) {
		
		File folder = new File("C:\\finalproject\\final-project-lego\\final-project-lego\\src\\main\\resources\\static\\images\\"+memberVO.getId());
		ImageVO imageVO = new ImageVO();
		imageVO.setImageName(file.getOriginalFilename());
		imageVO.setMemberVO(memberVO);
		if (member.equals("1")) {
			memberService.registerMember(memberVO);
			imageMapper.uploadImage(imageVO);
			try {
				folder.mkdir();
				file.transferTo(new File(
						"C:\\finalproject\\final-project-lego\\final-project-lego\\src\\main\\resources\\static\\images\\"+memberVO.getId()+"\\"
								+ file.getOriginalFilename()));

			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			
			
			return "redirect:/";
		} else {
			masterService.registerMember(memberVO);
			imageMapper.uploadImage(imageVO);
			try {
				folder.mkdir();
				file.transferTo(new File(
						"C:\\finalproject\\final-project-lego\\final-project-lego\\src\\main\\resources\\static\\images\\"+memberVO.getId()+"\\"
								+ file.getOriginalFilename()));

			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			
			return "redirect:masterRegister?id=" + memberVO.getId();
		}

	}

	@RequestMapping("/loginFail")
	public String loginFail() {
		return "login_fail";
	}
	
	@RequestMapping("idcheckAjax")
	@ResponseBody
	public String idcheckAjax(String id) {
		return memberService.idcheck(id);
	}
	@GetMapping("getMemberTotalCount")	
	@ResponseBody
	public int getMemberTotalCount() {
		return memberService.getMemberCount();
	}
}
