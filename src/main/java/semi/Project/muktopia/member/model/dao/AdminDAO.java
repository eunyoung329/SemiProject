package semi.Project.muktopia.member.model.dao;

import static semi.Project.muktopia.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import semi.Project.muktopia.member.model.vo.Member;


public class AdminDAO {
	
	Statement st;
	PreparedStatement pstmt;
	ResultSet rs;
	Properties prop;
	public AdminDAO() {
		try {
			prop = new Properties();
			String filePath = AdminDAO.class.getResource("/semi/Project/muktopia/sql/admin-sql.xml").getPath();
			prop.loadFromXML(new FileInputStream (filePath));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	public Member adminlogin(Connection conn, Member mem) throws Exception{

		// 결과 저장용 변수 선언
		Member loginMember = null;
		
		try {
			// SQL 얻어오기
			String sql = prop.getProperty("adminlogin");
			
			// PreparedStatement 생성 및 SQL 적재
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mem.getMemberEmail());
			pstmt.setString(2, mem.getMemberPw());
			
			// SQL 수행
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				loginMember = new Member();
				
				loginMember.setMemberNo(  rs.getInt("MEMBER_NO") );
				loginMember.setMemberEmail( 	rs.getString("MEMBER_EMAIL") );
				
				
				
				
			}
			
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return loginMember; // null 또는 Member 객체 주소
	}
		
		
		
	}


