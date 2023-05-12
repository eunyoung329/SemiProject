package semi.Project.muktopia.member.model.service;

import static semi.Project.muktopia.common.JDBCTemplate.close;
import static semi.Project.muktopia.common.JDBCTemplate.commit;
import static semi.Project.muktopia.common.JDBCTemplate.getConnection;
import static semi.Project.muktopia.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import semi.Project.muktopia.board.model.vo.Board;
import semi.Project.muktopia.member.model.dao.AdminDAO;
import semi.Project.muktopia.member.model.vo.Admin;
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
	
	

	
	public Admin selectOne(String memberEmail)throws Exception {
		
       Connection conn = getConnection();
		
		Admin admin = dao.selectOne(conn, memberEmail);
		
		close(conn);
		
		return admin; 
		
		
		
		
		
	}

	public List<Admin> AdminReportAll() throws Exception{
		//connection 생성
				Connection conn=getConnection();
				
				//DAO 메서드 호출 후 결과반환받기
				List<Admin> stdList=dao.AdminReportAll(conn);
				
				
				//트랜잭션 처리(DML인경우에만)
				
				//Connection반환
				close(conn);
				
				//결과반환
				return stdList;
	}


	public int adminRegisterRest( String rest_category, String rest_name, String rest_img, String rest_x,
			String rest_y, String rest_tel,String rest_time, String rest_sns, String rest_Addr, String rest_contents)throws Exception {

		 Connection conn=getConnection();
         int result=dao.adminRegisterRest(conn,rest_category,rest_name,rest_img,rest_x,rest_y,rest_tel,rest_time,rest_sns, rest_Addr,rest_contents);
         if(result>0) commit(conn);
         else rollback(conn);
         close(conn);
         return result;
	}


	public int DeleteReport(String memberNo)throws Exception {
		Connection conn=getConnection();
		int result=dao.deleteReport(conn,memberNo);
		 if(result>0) commit(conn);
        else rollback(conn);
		close(conn);
		return result;
	}

}
