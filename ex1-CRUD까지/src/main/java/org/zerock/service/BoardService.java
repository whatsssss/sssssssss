package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
@Service			//service 등록 ㅠㅠ

public interface BoardService {
	

	public BoardVO read(Long bno);

	public void delete(Long bno);

	public int update(BoardVO board);

	public List<BoardVO> getList();
	
	//board/register
	public void register(BoardVO board);
	

}
