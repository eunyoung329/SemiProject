package semi.Project.muktopia.member.model.service;


import static semi.Project.muktopia.common.JDBCTemplate.*;

import java.sql.Connection;

import semi.Project.muktopia.member.model.dao.MemberDAO;
import semi.Project.muktopia.member.model.vo.Member;


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
	public int signUpEnd(String memberEmail, String memberPw, String memberNickname, String memberTel) throws Exception {
			Connection conn = getConnection();
			int result = new MemberDAO().signUpEnd(conn,memberEmail,memberPw,memberNickname,memberTel);
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
	public int signUpKakao(String kakaoEmail, String kakaoNickname) throws Exception{
		Connection conn = getConnection();
		int result = new MemberDAO().signUpKakao(conn, kakaoEmail, kakaoNickname);
		if(result > 0) commit(conn);
		else rollback(conn);
		return result;
	}
}
