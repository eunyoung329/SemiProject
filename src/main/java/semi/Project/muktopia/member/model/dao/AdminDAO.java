package semi.Project.muktopia.member.model.dao;

import static semi.Project.muktopia.common.JDBCTemplate.close;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import semi.Project.muktopia.board.model.vo.Board;
import semi.Project.muktopia.member.model.vo.Member;
import semi.Project.muktopia.member.model.vo.ReportStore;
import semi.Project.muktopia.member.model.vo.Restaurant;


public class AdminDAO {
	
	Statement st;
	PreparedStatement pstmt;
	private Statement stmt;
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
	            loginMember.setMemberEmail(    rs.getString("MEMBER_EMAIL") );
	            
	            
	            
	            
	         }
	         
	         
	      } finally {
	         close(rs);
	         close(pstmt);
	      }
	      
	      return loginMember; // null 또는 Member 객체 주소
	   }



	public List<Board> showList(Connection conn) throws Exception{
		List<Board> showList = new ArrayList<>();
		try {
			String sql = prop.getProperty("showList");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int boardNo = Integer.parseInt(rs.getString("BOARD_NO"));
				int memberNo = Integer.parseInt(rs.getString("MEMBER_ID"));
				String title = rs.getString("BOARD_TITLE");
				String tagValue = rs.getString("BOARD_CATEGORY");
				String inputArea = rs.getString("BOARD_INPUTAREA");
				String boardImage = rs.getString("BOARD_IMAGE");
				String boardTime = rs.getString("BOARD_TIME");
				showList.add(
						new Board(boardNo, memberNo, title, tagValue, inputArea, boardImage, boardTime));
			}
		}finally {
			close(rs);
			close(stmt);
		}
		return showList;
	}


	public int boardDelete(Connection conn, int id) throws Exception{
		int result = 0;
		try {
			String sql = prop.getProperty("boardDelete");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}
	/** 멤버전체를 가져오는 DAO
	 * @param conn
	 * @return
	 */
	public List<Member> memberLoad(Connection conn) throws Exception {
		List<Member> memberList = new ArrayList<>();
		
		try {
			String sql = prop.getProperty("memberLoad");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Member mem = new Member();
				mem.setMemberNo(rs.getInt("MEMBER_NO"));
				mem.setMemberEmail(rs.getString("MEMBER_EMAIL"));
				mem.setMemberNick(rs.getString("MEMBER_NICK"));
				mem.setMemberTel(rs.getString("MEMBER_TEL"));
				mem.setMemberBirth(rs.getString("MEMBER_BIRTH"));
				mem.setEnrollDate(rs.getString("ENROLL_DATE"));
				mem.setMemberAddress(rs.getString("MEMBER_ADDR"));
				mem.setSecessionFlag(rs.getString("SECESSION_FL"));
				mem.setIsAdmin(rs.getString("IS_ADMIN"));
				
				memberList.add(mem);
				
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return memberList;
	}

	/** 관리자가 멤버를 탈퇴키는 DAO
	 * @return
	 * @throws SQLException 
	 */
	public int DeleteMember(Connection conn, int memberNo ) throws Exception {
		int result = 0;
		
		try{
			String sql = prop.getProperty("deleteMember");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			result = pstmt.executeUpdate();
			
			
		}finally {
		
			close(pstmt);
		}
		return result;
	}
	/**
	 * 레스토랑 다 가져오는 DAO
	 * @param conn
	 * @return
	 */
	public List<Restaurant> restLoad(Connection conn) throws Exception{
		List<Restaurant> restList =  new ArrayList<>();
		try {
			String sql = prop.getProperty("restLoad");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Restaurant rest = new Restaurant();
				rest.setRest_id(rs.getString("RESTAURANT_ID"));
				rest.setRest_name(rs.getString("RESTAURANT_NAME"));
				rest.setRest_Addr(rs.getString("RESTAURANT_ADDR"));
				rest.setRest_x(rs.getString("RESTAURANT_X"));
				rest.setRest_y(rs.getString("RESTAURANT_Y"));
				rest.setRest_category(rs.getString("RESTAURANT_CATEGORY"));
				rest.setRest_sns(rs.getString("RESTAURANT_SNS"));
				rest.setRest_tel(rs.getString("RESTAURANT_TEL"));
				rest.setRest_time(rs.getString("RESTAURANT_TIME"));
				rest.setRest_img(rs.getString("RESTAURANT_IMG"));
				rest.setRest_contents(rs.getString("RESTAURANT_CONTENTS"));
				restList.add(rest);
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		return restList;
	}


	public int deleteRest(Connection conn, String restId) throws Exception {
		int result = 0;
		try {
			String sql = prop.getProperty("deleteRest");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, restId);
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public ReportStore selectOne(Connection conn, String memberEmail) throws Exception{
	      
        ReportStore report = null;
    
    try {
       String sql = prop.getProperty("selectOne");
       
       pstmt = conn.prepareStatement(sql);
       
       pstmt.setString(1, memberEmail);
       
       rs = pstmt.executeQuery();
       
       if(rs.next()) {
          report = new ReportStore();
          report.setMemberNo(rs.getInt("MEMBER_NO"));
          report.setMemberEmail(rs.getString("MEMBER_EMAIL"));
          report.setRest_category(rs.getString("REPORT_CATEGORY"));
          report.setRest_name(rs.getString("RESTAURANT_NAME"));
          report.setRest_img(rs.getString("RESTAURANT_IMG"));
          report.setRest_Addr(rs.getString("RESTAURANT_ADDR"));
          report.setReport_Content(rs.getString("REPORT_CONTENT"));
          report.setReport_date(rs.getString("REPORT_DATE"));
          
          
              
       }
       
    }finally {
       close(rs);
       close(pstmt);
    }
    
    return report;
 }

    
    



	public List<ReportStore> AdminReportAll(Connection conn)throws Exception {
        List<ReportStore>stdList=new ArrayList<>();
         
        try {
            
            String sql=prop.getProperty("adminReportAll");
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            
              while (rs.next()) {
                 ReportStore report=new ReportStore();
                 
            
               
                 report.setMemberNo(rs.getInt("MEMBER_NO"));
                 report.setMemberEmail(rs.getString("MEMBER_EMAIL"));
                 report.setRest_category(rs.getString("REPORT_CATEGORY"));
                 report.setRest_name(rs.getString("RESTAURANT_NAME"));
                 report.setRest_Addr(rs.getString("RESTAURANT_ADDR"));
                 report.setRest_img(rs.getString("RESTAURANT_IMG"));
                 report.setReport_Content(rs.getString("REPORT_CONTENT"));
                 report.setReport_date(rs.getString("REPORT_DATE"));
                 report.setReport_index(rs.getInt("REPORT_INDEX"));
                   
                   
                          
                     stdList.add(report);
                 
                     
                     System.out.println(stdList);
                     System.out.println(report.getReport_index());
                     
                     
                 }
            
            
         }finally {
            close(rs);
            close(stmt);
         }
         return stdList;
      }



	 public ReportStore adminRegisterRest(Connection conn, int report_index) throws Exception{
	      ReportStore result= new ReportStore();
	        try {
	            String sql=prop.getProperty("adminRegisterRest");
	            pstmt=conn.prepareStatement(sql);
	            
	            pstmt.setInt(1, report_index);
	            
	            rs = pstmt.executeQuery();
	            if(rs.next()) {

	            	result.setMemberNo(rs.getInt(1));
	            	result.setMemberEmail(rs.getString(2));
	            	result.setRest_category(rs.getString(3));
	            	result.setRest_name(rs.getString(4));
	            	result.setRest_Addr(rs.getString(5));
	            	result.setRest_img(rs.getString(6));
	            	
	            	result.setReport_Content(rs.getString(7));
	            	result.setReport_date(rs.getString(8));
	            	result.setReport_index(rs.getInt(9));
	            	
	            	
	            	
	       
	            	
	            }
	        }finally {
	            close(pstmt);
	        }
	        return result;
	   }



	 public int deleteReport(Connection conn, int report_index)throws Exception {
	      int result=0;
	      try {
	         String sql=prop.getProperty("deleteReport");
	         pstmt=conn.prepareStatement(sql);
	         
	         pstmt.setInt(1, report_index);
	         
	         result = pstmt.executeUpdate();
	         
	         
	         
	      }finally {
	         close(rs);
	         close(pstmt);
	      }
	      return result;
	   }
}



