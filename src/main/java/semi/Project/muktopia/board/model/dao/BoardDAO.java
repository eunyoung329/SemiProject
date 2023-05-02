package semi.Project.muktopia.board.model.dao;

import static semi.Project.muktopia.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import semi.Project.muktopia.member.model.dao.MemberDAO;

public class BoardDAO {
	Statement st;
	PreparedStatement pstmt;
	ResultSet rs;
	Properties prop;
	public BoardDAO() {
		try {
			prop = new Properties();
			String filePath = MemberDAO.class.getResource("/semi/Project/muktopia/sql/board-sql.xml").getPath();
			prop.loadFromXML(new FileInputStream (filePath));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int insertBoard(Connection conn, int memberNo, String title, String[] tagValue, String inputArea) throws Exception{
		int result=0;
		String tagStringValue = " ";
		if(tagValue!=null) {
			tagStringValue = String.join(",", tagValue);
		}
		
		
		try {
			String sql=prop.getProperty("insertBoard");
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			pstmt.setString(2, title);
			pstmt.setString(3, tagStringValue);
			pstmt.setString(4, inputArea);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int selectId(Connection conn) throws Exception{
		int result=0;
		String sql = prop.getProperty("selectId");
		try {
			pstmt = conn.prepareStatement(sql);
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

	public int updateboardImage(Connection conn, int boardId, String boardImage) throws Exception{
		int result = 0;
		try {
		String sql = prop.getProperty("updateImageBoard");
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, boardImage);
		pstmt.setInt(2, boardId);
		
		
		result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		// TODO Auto-generated method stub
		return result;
	}
}
