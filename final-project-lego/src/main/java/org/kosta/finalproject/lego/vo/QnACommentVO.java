package org.kosta.finalproject.lego.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QnACommentVO {
	private int qnaCommentNo;
	private String qnaCommentContent;
	private QnAVO qnaVO;
	private MemberVO memberVO;
}
