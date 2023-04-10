package semi.Project.muktopia.member.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.Project.muktopia.member.model.service.MemberService;

@WebServlet("/member/signUp")
public class SignUpServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/member/signUp.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		//jsp -> jsp로는 옮겨갈 수 없으니 jsp -> servlet -> jsp로 간다.
		
	}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.sendRedirect(req.getContextPath());
	
	}
	
}
