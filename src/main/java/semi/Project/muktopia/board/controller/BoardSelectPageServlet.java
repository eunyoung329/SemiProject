package semi.Project.muktopia.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import semi.Project.muktopia.board.model.service.BoardService;
import semi.Project.muktopia.board.model.vo.Board;


@WebServlet("/member/board/selectPage")
public class BoardSelectPageServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp){
		int firstStart = Integer.parseInt(req.getParameter("firstStart"));
		
		Map map = new HashMap();
		try {
			
			 map = new BoardService().selectPage(firstStart);
			//resp.getWriter().print(result);
			 System.out.println(map.get("boardList"));
			new Gson().toJson(map, resp.getWriter());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
