package org.kosta.finalproject.lego.serivce;

import java.util.List;

import org.kosta.finalproject.lego.mapper.MemberMapper;
import org.kosta.finalproject.lego.vo.Authority;
import org.kosta.finalproject.lego.vo.MemberVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	private final MemberMapper memberMapper;
	//private final BCryptPasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void registerMember(MemberVO memberVO) {
	//	String encodedPwd = passwordEncoder.encode(memberVO.getPassword());
		///memberVO.setPassword(encodedPwd);
		memberMapper.registerMember(memberVO);
		Authority aurhority = new Authority(memberVO.getId(), "member");
		memberMapper.memberRegisterRole(aurhority);
	}

	@Override
	public MemberVO findMemberById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Authority> findAuthorityById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
