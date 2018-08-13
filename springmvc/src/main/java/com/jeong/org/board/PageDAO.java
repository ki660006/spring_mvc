package com.jeong.org.board;

public class PageDAO {

	private int total; // 전체 게시물 개수
	private int pagenum; // 현재 페이지 번호
	private int pagecount = 10; // 한 페이지에 몇개 표시
	private int startpage = 1; // 현재 페이지 블록의 시작 페이지
	private int endpage = 5; // 현재 페이지 블록의 마지막 페이지
	private boolean prev = false; // 이전 페이지로 가는 화살표
	private boolean next; // 다음 페이지로 가는 화살표
	private int currentblock; // 현재 페이지 블록
	private int lastblock; // 마지막 페이지 블록
	
	public void prevnext(int pagenum) {
		if(pagenum>0 && pagenum<6) {
			setPrev(false);
			setNext(true);
		}else if(getLastblock() == getCurrentblock()) {
			setPrev(true);
			setNext(false);
		}else {
			setPrev(true);
			setNext(true);
		}
	}
	
	public int calcpage(int total,int pagecount) {
		
		// 125 / 10 -> 12.5
		// 13페이지
		
		// 50 / 10 -> 5
		// 5페이지
		
		int totalpage = total / pagecount;
		if(total % pagecount>0) {
			totalpage++;
		}
		return totalpage;
	}
	
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	public int getPagecount() {
		return pagecount;
	}
	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}
	public int getStartpage() {
		return startpage;
	}
	public void setStartpage(int currentblock) {
		this.startpage = (currentblock*5)-4;
		//1 - 1 2 3 4 5
		//2 - 6 7 8 9 10
		//3 - 11 12 13
	}
	public int getEndpage() {
		return endpage;
	}
	public void setEndpage(int getlastblock,int getcurrentblock) {
		if(getlastblock == getcurrentblock) {
			this.endpage = calcpage(getTotal(),getPagecount());
		}
		else {
			this.endpage = getStartpage()+4;
		}
		this.endpage = endpage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getCurrentblock() {
		return currentblock;
	}
	public void setCurrentblock(int pagenum) {
		// 페이지 번호를 통해서 구한다.
		this.currentblock = pagenum/5;
		if(pagenum%5>0) {
			this.currentblock++;
		}
	}
	public int getLastblock() {
		return lastblock;
	}
	public void setLastblock(int total) {
		//10 , 5 -> 10 * 5 -> 50
		//125 / 50
		//3
		this.lastblock = total / (5*this.pagecount);
		if (total%(5*this.pagecount)>0) {
			this.lastblock++;
		}
	}
	
	
	
	
}
