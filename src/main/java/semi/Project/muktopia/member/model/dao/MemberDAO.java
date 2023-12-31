package semi.Project.muktopia.member.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.catalina.authenticator.jaspic.PersistentProviderRegistrations.Property;

import semi.Project.muktopia.member.model.vo.Member;
import semi.Project.muktopia.member.model.vo.Restaurant;


import static semi.Project.muktopia.common.JDBCTemplate.*;


public class MemberDAO {
	Statement st;
	PreparedStatement pstmt;
	ResultSet rs;
	Properties prop;
	public MemberDAO() {
		try {
			prop = new Properties();
			String filePath = MemberDAO.class.getResource("/semi/Project/muktopia/sql/member-sql.xml").getPath();
			prop.loadFromXML(new FileInputStream (filePath));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public Member selectOne(Connection conn, String memberEmail) throws Exception{
		Member member = null;
		try {
			String sql = prop.getProperty("selectOne");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberEmail);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new Member();
				member.setMemberEmail(rs.getString(1));
				member.setMemberNick(rs.getString(2));
				member.setMemberTel(rs.getString(3));
				member.setMemberAddress(rs.getString(4));
				member.setEnrollDate(rs.getString(5));
				System.out.println(member);
			}
		}finally {
			close(rs);
			close(pstmt);
			
		}
		return member;
	}
	public Member login(Connection conn, Member mem) throws Exception{
		Member loginMember = null;
		
		try {
			String sql = prop.getProperty("login");
			// PrepareedStatement
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem.getMemberEmail());
			pstmt.setString(2, mem.getMemberPw());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				loginMember = new Member();
				loginMember.setMemberNo(  rs.getInt("MEMBER_NO") );
				loginMember.setMemberEmail( 	rs.getString("MEMBER_EMAIL") );
				loginMember.setMemberNick( 	rs.getString("MEMBER_NICK")	 );
				loginMember.setMemberTel( 		rs.getString("MEMBER_TEL") 	 );
				loginMember.setMemberAddress( 	rs.getString("MEMBER_ADDR")  );
				loginMember.setProfileImage( 	rs.getString("PROFILE_IMG")  );
				loginMember.setEnrollDate( 		rs.getString("ENROLL_DT") 	 );
				loginMember.setMemberBirth( rs.getString("MEMBER_BIRTH") );
				loginMember.setIsAdmin(rs.getString("IS_ADMIN"));
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return loginMember;
	}
	public int emailDupCheck(Connection conn, String memberEmail) throws Exception {
		int result = 0;
		try {
			
			String sql = prop.getProperty("emailDupCheck");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberEmail);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		return result;
	}
	
	
	/**
	 * @param conn
	 * @param inputEmail
	 * @param cNumber
	 * @return
	 * @throws Exception
	 * 인증번호, 발급일 수정 DAO
	 */
	public int updateCertification(Connection conn, String inputEmail, String cNumber) throws Exception{
		// TODO Auto-generated method stub
		int result = 0;
		
		try {
			String sql = prop.getProperty("updateCertification");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cNumber);
			pstmt.setString(2, inputEmail);
			
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public int insertCertification(Connection conn, String inputEmail, String cNumber) throws Exception{
		int result = 0;
		try {
			String sql = prop.getProperty("insertCertification");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inputEmail);
			pstmt.setString(2, cNumber);
			result = pstmt.executeUpdate();
		}finally{
			close(pstmt);
		}
		return result;
	}
	public int checkNumber(Connection conn, String cNumber, String inputEmail) throws Exception{
		int result = 0;
		try {
			String sql = prop.getProperty("checkNumber");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inputEmail);
			pstmt.setString(2, cNumber);
			pstmt.setString(3, inputEmail);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result=rs.getInt(1);
			}
		}finally{
			close(rs);
			close(pstmt);
		}
		return result;
	}
	public int selectNick(Connection conn, String memberNickname) throws Exception{
		String sql = prop.getProperty("selectMemberNick");
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberNickname);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		return result;
	}
	public int selectTel(Connection conn, String memberTel) throws Exception{
		String sql = prop.getProperty("selectTel");
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberTel);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		return result;
	}
	public int signUpEnd(Connection conn, String memberEmail, String memberPw, String memberNickname,
			String memberTel, String memberBirth, String[] memberAddr) throws Exception{
		int result = 0;
		String Addr;
		if(memberAddr ==null) {
			Addr = "없음";
		}else {
			Addr = String.join(",",memberAddr);
		}
		if(memberBirth ==null) {
			memberBirth ="없음";
		}
		
		try {
			String sql = prop.getProperty("signUp");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberEmail);
			pstmt.setString(2, memberPw);
			pstmt.setString(3, memberNickname);
			pstmt.setString(4, memberTel);
			pstmt.setString(5, memberBirth);
			pstmt.setString(6, Addr);
			result = pstmt.executeUpdate();
		}finally{
			close(pstmt);
		}
		return result;
	}
	public int secession(Connection conn, String memberEmail) throws Exception {
		int result = 0;
		try {
			String sql = prop.getProperty("secession");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberEmail);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	public int checkSecession(Connection conn, String storeEmail, String secessionPw) throws Exception{
		int result = 0;
		try {
			String sql = prop.getProperty("secessionPw");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, storeEmail);
			pstmt.setString(2, secessionPw);
			
			rs = pstmt.executeQuery();
			if(rs.next())
				result = rs.getInt(1);
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	public Member loginKakao(Connection conn, Member mem) throws Exception{
		Member loginMember = null;
		
		try {
			String sql = prop.getProperty("loginKakao");
			// PrepareedStatement
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem.getMemberEmail());
			pstmt.setString(2, mem.getMemberNick());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				loginMember = new Member();
				loginMember.setMemberNo(  rs.getInt("MEMBER_NO") );
				loginMember.setMemberEmail( 	rs.getString("MEMBER_EMAIL") );
				loginMember.setMemberNick( 	rs.getString("MEMBER_NICK")	 );
				loginMember.setMemberTel( 		rs.getString("MEMBER_TEL") 	 );
				loginMember.setMemberAddress( 	rs.getString("MEMBER_ADDR")  );
				loginMember.setProfileImage( 	rs.getString("PROFILE_IMG")  );
				loginMember.setEnrollDate( 		rs.getString("ENROLL_DATE") 	 );
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return loginMember;
	}
	public int signUpKakao(Connection conn, String kakaoEmail, String kakaoNickname, String kakaoImage) throws Exception{
		int result = 0;
		try {
			String sql = prop.getProperty("kakaoSignUp");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kakaoEmail);
			pstmt.setString(2, kakaoNickname);
			pstmt.setString(3, kakaoImage);
			
			result = pstmt.executeUpdate();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	
	public List<Restaurant> getMark(Connection conn, String name) throws Exception{
		List<Restaurant> rest_list = new ArrayList();
		try {
			String sql = prop.getProperty("getMark");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Restaurant rest = new Restaurant();
				rest.setRest_name(rs.getString(1));
				rest.setRest_Addr(rs.getString(2));
				rest.setRest_x(rs.getString(3));
				rest.setRest_y(rs.getString(4));
				rest.setRest_category(rs.getString(5));
				rest.setRest_sns(rs.getString(6));
				rest.setRest_tel(rs.getString(7));
				rest.setRest_time(rs.getString(8));
				System.out.println(rest);
				rest_list.add(rest);
			}
			System.out.println(rest_list);
		}finally {
			close(rs);
			close(pstmt);
			
		}
		return rest_list;
	}


	
	
	/** 프로필 이미지 변경
	 * @param conn
	 * @param memberNo
	 * @param profileImage
	 * @return
	 */
	public int updateProfileImage(Connection conn, int memberNo, String profileImage) throws Exception {
		
		int result = 0; 
		
		try {
			
			String sql = prop.getProperty("updateProfileImage");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, profileImage);
			pstmt.setInt(2, memberNo);
			
			result = pstmt.executeUpdate();

			
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	/** 프로필 정보 변경 --
	 * @param conn
	 * @param memberNo
	 * @param inputNickname
	 * @param inputTel
	 * @param inputBirth
	 * @param inputAddr
	 * @return
	 * @throws SQLException 
	 */
	public int updateInfo(Connection conn, int memberNo, String inputNickname, String inputTel, String inputBirth,
			String[] inputAddr) throws SQLException {
		
		int result = 0; 
		
		try {
			String sql = prop.getProperty("updateInfo");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, inputNickname);
			pstmt.setString(2, inputTel);
			pstmt.setString(3, inputBirth);
			
			String address = String.join(",,", inputAddr);

			pstmt.setString(4, address);
			
			pstmt.setInt(5,memberNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	 public int checkPwFirst(Connection conn, String currentPw, String memberEmail) throws Exception{
	      int result=0;
	      try {
	       String sql=prop.getProperty("checkPwFirst");
	    
	      pstmt = conn.prepareStatement(sql);
	     
	      pstmt.setString(1, currentPw);
	      pstmt.setString(2, memberEmail);
	      
	      rs = pstmt.executeQuery();
	      
	      if(rs.next()) {
	         result=rs.getInt(1);
	         
	      }
	   }finally {
	      close(rs);
	      close(pstmt);
	   }
	      return result;
	   }
	   
	   
	   
	   
	   
	   public int Pwchange(Connection conn,String newPw, String memberEmail) throws Exception{
	      int result=0;
	        try {
	            String sql=prop.getProperty("pwChange");
	            pstmt=conn.prepareStatement(sql);
	            pstmt.setString(1, newPw);
	            pstmt.setString(2, memberEmail);
	            result = pstmt.executeUpdate();
	        }finally {
	            close(pstmt);
	        }
	        return result;
	    }
	   

	   public int secessionPw(Connection conn, String memberPw, String memberEmail)throws Exception {
	      int result=0;
	      try {
	       String sql=prop.getProperty("secessionPw");
	    
	      pstmt = conn.prepareStatement(sql);
	     
	      pstmt.setString(1, memberPw);
	      pstmt.setString(2, memberEmail);
	      
	      rs = pstmt.executeQuery();
	      
	      if(rs.next()) {
	         result=rs.getInt(1);
	         
	      }
	   }finally {
	      close(rs);
	      close(pstmt);
	   }
	      return result;
	      
	      
	      
	      
	      
	      
	      
	   }






	
}
