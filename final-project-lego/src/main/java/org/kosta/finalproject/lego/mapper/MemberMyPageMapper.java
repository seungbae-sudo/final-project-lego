package org.kosta.finalproject.lego.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.finalproject.lego.vo.BoardVO;
import org.kosta.finalproject.lego.vo.MemberVO;

@Mapper
public interface MemberMyPageMapper {

	void updateMember(MemberVO memberVO);

	List<BoardVO> findWroteList(String id);

}
