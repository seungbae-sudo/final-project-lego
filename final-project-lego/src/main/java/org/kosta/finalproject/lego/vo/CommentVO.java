package org.kosta.finalproject.lego.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CommentVO {
	private int commentNo;
	private String commentContent;
	private int boardNo;
	private String id;
}
