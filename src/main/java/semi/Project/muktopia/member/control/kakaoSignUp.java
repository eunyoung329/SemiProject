package semi.Project.muktopia.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.Project.muktopia.member.model.service.MemberService;

@WebServlet("/member/kakaosignUp")
public class kakaoSignUp extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("카카오회원가입 실행");
		System.out.println("안되냐");
		String kakaoEmail = req.getParameter("kakaoId");
		String kakaoNickname = req.getParameter("kakaoNick");
		String kakaoImage = req.getParameter("kakaoImage");
		int result = 0;
		System.out.println(kakaoEmail);
		System.out.println(kakaoNickname);
		try {
			//System.out.print(memberEmail+memberPw+memberNickname+memberTel);
			result = new MemberService().signUpKakao(kakaoEmail, kakaoNickname, kakaoImage);
			System.out.println();
			if(result == 1) {
				System.out.println("가입에 성공하였습니다.");
				resp.getWriter().print(result);;
			}else {
				System.out.println("가입에 실패하셨습니다.");
//				String path = "/WEB-INF/views/signUp.jsp";
//				resp.sendRedirect(req.getContextPath()+path);
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(req.getContextPath());
		resp.sendRedirect(req.getContextPath());
	}
}
