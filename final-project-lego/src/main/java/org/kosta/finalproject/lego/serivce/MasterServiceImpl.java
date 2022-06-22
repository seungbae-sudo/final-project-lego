package org.kosta.finalproject.lego.serivce;

import java.util.List;

import org.kosta.finalproject.lego.mapper.MasterMapper;
import org.kosta.finalproject.lego.vo.Authority;
import org.kosta.finalproject.lego.vo.CategoryVO;
import org.kosta.finalproject.lego.vo.DaysVO;
import org.kosta.finalproject.lego.vo.MasterDetailVO;
import org.kosta.finalproject.lego.vo.MasterVO;
import org.kosta.finalproject.lego.vo.MemberVO;
import org.kosta.finalproject.lego.vo.SkillsVO;
import org.kosta.finalproject.lego.vo.TimesVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MasterServiceImpl implements MasterService {
	private final MasterMapper masterMapper;

	@Override
	@Transactional
	public void registerMember(MemberVO memberVO) {
		masterMapper.registerMember(memberVO);
		Authority aurhority = new Authority(memberVO.getId(), "member");
		masterMapper.masterRegisterRole(aurhority);
		
	}
	
	@Override
	public List<CategoryVO> getCategory() {
		return masterMapper.getCategory();
	}

	@Override
	public List<SkillsVO> getSkills() {
		
		return masterMapper.getSkills();
	}

	@Override
	public List<DaysVO> getDays() {
		// TODO Auto-generated method stub
		return masterMapper.getDays();
	}

	@Override
	public List<TimesVO> getTimes() {
		// TODO Auto-generated method stub
		return masterMapper.getTimes();
	}

	@Override
	public void registerMaster(MasterVO masterVO) {
		masterMapper.registerMaster(masterVO);		
	}

	@Override
	public void registerSkills(MasterDetailVO masterDetailVO) {
		masterMapper.registerSkills(masterDetailVO);
		
	}

	@Override
	public void registerDays(MasterDetailVO masterDetailVO) {
		masterMapper.registerDays(masterDetailVO);
		
	}

	@Override
	public void registerTimes(MasterDetailVO masterDetailVO) {
		masterMapper.registerTimes(masterDetailVO);
		
	}

}
