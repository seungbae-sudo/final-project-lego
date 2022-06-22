package org.kosta.finalproject.lego.serivce;

import java.util.List;

import org.kosta.finalproject.lego.mapper.MemberMapper;
import org.kosta.finalproject.lego.vo.Authority;
import org.kosta.finalproject.lego.vo.CategoryVO;
import org.kosta.finalproject.lego.vo.DaysVO;
import org.kosta.finalproject.lego.vo.MemberVO;
import org.kosta.finalproject.lego.vo.SkillsVO;
import org.kosta.finalproject.lego.vo.TimesVO;
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

	@Override
	public List<CategoryVO> getCategory() {
		return memberMapper.getCategory();
	}

	@Override
	public List<SkillsVO> getSkills() {
		
		return memberMapper.getSkills();
	}

	@Override
	public List<DaysVO> getDays() {
		// TODO Auto-generated method stub
		return memberMapper.getDays();
	}

	@Override
	public List<TimesVO> getTimes() {
		// TODO Auto-generated method stub
		return memberMapper.getTimes();
	}

	
}
