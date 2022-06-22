package org.kosta.finalproject.lego.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private int categoryNo;
	private int hits;
	private String boardDate;
	private int likes;
	private String id;
	
	
}
