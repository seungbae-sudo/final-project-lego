package org.kosta.finalproject.lego.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.finalproject.lego.vo.QnACommentVO;
import org.kosta.finalproject.lego.vo.QnAVO;

@Mapper
public interface QnAMapper {
	
	void writeQnA(QnAVO qnaVO);
	
	List<QnAVO> findQnAList();
	
	void writeQnAComment(QnACommentVO qnaCommentVO);
	
	QnAVO qnaDetail(int qnaNo);
	
	List<QnACommentVO> findQnACommentList();
}
