package org.kosta.finalproject.lego.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartMapper {
	
	void addCart(String id, String masterId);

	void deleteCart(String id, String masterId);
	
}
