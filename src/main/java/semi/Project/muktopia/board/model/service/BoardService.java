package semi.Project.muktopia.board.model.service;

import static semi.Project.muktopia.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import semi.Project.muktopia.board.model.dao.BoardDAO;
import semi.Project.muktopia.board.model.vo.Board;

public class BoardService {
	public int insertBoard(int memberNo, String title, String tagValues, String inputArea, String boardImage) throws Exception{
		Connection conn = getConnection();
		int result = new BoardDAO().insertBoard(conn,memberNo, title, tagValues, inputArea, boardImage);
		if(result ==1)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int selectId() throws Exception{
		Connection conn = getConnection();
		int boardId = new BoardDAO().selectId(conn);
		// TODO Auto-generated method stub
		return boardId;
	}

	public int updateboardImage(int boardId, String boardImage) throws Exception{
		Connection conn = getConnection();
		try {
		int result = new BoardDAO().updateboardImage(conn,boardId,boardImage);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		}finally {
			close(conn);
		}
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertBoardNotImg(int memberNo, String title, String tagValues, String inputArea) throws Exception{
		Connection conn = getConnection();
		int result = 0;
		try {
		result = new BoardDAO().insertBoardNotImg(conn,memberNo,title,tagValues,inputArea);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		}finally {
			close(conn);
		}
		// TODO Auto-generated method stub
		return result;
	}

	public Map selectPage(int firstStart) throws Exception{
		Connection conn = getConnection();
		Map<String, Object> map = new HashMap();
		try {
		map = new BoardDAO().selectPage(conn,firstStart);
		}finally {
		close(conn);
		}
		return map;
	}

	public int deleteBoard(int boardNo) throws Exception{
		int result = 0;
		Connection conn = getConnection();
		try {
			result = new BoardDAO().deleteBoard(conn, boardNo);
			if(result>0) {
				commit(conn);
			}else {
				rollback(conn);
			}
		
		}finally {
			close(conn);
		}
		return result;
	}
}
