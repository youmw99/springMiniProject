package com.ggu.guestbook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GuestDao {

	@Autowired
	private SqlSession sqlSession;

	public void create(GuestVo GuestVo) throws Exception {
		sqlSession.insert("guestbook.create", GuestVo);
	}

	public void insertSelectKey(GuestVo GuestVo) {
		sqlSession.insert("guestbook.insertSelectKey", GuestVo);
	}

	public List<GuestVo> selectlist() throws Exception {
		return sqlSession.selectList("guestbook.selectboard");
	}

	public void delete(long bno) throws Exception {
		sqlSession.delete("guestbook.delete", bno);
	}
	
	public void update(GuestVo GuestVo) {
		sqlSession.update("guestbook.update", GuestVo);
	}

}
