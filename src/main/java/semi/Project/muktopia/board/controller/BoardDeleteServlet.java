package semi.Project.muktopia.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import semi.Project.muktopia.board.model.service.BoardService;
import semi.Project.muktopia.member.model.vo.Member;

@WebServlet("/member/board/delete")
public class BoardDeleteServlet extends HttpServlet{

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp){
	int boardNo = Integer.parseInt(req.getParameter("boardNo"));
	HttpSession session = req.getSession();
	Member loginMember = (Member) session.getAttribute("loginMember");
	
	BoardService service = new BoardService();
	int result = 0;
	try {
		result = service.deleteBoard(boardNo,loginMember.getMemberNo());
		
		
		if(result > 0) {//성공
			
			session.setAttribute("message", "게시물이 삭제되었습니다.");
			//resp.sendRedirect(req.getContextPath()+"/member/board");
			resp.getWriter().print(result);
			//new Gson().toJson(result, resp.getWriter());
	}else {//실패
		session.setAttribute("message", "게시물 삭제에 실패하였습니다.");

	}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
