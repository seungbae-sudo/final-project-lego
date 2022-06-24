package org.kosta.finalproject.lego.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.finalproject.lego.vo.MasterVO;
import org.kosta.finalproject.lego.vo.MemberVO;

@Mapper
public interface MasterMyPageMapper {

	void updateMaster(MemberVO memberVO);
	
	MasterVO findMasterDetailList(String id);


}
