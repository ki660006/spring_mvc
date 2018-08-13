package com.jeong.org.board;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class boardController {

	@Autowired
	boardService bsv;

	@Autowired
	boardDTO bdto;
	

	private static final Logger logger = LoggerFactory.getLogger(boardController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String board(Locale locale, Model model,HttpServletRequest request) {

		PageDAO pdao = new PageDAO();
		
		String pagenum = request.getParameter("pagenum");
		String contentnum = request.getParameter("pagecount");
		
		int cpagenum = Integer.parseInt(pagenum);
		int ccontentnum = Integer.parseInt(contentnum);
		
		pdao.setTotal(bsv.pagecount());
		pdao.setPagenum(cpagenum-1);
		pdao.setPagecount(ccontentnum);
		pdao.setCurrentblock(cpagenum);
		pdao.setLastblock(pdao.getTotal());;
		
		pdao.prevnext(cpagenum);//현재 페이지 번호로 화살표를 나타낼지 정함
		pdao.setStartpage(pdao.getCurrentblock());//시작 페이지를 페이지 블록 번호로 정한다.
		pdao.setEndpage(pdao.getLastblock(), pdao.getCurrentblock());//마지막 페이지를 페이지 블록과 현재 페이지 블록 번호로 정한다.
		
		System.out.println(cpagenum);
		
		List<boardDTO> list = bsv.boardall(pdao.getPagenum()*10, pdao.getPagecount());
		model.addAttribute("list", list);
		model.addAttribute("page", pdao);
		return "Freeboard";
	}

	@RequestMapping(value = "/boardwrite", method = RequestMethod.GET)
	public String boardwrite(Locale locale, Model model) {

		return "Freeboardwrite";
	}

	@RequestMapping(value = "/boardwriteproc", method = RequestMethod.GET)
	public String boardwriteproc(Locale locale, Model model, @ModelAttribute boardDTO board) {

//		bdto.setBoard_title(board_title);
//		bdto.setBoard_content(board_contnet);
//		bdto.setBoard_title(board_title);

		bsv.insertboard(board);

		return "redirect:/board?pagenum=1&pagecount=10";
	}
	
	@RequestMapping(value = "/boardview", method = RequestMethod.GET)
	public String boardview(Locale locale, Model model,@ModelAttribute boardDTO board) {

		bsv.boardread_cnt(board);
		
		
		boardDTO boardDTO = bsv.boardselect(board);
		model.addAttribute("boardDTO", boardDTO);
		
		return "Freeboardview";
	}
	
	@RequestMapping(value = "/boardupd", method = RequestMethod.GET)
	public String boardupdate(Locale locale, Model model,@ModelAttribute boardDTO board) {

		boardDTO boardDTO = bsv.boardselect(board);
		model.addAttribute("boardDTO",boardDTO);
		
		return "Freeboardupd";
	}
	
	
	@RequestMapping(value = "/boardupdproc", method = RequestMethod.GET)
	public String boardupdateproc(Locale locale, Model model,@ModelAttribute boardDTO board) {

		bsv.updateboard(board);
		
		return "redirect:/board?pagenum=1&pagecount=10";
	}
	
	@RequestMapping(value = "/boarddel", method = RequestMethod.GET)
	public String boarddelete(Locale locale, Model model,@ModelAttribute boardDTO board) {

		bsv.deleteboard(board);
		
		return "redirect:/board?pagenum=1&pagecount=10";
	}
}
