package org.kosta.finalproject.lego.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.finalproject.lego.vo.MemberVO;

@Mapper
public interface MemberMapper {

	MemberVO findMemberById(String id);

}
