package semi.Project.muktopia.member.model.service;


import static semi.Project.muktopia.common.JDBCTemplate.*;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import semi.Project.muktopia.member.model.dao.MemberDAO;
import semi.Project.muktopia.member.model.vo.Member;
import semi.Project.muktopia.member.model.vo.Restaurant;


public class MemberService {
	private MemberDAO dao = new MemberDAO();

	Connection conn = getConnection();
	public Member login(Member mem) throws Exception{
		Connection conn = getConnection();
		Member loginmember = dao.login(conn,mem);
		close(conn);
		return loginmember;
	}
	public Member selectOne(String memberEmail) throws Exception{
		Member member = dao.selectOne(conn, memberEmail);
		
		close(conn);
		return member;
	}
	public int emailDupCheck(String memberEmail) throws Exception {
		Connection conn = getConnection();
		int result = dao.emailDupCheck(conn, memberEmail);
		close(conn);
		return result;
	}
	public int insertCertification(String inputEmail, String cNumber) throws Exception {
		Connection conn = getConnection();
		int result =dao.updateCertification(conn,inputEmail,cNumber);
		// 1) 입력한 이메일과 일치하는 값이 있으며 수정(update)
		
		// 2) 일치하는 이메일이 없는 경우 -> 처음으로 인증하는 경우 삽입(insert)
		if(result == 0) {
		result = dao.insertCertification(conn, inputEmail, cNumber);
		}
		if(result  > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	public int checkNumber(String cNumber, String inputEmail) throws Exception {
		int result = 0;
		try {
			Connection conn = getConnection();
			result = new MemberDAO().checkNumber(conn, cNumber, inputEmail);
		}finally {
			close(conn);
		}
		return result;
	}
	public int selectNick(String memberNickname) throws Exception{
		int result = 0;
		try {
			Connection conn = getConnection();
			result = new MemberDAO().selectNick(conn,memberNickname);
		}finally {
			close(conn);
		}
		return result;
	}
	public int selectTel(String memberTel) throws Exception{
		int result = 0;
		try {
			Connection conn = getConnection();
			result = new MemberDAO().selectTel(conn,memberTel);
		}finally {
			close(conn);
		}
		return result;
	}
	public int signUpEnd(String memberEmail, String memberPw, String memberNickname, String memberTel, String memberBirth, String[] memberAddr) throws Exception {
			Connection conn = getConnection();
			int result = new MemberDAO().signUpEnd(conn,memberEmail,memberPw,memberNickname,memberTel, memberBirth, memberAddr);
			if(result  > 0) commit(conn);
			else rollback(conn);
			close(conn);
			return result;
		
	}
	
	public int secession(String memberEmail) throws Exception {
		Connection conn = getConnection();
		
		int result = new MemberDAO().secession(conn,memberEmail);
		if(result > 0) commit(conn);
		else rollback(conn);
		return result;		
	}
	public int checkSecession(String storeEmail, String secessionPw) throws Exception {
		Connection conn = getConnection();
		int result = new MemberDAO().checkSecession(conn, storeEmail, secessionPw);
		if(result > 0) commit(conn);
		else rollback(conn);
		return result;
	}
	public Member loginKakao(Member mem) throws Exception{
		Connection conn = getConnection();
		Member result = null;
		result = new MemberDAO().loginKakao(conn,mem);
		return result;
	}
	public int signUpKakao(String kakaoEmail, String kakaoNickname, String kakaoImage) throws Exception{
		Connection conn = getConnection();
		int result = new MemberDAO().signUpKakao(conn, kakaoEmail,kakaoNickname, kakaoImage);
		if(result > 0) commit(conn);
		else rollback(conn);
		return result;
	}
	
	public List<Restaurant> getMark(String name) throws Exception{
		Connection conn = getConnection();
		List<Restaurant> rest;
		try {
			rest = new MemberDAO().getMark(conn,name);
		}finally {
			close(conn);
		}
		return rest;
	}
	
	public int updateInfo(int memberNo, String inputNickname, String inputTel, String inputBirth, String[] inputAddr) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.updateInfo(conn, memberNo, inputNickname, inputTel, inputBirth, inputAddr);
		
		if(result > 0) commit(conn); 
		else 		   rollback(conn);
		
		close(conn);
		
		return result;
	}
	
	public int updateProfileImage(int memberNo, String profileImage) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.updateProfileImage(conn, memberNo, profileImage);
	
		
		// 트랜잭션 
		if(result > 0) commit(conn);
		else 		   rollback(conn);
		
		close(conn);
		
		return result;		
	}

	
	
	
	
//	/** 프로필 이미지 변경
//	 * @param conn
//	 * @param memberNo
//	 * @param profileImage
//	 * @return
//	 */
//	public int updateProfileImage(Connection conn, int memberNo, String profileImage) throws Exception {
//		
//		int result = 0; 
//		
//		try {
//			
//			String sql = prop.getProperty("updateProfileImage");
//			
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, profileImage);
//			pstmt.setInt(2, memberNo);
//			
//			result = pstmt.executeUpdate();
//      
//		} finally {
//			close(pstmt);
//		}
//		return result;
//	}
//	
//	
//	
//	/** 프로필 정보 변경 
//	 * @param conn
//	 * @param memberNo
//	 * @param inputNickname
//	 * @param inputTel
//	 * @param inputBirth
//	 * @param inputAddr
//	 * @return
//	 * @throws SQLException 
//	 */
//	public int updateInfo(Connection conn, int memberNo, String inputNickname, String inputTel, String inputBirth,
//			String[] inputAddr) throws SQLException {
//		
//		int result = 0; 
//		
//		try {
//			String sql = prop.getProperty("updateInfo");
//			
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(1, inputNickname);
//			pstmt.setString(2, inputTel);
//			pstmt.setString(3, inputBirth);
//			
//			String address = String.join(",,", inputAddr);
//
//			pstmt.setString(4, address);
//			
//			pstmt.setInt(5,memberNo);
//			
//			result = pstmt.executeUpdate();
//			
//		} finally {
//			close(pstmt);
//		}
//		
//		return result;
//	}

}
