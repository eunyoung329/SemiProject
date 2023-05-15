package semi.Project.muktopia.board.model.dao;

import static semi.Project.muktopia.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import semi.Project.muktopia.board.model.vo.Board;
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
	
	public int insertBoard(Connection conn, int memberNo, String title, String tagValues, String inputArea, String boardImage) throws Exception{
		int result=0;
		
		
		try {
			String sql=prop.getProperty("insertBoard");
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			pstmt.setString(2, title);
			pstmt.setString(3, tagValues);
			pstmt.setString(4, boardImage);
			pstmt.setString(5, inputArea);
			
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

	public int insertBoardNotImg(Connection conn, int memberNo, String title, String tagValues, String inputArea) throws Exception {
		int result=0;
		
		
		try {
			String sql=prop.getProperty("insertBoardNotImg");
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			pstmt.setString(2, title);
			pstmt.setString(3, tagValues);
			pstmt.setString(4, inputArea);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	public int firstselectPage(Connection conn) throws Exception{
		int result = 0;
		
		try{
		 String sql = prop.getProperty("firstselectPage");
		 pstmt = conn.prepareStatement(sql);
		 rs = pstmt.executeQuery();
		 if(rs.next())
			 result = rs.getInt(1);
		}finally {
			pstmt = null;
			System.out.println(result);
		}
		return result;
	}
	public Map selectPage(Connection conn, int firstStart) throws Exception{
		List<Board> boardList = new ArrayList();
		Map<String, Object> map = new HashMap();
		int cp = 0;
		int temp = 0;
		String sql = prop.getProperty("selectPage");
		try {
			if(firstStart == 0) {
				cp =firstselectPage(conn);
			}else {
				cp = firstStart;
			}
			temp = cp;
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cp);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Board board = new Board();
				board.setBoardNo(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setBoardImage(rs.getString(3));
				board.setInputArea(rs.getString(4));
				board.setBoardTime(rs.getString(5));
				board.setMemberNo(rs.getInt(6));
				boardList.add(board);
				
			}
			System.out.println(boardList);
			int boardListSize = boardList.size();
			cp = boardList.get(boardListSize-1).getBoardNo();
		}finally {
			close(rs);
			close(pstmt);
		}
		if(temp!=cp) {
			map.put("firstStart", cp-1);
			map.put("boardList", boardList);
		}
		return map;
	}

	public int deleteBoard(Connection conn, int boardNo, int memberNo) throws Exception{
		// TODO Auto-generated method stub
		int result = 0;
		try {
			String sql = prop.getProperty("deleteBoard");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			pstmt.setInt(2, memberNo);
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}
}
