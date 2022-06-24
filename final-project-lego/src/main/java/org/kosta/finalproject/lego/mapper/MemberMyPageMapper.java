package org.kosta.finalproject.lego.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.finalproject.lego.vo.MemberVO;

@Mapper
public interface MemberMyPageMapper {

	void updateMember(MemberVO memberVO);

}
