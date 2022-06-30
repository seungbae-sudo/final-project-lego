package org.kosta.finalproject.lego.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.finalproject.lego.vo.MasterVO;
import org.kosta.finalproject.lego.vo.MemberVO;

@Mapper
public interface CartMapper {
	
	void addCart(String id, String masterId);

	void deleteCart(String id, String masterId);
	
}
