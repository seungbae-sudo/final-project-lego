package org.kosta.finalproject.lego.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.finalproject.lego.vo.BoardCategoryVO;
import org.kosta.finalproject.lego.vo.BoardVO;
import org.kosta.finalproject.lego.vo.CommentVO;

@Mapper
public interface CommunityBoardMapper {
	void posting(BoardVO boardVO);

	BoardCategoryVO findBCVO(int categoryNo);

	List<BoardVO> findAllCommunityList(int categoryNo);

	BoardVO findBoardDetailByBoardNo(int boardNo);

	void updateByBoardVO(BoardVO bvo);

	void deleteByBoardVO(BoardVO bvo);

	void writeComment(CommentVO commentVO);

	List<CommentVO> findCommentList(int boardNo);

	void updateHits(int boardNo);

	void deleteComment(int commentNo);

	void likesUp(int boardNo);

	void likesDown(int boardNo);

}
