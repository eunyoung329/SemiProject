package semi.Project.muktopia.member.model.service;

import static semi.Project.muktopia.common.JDBCTemplate.close;
import static semi.Project.muktopia.common.JDBCTemplate.commit;
import static semi.Project.muktopia.common.JDBCTemplate.getConnection;
import static semi.Project.muktopia.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import semi.Project.muktopia.board.model.vo.Board;
import semi.Project.muktopia.member.model.dao.AdminDAO;

import semi.Project.muktopia.member.model.vo.Member;
import semi.Project.muktopia.member.model.vo.Restaurant;


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

	public int boardDelete(int id) throws Exception {
		Connection conn = getConnection();
		int result = dao.boardDelete(conn, id);
		
		if(result >0)	commit(conn);
		else			rollback(conn);
		close(conn);
		
		return result;
	}
	
	/** 회원전체 목록을 가져오는 service
	 * @return
	 */
	public List<Member> memberLoad() throws Exception {
		Connection conn= getConnection();
		List<Member> memberList =  dao.memberLoad(conn);
		
		return memberList;
	}

	/** 멤버를 탈퇴시키는 service
	 * @return
	 */
	public int DeleteMember(int memberNo) throws Exception{
		
		Connection conn= getConnection();
		int result = dao.DeleteMember(conn, memberNo);
		
		if(result  > 0) commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;
	}

	public List<Restaurant> restLoad() throws Exception{
		Connection conn = getConnection();
		List <Restaurant> restList = dao.restLoad(conn);
		
		return restList;
	}

	public int deleteRest(String restId) throws Exception {
		Connection conn = getConnection();
		int result = dao.deleteRest(conn, restId);
		
		if(result  > 0) commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;
	}
	
	
}
