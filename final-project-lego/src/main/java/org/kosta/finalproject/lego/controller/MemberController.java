package org.kosta.finalproject.lego.controller;

import org.kosta.finalproject.lego.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
	private final MemberMapper memberMapper;

}
