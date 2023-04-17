package semi.Project.muktopia.member.controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.Project.muktopia.member.model.service.MemberService;

@WebServlet("/member/memberNickname")
public class NickDupCheckServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memberNickname = req.getParameter("memberNickname");
		
		try {
			int result = new MemberService().selectNick(memberNickname);
			resp.getWriter().print(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
