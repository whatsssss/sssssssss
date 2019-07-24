package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
@Service			//service 등록 ㅠㅠ
@AllArgsConstructor //매퍼등록
public class BoardServiceImpl implements BoardService {

	private BoardMapper mapper;

	@Override
	public BoardVO read(Long bno) {
		// TODO Auto-generated method stub
		return mapper.select(bno);
	}

	@Override
	public void delete(Long bno) {
		mapper.delete(bno);
		
	}



	@Override
	public List<BoardVO> getList() {
		// TODO Auto-generated method stub
		return mapper.getList();
	}

	@Override
	public void register(BoardVO board) {
		
		mapper.insert(board);
		
	}

	@Override
	public int update(BoardVO board) {
		// TODO Auto-generated method stub
		return mapper.update(board);
	}
	


}
