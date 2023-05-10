package semi.Project.muktopia.member.controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.Project.muktopia.member.model.service.AdminService;

@WebServlet("/admin/boardDelete")
public class AdminBoardDelete extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			AdminService service = new AdminService();
			String idStr = req.getParameter("id");
			int id = Integer.parseInt(idStr);
			int result = service.boardDelete(id);
			
			resp.getWriter().print(result);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
