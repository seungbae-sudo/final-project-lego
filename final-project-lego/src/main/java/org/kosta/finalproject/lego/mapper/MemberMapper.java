
package org.kosta.finalproject.lego.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.finalproject.lego.vo.Authority;
import org.kosta.finalproject.lego.vo.MemberVO;

@Mapper
public interface MemberMapper {

	void registerMember(MemberVO memberVO);

	void memberRegisterRole(Authority aurhority);

}
package org.kosta.finalproject.lego.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.finalproject.lego.vo.Authority;
import org.kosta.finalproject.lego.vo.MemberVO;

@Mapper
public interface MemberMapper {

	void registerMember(MemberVO memberVO);

	void memberRegisterRole(Authority aurhority);

}
