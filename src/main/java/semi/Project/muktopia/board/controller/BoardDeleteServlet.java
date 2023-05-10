package semi.Project.muktopia.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.Project.muktopia.board.model.service.BoardService;

@WebServlet("/member/board/delete")
public class BoardDeleteServlet extends HttpServlet{

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp){
	int boardNo = Integer.parseInt(req.getParameter("boardNo"));
	
	BoardService service = new BoardService();
	int result = 0;
	try {
		result = service.deleteBoard(boardNo);
		resp.sendRedirect(req.getContextPath()+"/member/board");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
