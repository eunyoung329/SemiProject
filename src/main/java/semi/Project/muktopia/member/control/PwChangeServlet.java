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

@WebServlet("/member/pwChange")
public class PwChangeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/member/pwChange.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//파라미터 가져오기(현재 비밀번호,새비밀번호,비밀번호확인)
		
		String newPw=req.getParameter("newPw");
	
		
		//세션연결 로그인 회원정보 얻어오기
		
		HttpSession session=req.getSession();
		Member loginMember=(Member)session.getAttribute("loginMember");
		
		//MemberNo가져오기
		String memberEmail=loginMember.getMemberEmail();//로그인 회원번호
		
		
		System.out.println(memberEmail);
		System.out.println(newPw);
		

		try {
			
			MemberService service=new MemberService();
			int result=service.Pwchange(newPw,memberEmail);
			
			System.out.println(result);
			//String Path=null;//리다이렉트
			
			if(result>0) {
				
				session.setAttribute("message", "비밀번호 변경성공");
				
				 resp.sendRedirect(req.getContextPath());
				 
			}else {
				
				session.setAttribute("message", "비밀번호 변경실패");
				 resp.sendRedirect(req.getContextPath());
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
			
		}
		
		
	}
}
