package org.kosta.finalproject.lego.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class HomeController {
	@RequestMapping("/")
	
	public String home(Authentication authentication,Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(authentication!=null) {
			  log.info("Home: 인증받은 사용자 {} ",authentication.getPrincipal());
			  session.setAttribute("CommunityBoardNoList", new ArrayList<Integer>());
			
		}
			else {
				log.info("Home: 인증받지 않은 사용자");
			}
			model.addAttribute("message", "SpringBoot Security Thymeleaf");
			System.out.println(authentication);
		return "index";
	}
	
	@RequestMapping("/registerForm")
	public String registerForm() {
		return "register-form";
	}
	
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "loginForm";
	}
	
	@RequestMapping("/mypage")
	public String mypage() {
		return "mypage";
	}
	
	@RequestMapping("/findMasterForm")
	public String findMaster() {
		return "find-master-form";
	}
}
