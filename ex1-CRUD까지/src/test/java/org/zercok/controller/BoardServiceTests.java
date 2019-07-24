package org.zercok.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml" })

@Log4j

public class BoardServiceTests {

	@Setter(onMethod = @__({ @Autowired })) // @setter추가
	private BoardService service;
	

	@Test
	public void testGetone() {

		BoardVO board = service.read(2L);
		log.info(board);
	}
	
	@Test
	public void testGetList() {

		service.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void delete() {
		service.delete(100L);
	}
	
	@Test
	public void update() {
		BoardVO vo = service.read(106L);
		vo.setTitle("수정된 제목");
		vo.setContent("수정된 내용");
		
		int count = service.update(vo);
		
	}

	


}
