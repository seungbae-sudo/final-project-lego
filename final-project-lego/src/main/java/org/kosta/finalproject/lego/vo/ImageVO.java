package org.kosta.finalproject.lego.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageVO {
	private int imageNo;
	private String imageName;
	private MemberVO memberVO;
	
}
