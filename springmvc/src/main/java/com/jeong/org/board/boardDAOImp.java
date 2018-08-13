package com.jeong.org.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class boardDAOImp implements boardDAO {
	
	@Autowired
	SqlSession sql;
	
	@Autowired
	PageDAO pdao;
	
	public List<boardDTO> boardall(PageDAO PageDAO){
		List<boardDTO> list = sql.selectList("mappers.selectAllboard",PageDAO);
		return list;
	}
	
	@Override
	public boardDTO boardselect(boardDTO board) {
		
		boardDTO blist = sql.selectOne("mappers.boardselect",board);
		return blist;
	}
	
	@Override
	public void insertboard(boardDTO boardDTO) {
		sql.insert("mappers.insertboard",boardDTO);
	}
	
	@Override
	public void updateboard(boardDTO board) {
		sql.update("mappers.updateboard",board);
	}
	
	@Override
	public void deleteboard(boardDTO board) {
		sql.delete("mappers.deleteboard",board);
	}
	
	@Override
	public int pagecount() {
		int count = sql.selectOne("mappers.pagecount");
		return count;
	};
	
	@Override
	public void boardread_cnt(boardDTO board) {
		
		sql.update("mappers.read_cnt",board);
		
	}
	
	
}
