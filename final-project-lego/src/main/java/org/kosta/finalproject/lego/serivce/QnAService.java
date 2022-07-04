package org.kosta.finalproject.lego.serivce;

import org.kosta.finalproject.lego.vo.QnAVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QnAService {

	Page<QnAVO> pageList(Pageable pageable);

}