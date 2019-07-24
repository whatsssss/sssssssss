package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {

	//@Select("select * from tbl_board where bno>0")
	public List<BoardVO> getList();
	
	//@Insert("insert into tbl_board (title, content, writer) values (#{title} , #{content} , #{writer} )" )
	public void insert(BoardVO board);
	 
	// seq_ oracle 인듯....  
	//public void insertSelectKey(BoardVO board);
	
	
	@Select("select * from tbl_board where bno = #{bno}")
	public BoardVO select(Long bno);
	
	@Delete("delete from tbl_board where bno = #{bno}")	
	public void delete(Long bno);

	public int update(BoardVO vo);
	

}
