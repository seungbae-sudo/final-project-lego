package org.kosta.finalproject.lego.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MasterDetailVO {
	private int skillsId;
	private String skills;
	private int timesId;
	private int daysId;
	private String id;
}
