package semi.Project.muktopia.member.control;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semi.Project.muktopia.member.model.service.MemberService;
import semi.Project.muktopia.member.model.vo.Member;

@WebServlet("/member/secession")
public class SecessionServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String path = "/WEB-INF/views/member/myPage-secession.jsp";
	req.getRequestDispatcher(path).forward(req, resp);
}
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String secessionPw = req.getParameter("memberPw");
			HttpSession session = req.getSession();
			Member loginMember = (Member)session.getAttribute("loginMember");
			String memberEmail = loginMember.getMemberEmail();
			
			try {
				int result = new MemberService().checkSecession(memberEmail, secessionPw);
				System.out.println("secession 결과 값 검사"+result);
				if(result != 1) {
					session.setAttribute("messageSec", "비밀번호가 일치하지 않아, redirect합니다.");
					resp.sendRedirect("secession");
				}
				else {
					result = new MemberService().secession(memberEmail);
					session.invalidate(); //세션 무효화.	
					resp.sendRedirect(req.getContextPath());
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
}
