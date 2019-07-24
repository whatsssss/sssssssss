package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor

public class BoardController {

	private BoardService service;

	@GetMapping("/list")
	public void list(Model model) {

		log.info("list");
		model.addAttribute("list", service.getList());

	}

	@GetMapping("/register")
	public void register() {
		log.info("get register");
	}

	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {

		service.register(board);
		log.info("post register");

		rttr.addFlashAttribute("result", "success");

		return "redirect:/board/list";

	}

	@GetMapping({ "/read", "/modify" })
	public void get(@RequestParam("bno") Long bno, Model model) {

		log.info("get read modify");
		log.info("bno: " + bno);
		model.addAttribute("vo", service.read(bno));
	}

	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {

		service.update(board);
		log.info("post modify....");

		rttr.addFlashAttribute("result", board.getBno());

		return "redirect:/board/list";

	}

	@PostMapping("/delete")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {

		service.delete(bno);
		log.info("post delete....");
		log.info("bno: " + bno);

		return "redirect:/board/list";
	}
}