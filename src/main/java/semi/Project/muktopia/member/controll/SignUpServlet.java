package semi.Project.muktopia.member.controll;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semi.Project.muktopia.member.model.service.MemberService;

@WebServlet("/member/signUp")
public class SignUpServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/member/signUp.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("실행했냐.");
			String memberEmail = req.getParameter("memberEmail");
			String memberPw = req.getParameter("memberPw");
			String memberNickname = req.getParameter("memberNickname");
			String memberTel = req.getParameter("memberTel");
			String memberBirth = req.getParameter("memberBirth");
			String[] memberAddr = req.getParameterValues("memberAddr");
			System.out.println(memberBirth+" "+memberAddr);
			int result = 0;
			try {
				System.out.print(memberEmail+memberPw+memberNickname+memberTel);
				result = new MemberService().signUpEnd(memberEmail, memberPw, memberNickname,memberTel,memberBirth,memberAddr);
				System.out.println();
				System.out.println("가입에 성공하였습니다.");
				resp.sendRedirect(req.getContextPath());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		resp.sendRedirect(req.getContextPath());
	}
	
	
}
