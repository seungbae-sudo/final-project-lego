package org.kosta.finalproject.lego.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO implements Serializable{

	private static final long serialVersionUID = 7115846846636559419L;
	private String id;
	private String password;
	private String name;
	private String address;
	private String tel;
}
