package semi.Project.muktopia.member.common;

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
		String loginType = req.getParameter("loginType");
		if(loginType == "false") {
			
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
				resp.sendRedirect(req.getContextPath());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}else {
		String kakaoEmail = req.getParameter("kakaoId");
		String kakaoNickname = req.getParameter("kakaoNick");
		String kakaoImage = req.getParameter("kakaoImage");
		String kakaoGender = req.getParameter("kakaoGender");
		int result = 0;
		System.out.println(kakaoEmail);
		System.out.println(kakaoNickname);
		try {
			//System.out.print(memberEmail+memberPw+memberNickname+memberTel);
			result = new MemberService().signUpKakao(kakaoEmail, kakaoNickname, kakaoImage ,kakaoGender);
			System.out.println();
			if(result == 1) {
				System.out.println("가입에 성공하였습니다.");
			}else {
				System.out.println("가입에 실패하셨습니다.");
				String path = "/WEB-INF/views/signUp.jsp";
				resp.sendRedirect(req.getContextPath()+path);
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(req.getContextPath());
		resp.sendRedirect(req.getContextPath());
	}
	}
	
}
