package com.jeong.org.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class boardService {

	@Autowired
	boardDAO bd;
	

	public List<boardDTO> boardall(int pagenum,int pagecount){
		PageDAO pdao = new PageDAO();
		
		pdao.setPagenum(pagenum);
		pdao.setPagecount(pagecount);
		
		return bd.boardall(pdao);
	}
	
	public boardDTO boardselect(boardDTO board) {
		
		return bd.boardselect(board);
	}
	
	public void insertboard(boardDTO boardDTO) {
		
		bd.insertboard(boardDTO);
	}
	
	public void updateboard(boardDTO board) {
		
		bd.updateboard(board);
	}
	
	public void deleteboard(boardDTO board) {
		
		bd.deleteboard(board);
	}
	
	public int pagecount() {
		
		int count = bd.pagecount();
		
		return count;
	}
	
	public void boardread_cnt(boardDTO board) {
		
		bd.boardread_cnt(board);
	}
}
