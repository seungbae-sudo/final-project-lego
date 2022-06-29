package org.kosta.finalproject.lego.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.finalproject.lego.vo.ImageVO;
@Mapper
public interface ImageMapper {
	
	void uploadImage(ImageVO imageVO);
}
