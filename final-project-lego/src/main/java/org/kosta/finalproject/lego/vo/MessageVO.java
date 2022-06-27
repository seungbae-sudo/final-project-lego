package org.kosta.finalproject.lego.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageVO {
	private int messageNo;
	private String messageContent;
	private MemberVO reMvo;
	private MemberVO sendMvo;
	private String receiveDate;
}
