package org.kosta.finalproject.lego.mapper;


import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.finalproject.lego.vo.BoardCategoryVO;
import org.kosta.finalproject.lego.vo.BoardVO;
import org.kosta.finalproject.lego.vo.CommentVO;
import org.kosta.finalproject.lego.vo.Pagination;

@Mapper
public interface CommunityBoardMapper {
	void posting(BoardVO boardVO);

	BoardCategoryVO findBCVO(int categoryNo);

	List<BoardVO> findAllCommunityList(HashMap<String, Object>map);

	BoardVO findBoardDetailByBoardNo(int boardNo);

	void updateByBoardVO(BoardVO bvo);

	void deleteByBoardVO(BoardVO bvo);

	void writeComment(CommentVO commentVO);

	List<CommentVO> findCommentList(int boardNo);

	void updateHits(int boardNo);

	void deleteComment(int commentNo);

	void likesUp(int boardNo);

	void likesDown(int boardNo);

	List<BoardVO> findCommunityListByTitle(HashMap<String, Object> map);
	
	List<BoardVO> findCommunityListByName(HashMap<String, Object> map);

	int getTotalPostCount(int categoryNo);

	int getTotalSearchList(String keyword);

	int getTotalSearchList2(String keyword);

}
