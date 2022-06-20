package org.kosta.finalproject.lego.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.finalproject.lego.vo.CategoryVO;

@Mapper
public interface MemberMapper {

	List<CategoryVO> getCategory();

}
