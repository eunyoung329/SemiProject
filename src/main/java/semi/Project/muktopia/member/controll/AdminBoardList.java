package semi.Project.muktopia.member.controll;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import semi.Project.muktopia.board.model.vo.Board;
import semi.Project.muktopia.member.model.service.AdminService;

@WebServlet("/admin/adminBoardList")
public class AdminBoardList extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			AdminService service = new AdminService();
			List<Board> showList = service.showList();
			
			new Gson().toJson(showList, resp.getWriter());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
