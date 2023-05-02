package semi.Project.muktopia.board.model.service;

import static semi.Project.muktopia.common.JDBCTemplate.*;

import java.sql.Connection;

import semi.Project.muktopia.board.model.dao.BoardDAO;

public class BoardService {
	public int insertBoard(int memberNo, String title, String[] tagValue, String inputArea) throws Exception{
		Connection conn = getConnection();
		int result = new BoardDAO().insertBoard(conn,memberNo, title, tagValue, inputArea);
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
}
