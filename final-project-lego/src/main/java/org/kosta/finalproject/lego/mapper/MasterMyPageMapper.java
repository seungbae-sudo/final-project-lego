package org.kosta.finalproject.lego.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.finalproject.lego.vo.MemberVO;

@Mapper
public interface MasterMyPageMapper {

	void updateMaster(MemberVO memberVO);
	
}
