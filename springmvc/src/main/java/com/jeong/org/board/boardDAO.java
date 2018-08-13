package com.jeong.org.board;

import java.util.List;

public interface boardDAO {

	public List<boardDTO> boardall(PageDAO PageDAO);
	public boardDTO boardselect(boardDTO board);
	public void insertboard(boardDTO boardDTO);
	public void updateboard(boardDTO board);
	public void deleteboard(boardDTO board);
	public void boardread_cnt(boardDTO board);
	public int pagecount();
	
}
