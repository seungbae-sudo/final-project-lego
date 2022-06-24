package org.kosta.finalproject.lego.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MasterVO {
	private CategoryVO category;
	private String id;
	private String career;
	private String specifications;
	private String name;
}
