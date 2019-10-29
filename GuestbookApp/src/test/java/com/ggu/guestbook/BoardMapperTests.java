package com.ggu.guestbook;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BoardMapperTests {

	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void testInsert() {
		GuestVo guest = new GuestVo();
		guest.setTitle("새로 작성하는 글");
		guest.setContent("새로 작성하는 내용");
		guest.setWriter("newbie");
		
		sqlSession.insert("Guest.create",guest);
		
	}
	
	@Test
	public void testRead() {
		
		GuestVo v = (GuestVo) sqlSession.selectList("guestbook.selectboard");
		v.getBno();
		v.getTitle();
		v.getWriter();
		v.getContent();
		v.getRegdate();
	}
}
