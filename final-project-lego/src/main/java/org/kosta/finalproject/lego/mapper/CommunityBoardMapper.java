package org.kosta.finalproject.lego.mapper;


import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.finalproject.lego.vo.BoardCategoryVO;
import org.kosta.finalproject.lego.vo.BoardVO;

@Mapper
public interface CommunityBoardMapper {
	void posting(BoardVO boardVO);

	BoardCategoryVO findBCVO(int categoryNo);

	List<BoardVO> findAllCommunityList(int categoryNo);

	BoardVO findBoardDetailByBoardNo(int boardNo);

	BoardVO updateByBoardNo(int boardNo);

	
}
