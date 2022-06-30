package org.kosta.finalproject.lego.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingVO {
	private int bookingNo;
	private String bookingDay;
	private String bookingContent;
	private MasterDetailVO mdVO;
	private MemberVO mvo;
	private CategoryVO cvo;
}
