package org.kosta.finalproject.lego.serivce;

import java.util.List;

import org.kosta.finalproject.lego.mapper.MemberMyPageMapper;
import org.kosta.finalproject.lego.vo.MemberVO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberMypageServiceImpl implements MemberMypageService{
	private final MemberMyPageMapper memberMyPageMapper;
	private final BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public void updateMember(MemberVO memberVO) {
		String encodePassword=passwordEncoder.encode(memberVO.getPassword());
		memberVO.setPassword(encodePassword);
		memberMyPageMapper.updateMember(memberVO);
		
	}

	
}
