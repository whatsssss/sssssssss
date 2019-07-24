package org.zercok.controller;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml" })

@Log4j

public class BoardMapperTests {

	@Setter(onMethod = @__({ @Autowired })) // @setter추가
	private BoardMapper mapper;
	private WebApplicationContext ctx;

	private MockMvc mockMvc;


	@Test
	public void testList() throws Exception {

		log.info(
				mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn().getModelAndView().getModelMap());
	}

	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}

	@Test
	public void testGetList1() {

		int size = mapper.getList().size();
		log.info(size);

		log.info(mapper.getList().get(0));
	}

	@Test
	public void testInsert() {

		IntStream.rangeClosed(1, 100).forEach(i -> {

			BoardVO vo = new BoardVO();
			vo.setTitle("새로작성하는글33");
			vo.setContent("댓글 테스트 " + i);
			vo.setWriter("replyer" + i);

			mapper.insert(vo);
		});
	}

	@Test
	public void read() {
		// TODO Auto-generated method stub

		// 존재하는 게시물 번호로 테스트
		BoardVO board = mapper.select(107L);
		log.info(board);

		// ㅠㅠ

	}

	@Test
	public void delete() {
		mapper.delete(107L);
	}

	
	
	@Test
	public void testUpdate() {
		
		BoardVO vo = mapper.select(106L);
		vo.setTitle("수정된 제목");
		vo.setContent("수정된 내용");
		
		int count = mapper.update(vo);
		
		log.info("update count: " + count);
		
	}

	@Test
	public void testInsertKey() {

		BoardVO vo = new BoardVO();
		vo.setTitle("새로작성하는글22");
		vo.setContent("댓글 테스트 ");
		vo.setWriter("replyer");

	};

}
