package org.kosta.finalproject.lego.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ReviewVO {
	private int reviewNo;
	private int score;
	private String reviewContent;
	private MemberVO mvo;
	private MasterVO msvo;
}
