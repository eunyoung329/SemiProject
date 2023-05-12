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

@WebServlet("/member/SecessionPw")
public class SecessionPwServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//파라미터 불러오기
		String memberPw=req.getParameter("memberPw");
		
		//세션
		HttpSession session=req.getSession();
		
		//loginMember,memberEmail
		Member loginMember = (Member) session.getAttribute("loginMember");
		String memberEmail = loginMember.getMemberEmail(); // Member 클래스에서 이메일 값을 반환하는 getEmail() 메소드 사용
		
		//result
		
		
		try {
			MemberService service=new MemberService();
			int result=service.sessionPw(memberPw,memberEmail);
			System.out.println(result);
			resp.getWriter().print(result);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	

	
	
	
	
	
	
	
}
