package semi.Project.muktopia.member.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semi.Project.muktopia.member.model.service.MemberService;
import semi.Project.muktopia.member.model.vo.Member;

@WebServlet("/member/myPage/info")
public class MyInfoServlet extends HttpServlet{

	


	private static final long serialVersionUID = 1L;

	//side메뉴-> a태그 클릭->jsp이동요청
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		  
	        req.getRequestDispatcher("/WEB-INF/views/member/infoChange.jsp").forward(req, resp);
		
		
			
		}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
	String memberNick=req.getParameter("memberNick");
	String memberTel= req.getParameter("memberTel");
	String []Birth=req.getParameterValues("memberBirth");
	String []address=req.getParameterValues("memberAddress");
	
	String memberBirth=null;
	String memberAddress=null;
	
	if (Birth != null && Birth.length > 0 && !Birth[0].equals("")) {
	    memberBirth = String.format("%s년 %s월 %s일", Birth[0], Birth[1], Birth[2]);
	}
	
	
	if(!address[0].equals("")) {//우편번호가 빈칸이 아니라면
		memberAddress=String.join(",,", address);
	}
	
	
	//세션에 있는 회원정보가져오기**
	HttpSession session=req.getSession();
	
	//얕은복사(세션에 있는 회원정보 객체 주소)
	//->loginMember를 수정하면 세션에 저장된 내용이 수정된다
	Member loginMember =(Member)(session.getAttribute("loginMember"));
	
	int memberNo=loginMember.getMemberNo();//회원번호 얻어오기 성공
	
	//파라미터를 하나의 Member객체에 저장
	Member mem=new Member();
	
	mem.setMemberNo(memberNo);
	mem.setMemberNick(memberNick);
	mem.setMemberTel(memberTel);
	mem.setMemberBirth(memberBirth);
	mem.setMemberAddress(memberAddress);
	
	try {
		//멤버 서비스 ->service,dao넘겨주기
		MemberService service=new MemberService();
		
		int result=service.myInfo(mem);
		
		if(result>0) {//성공
			session.setAttribute("message", "회원정보가 수정되었습니다.");
			
			//DB에는 수정되었으나,
			//로그인된 회원정보가 담겨있는 session의 정보는 그대로다!
			//동기화 작업
			
			loginMember.setMemberNick(memberNick);
			loginMember.setMemberTel(memberTel);
			loginMember.setMemberBirth(memberBirth);
			loginMember.setMemberAddress(memberAddress);
			
		}else {
			
			session.setAttribute("message", "회원정보 수정 실패");
			
			
		}
		//성공 ,실패 상관없이 "내정보"화면 재요청
		resp.sendRedirect(req.getContextPath()+"/member/myPage/info");
		
		
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

	

	
	
	
	
	
	
	
	
}




			