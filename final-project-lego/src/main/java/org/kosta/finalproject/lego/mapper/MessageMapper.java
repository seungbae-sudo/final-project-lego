package org.kosta.finalproject.lego.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.finalproject.lego.vo.MessageVO;

@Mapper
public interface MessageMapper {
	void message(MessageVO messageVO);
}
