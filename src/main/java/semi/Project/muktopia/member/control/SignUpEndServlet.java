package semi.Project.muktopia.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.Project.muktopia.member.model.service.MemberService;
@WebServlet("/member/signUpEnd")
public class SignUpEndServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memberEmail = req.getParameter("memberEmail");
		String memberPw = req.getParameter("memberPw");
		String memberNickname = req.getParameter("memberNickname");
		String memberTel = req.getParameter("memberTel");
		int result = 0;
		try {
			System.out.print(memberEmail+memberPw+memberNickname+memberTel);
			result = new MemberService().signUpEnd(memberEmail, memberPw, memberNickname,memberTel);
			System.out.println();
			System.out.println("가입에 성공하였습니다.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.sendRedirect(req.getContextPath());
	}
}
