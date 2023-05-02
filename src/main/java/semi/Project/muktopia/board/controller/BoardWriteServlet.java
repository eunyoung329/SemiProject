package semi.Project.muktopia.board.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import semi.Project.muktopia.board.model.service.BoardService;
import semi.Project.muktopia.board.model.vo.Board;
import semi.Project.muktopia.common.MyRenamePolicy;
import semi.Project.muktopia.member.model.vo.Member;


@WebServlet("/board/boardWrite")
public class BoardWriteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/Board/boardWrite.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int maxSize = 1024 * 1024 * 20;
		HttpSession session = req.getSession();
		String root = session.getServletContext().getRealPath("/");
		String folderPath = "resources/img/boardImg/";
		String filePath = root + folderPath;
		String encoding = "UTF-8";
		
		MultipartRequest mpReq = new MultipartRequest(req, filePath, maxSize ,encoding,new MyRenamePolicy());//,new MyRenamePolicy()
		
		String title = mpReq.getParameter("boardtitle");
		String[] tagValue = mpReq.getParameterValues("tagValue");
		Member loginMember = (Member)session.getAttribute("loginMember");
		int memberNo = loginMember.getMemberNo();
		String inputArea = mpReq.getParameter("inputArea");
		
		
		
		//int memberNo = loginMember.getMemberNo();	
		String boardImage = folderPath + mpReq.getFilesystemName("boardImage");
		BoardService service = new BoardService();
		try {
			int boardId = service.selectId();
			
			int result = service.updateboardImage(boardId, boardImage);
			if(result > 0) {//성공
				session.setAttribute("message", "프로필 이미지가 변경되었습니다.");
				resp.sendRedirect("../index.jsp");
		}else {//실패
			session.setAttribute("message", "프로필 이미지 변경 실패하였습니다.");

		}
	
			//성공 / 실패 관계없이 프로필 화면 재요청(redirect)
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
