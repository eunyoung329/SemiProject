package semi.Project.muktopia.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semi.Project.muktopia.member.model.service.MemberService;
import semi.Project.muktopia.member.model.vo.Member;

@WebServlet("/member/secession")
public class SecessionServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/member/secession.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
    
    	
    	//파라미터는 세션에 모두 저장
    	HttpSession session=req.getSession();
    	
    	Member loginMember=(Member)( session.getAttribute("loginMember") ) ;
    	String memberEmail=loginMember.getMemberEmail();
    	try {	
        	MemberService service=new MemberService();
        	
        	
        	int result=service.secession(memberEmail);
        	System.out.print("result"+result);
        	
        	String path=null;
        	
        	if(result>0) {
        		
        		
        		//로그아웃방법2
        		session.invalidate();//세션무효화
        		//->세션을 무효화해버려서 메시지 전달되지않는 문제 발생
        		
        		//[해결방법]
        		//새로운 세션을 얻어와서 메시지 세팅
        		
        		session=req.getSession();//무효화 후 새로 생성된 세션얻어오기
        		
        		session.setAttribute("message", "탈퇴되었습니다.");
        		
        		path=req.getContextPath();//메인페이지
        		
        		Cookie c=new Cookie("checkbox","");
        		c.setMaxAge(0);//쿠키수명
        		c.setPath(req.getContextPath());//쿠키 적용 경로
        		resp.addCookie(c);//쿠키 클라이언트에 전송
        		
        		
        	}else {
        		session.setAttribute("message", "비밀번호가 일치하지 않습니다.");
        		
        		//절대경로
        		//path=req.getContextPath()+"/member/myPage/secession";
        		
        		//상대경로
        		path="secessionFL";
        	}

        	resp.sendRedirect(path);
        } catch(Exception e) {
        	e.printStackTrace();
        }
        	
        	
        	
        	
        
        
        
	}
}
