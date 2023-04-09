package semi.Project.muktopia.member.control;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.Project.muktopia.member.model.service.MemberService;

@WebServlet("")
public class SelectMemberNickServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memberNickname = req.getParameter("memberNickname");
		int result = 0;
		try {
			result = new MemberService().selectNick(memberNickname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.getWriter().print(result);
	}
}
