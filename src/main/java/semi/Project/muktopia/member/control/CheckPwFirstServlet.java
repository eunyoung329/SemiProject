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

@WebServlet("/member/checkPwFirst")
public class CheckPwFirstServlet extends HttpServlet{



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//파라미터 가져오기
		String currentPw=req.getParameter("currentPw");
		
		
		//session
		HttpSession session=req.getSession();
		
		//loginMember
		Member loginMember=(Member)session.getAttribute("loginMember");
		
		//MemberEmail가져오기
		String memberEmail=loginMember.getMemberEmail();//로그인 이메일
		
		System.out.println(currentPw);
		System.out.println(memberEmail);
		
		try {
			MemberService service=new MemberService();
			int result=service.checkPwFirst(currentPw,memberEmail);
			System.out.print(result);
			resp.getWriter().print(result);
		
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	//20230503

	}
}
