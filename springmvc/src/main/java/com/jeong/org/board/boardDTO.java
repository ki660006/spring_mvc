package com.jeong.org.board;

public class boardDTO {
	
	
	private int board_idx;
	private String board_title;
	private String board_content;
	private String name;
	private String board_writetime;
	private int read_count = 0;
	
	
	
	
	@Override
	public String toString() {
		return "boardDTO [board_idx=" + board_idx + ", board_title=" + board_title + ", board_content=" + board_content + ", name="
				+ name + ", board_writetime=" + board_writetime + ", read_count=" + read_count + "]";
	}
	public int getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBoard_writetime() {
		return board_writetime;
	}
	public void setBoard_writetime(String board_writetime) {
		this.board_writetime = board_writetime;
	}
	public int getRead_count() {
		return read_count;
	}
	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}
	
	
	
	
}
