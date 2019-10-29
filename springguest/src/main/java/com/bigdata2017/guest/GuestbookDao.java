package com.bigdata2017.guest;

import com.bigdata2017.guest.GuestbookVo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GuestbookDao {

	@Autowired
	private SqlSession sqlSession;

	public void create(GuestbookVo GuestbookVo) throws Exception {
		sqlSession.insert("Guestbook.create", GuestbookVo);
	}

	public GuestbookVo read(Integer num) throws Exception {
		return sqlSession.selectOne("Guestbook.read", num);
	}

	public void update(GuestbookVo GuestbookVo) throws Exception {
		sqlSession.update("Guestbook.update", GuestbookVo);
	}

	public void delete(Integer num) throws Exception {
		sqlSession.delete("Guestbook.delete", num);
	}

	public List<GuestbookVo> selectlist() throws Exception {
		return sqlSession.selectList("Guestbook.selectGuestbook");
	}

}


/*
public class GuestbookDao {
	public int delete( GuestbookVo vo ) {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = 
				" delete" + 
				"   from guestbook" + 
				"  where no=?" +
				"    and password=?";
			pstmt = conn.prepareStatement( sql );

			pstmt.setLong( 1, vo.getNo() );
			pstmt.setString( 2, vo.getPassword() );

			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error :" + e);
		} finally {
			// 자원 정리
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return count;		
	}
	
	public int insert(GuestbookVo vo) {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = 
				" insert" + 
				"   into guestbook" + 
				" values ( seq_guestbook.nextval, ?, ?, ?, sysdate )";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getContent());

			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("error :" + e);
		} finally {
			// 자원 정리
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return count;
	}

	public List<GuestbookVo> getList() {
		List<GuestbookVo> list = new ArrayList<GuestbookVo>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			// Statement 객체 생성
			stmt = conn.createStatement();

			// SQL문 실행
			String sql =
				"   select no," + 
				"          name," + 
				"	       content," + 
				"     	   to_char(reg_date, 'yyyy-mm-dd hh:mi:ss')" + 
				"     from guestbook" + 
				" order by reg_date desc";
			rs = stmt.executeQuery( sql );

			// 결과 가져오기(사용하기)
			while (rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String content = rs.getString(3);
				String regDate = rs.getString(4);

				GuestbookVo vo = new GuestbookVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setContent( content );
				vo.setRegDate( regDate );

				list.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("error :" + e);
		} finally {
			// 자원 정리
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	private Connection getConnection() throws SQLException {

		Connection conn = null;

		try {
			// JDBC 드라이버 로딩(JDBC 클래스 로딩)
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// Connection 가져오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}

		return conn;
	}	
}
*/