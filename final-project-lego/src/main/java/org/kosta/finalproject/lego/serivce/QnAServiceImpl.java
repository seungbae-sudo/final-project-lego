package org.kosta.finalproject.lego.serivce;

import org.kosta.finalproject.lego.repository.QnARepository;
import org.kosta.finalproject.lego.vo.QnAVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QnAServiceImpl implements QnAService {
	QnARepository qnaRepository;
	@Override
	@Transactional(readOnly = true)
	public Page<QnAVO> pageList(Pageable pageable) {
		return qnaRepository.findAll(pageable);
	}

}
