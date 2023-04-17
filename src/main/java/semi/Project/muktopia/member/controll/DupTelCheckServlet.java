package semi.Project.muktopia.member.controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.Project.muktopia.member.model.service.MemberService;

@WebServlet("/member/memberTel")
public class DupTelCheckServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memberTel = req.getParameter("memberTel");
		int result = 0;
		try {
			result = new MemberService().selectTel(memberTel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.getWriter().print(result);
	}
}
