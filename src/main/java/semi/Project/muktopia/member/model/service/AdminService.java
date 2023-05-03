package semi.Project.muktopia.member.model.service;

import static semi.Project.muktopia.common.JDBCTemplate.close;
import static semi.Project.muktopia.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import semi.Project.muktopia.board.model.vo.Board;
import semi.Project.muktopia.member.model.dao.AdminDAO;

import semi.Project.muktopia.member.model.vo.Member;


public class AdminService {
	
	
	private AdminDAO dao = new AdminDAO();
	
	Connection conn = getConnection();

	public Member adminlogin(Member mem) throws Exception{
	     Connection conn = getConnection();
			
			// DAO 수행
			Member loginMember = dao.adminlogin(conn, mem);
			
			// Connection 반환
			close(conn);
			
			// 결과 반환
			return loginMember;
	}

	public List<Board> showList() throws Exception {
		Connection conn = getConnection();
		List<Board> showList = dao.showList(conn);
		return showList;
	}
	
}
