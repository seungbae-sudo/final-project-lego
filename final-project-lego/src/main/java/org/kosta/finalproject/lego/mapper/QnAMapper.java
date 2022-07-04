package org.kosta.finalproject.lego.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.kosta.finalproject.lego.vo.QnACommentVO;
import org.kosta.finalproject.lego.vo.QnAVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

@Mapper
public interface QnAMapper extends JpaRepository<QnAVO, Integer>{
	
	void writeQnA(QnAVO qnaVO);
	
	Page<QnAVO> findQnAList( Pageable pageable);
	
	void writeQnAComment(QnACommentVO qnaCommentVO);
	
	QnAVO qnaDetail(int qnaNo);
	
	Page<QnACommentVO> findQnACommentList(Pageable pageable);

	//void deleteQna(int qnaNo);

	void updateQnA(QnAVO qnaVO);
}
