package org.kosta.finalproject.lego.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingVO {
	private int bookingNo;
	private String condition;
	private String bookingDay;
	private String bookingContent;
	private String bookingTimes;
	private MasterDetailVO mdVO;
	private MemberVO mvo;
	private CategoryVO cvo;
}
