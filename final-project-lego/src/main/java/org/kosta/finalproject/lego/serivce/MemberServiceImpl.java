package org.kosta.finalproject.lego.serivce;

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

	@Override
	@Transactional
	public void registerMember(MemberVO memberVO) {
		memberMapper.registerMember(memberVO);
		Authority aurhority = new Authority(memberVO.getId(), "member");
		memberMapper.memberRegisterRole(aurhority);
	}
}
