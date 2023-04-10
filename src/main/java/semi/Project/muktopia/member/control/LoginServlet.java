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

@WebServlet("/member/login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//전달된 파라미터 변수에 저장.
		String inputEmail = req.getParameter("inputEmail");
		String inputPw = req.getParameter("inputPw");
		
		System.out.println("inputEmail : " + inputEmail);
		System.out.println("inputPw : " + inputPw);
		
		Member mem = new Member();
		
		mem.setMemberEmail(inputEmail);
		mem.setMemberPw(inputPw);
		
		try {
			MemberService service = new MemberService();
			//이메일, 비밀번호가 일치하는 회원을 조회하는 서비스 호출 후 결과 반환 받기
			Member loginMember = service.login(mem);
			
			//session scope
			//로그인
			//id/pw가 일치하는 회원 정보를 Session scope에 세팅하는 것.
			//session 객체 얻어오기
			HttpSession session = req.getSession();
			if(loginMember!=null) {
				// 회원 정보 Session 세팅
				session.setAttribute("loginMember", loginMember);
				//특정 시간 동안 요청이 없으면 세션 만료
				session.setMaxInactiveInterval(3600);//초단위로 작성하는 것.
				//=========================================================
				//아이디 저장(Cookie)
				/*
				 * Cookie : 클라이언트(브라우저)에서 관리하는 파일
				 * - 특정 주소 요청 시마다
				 * 해당 주소와 연관된 쿠기 파일을 브라우저가 알아서 읽어옴
				 * -> 읽어온 쿠키 파일 내용을 서버에 같이 전달
				 * 
				 * 생성 및 사용 방법
				 * 
				 * 1) 서버가 요청에 대한 응답을 할 때
				 * 쿠키를 생성한 수
				 * 응답에 쿠키를 담아서 클라이언트에게 전달
				 * 3) 이후 특정 주소 요청 시
				 * 쿠키 파일을 브라우저가 찾아 자동으로 요청에 실어서 보냄.
				 * 4) 서버는 요청에 실려온 쿠키 파일을 사용함.
				 * 
				 */
				
				Cookie c = new Cookie("saveId",inputEmail);
				// 아이디 저장이 체크된 경우
				if(req.getParameter("saveId")!=null) {
					//쿠키파일을 30일 동안 유지.
					c.setMaxAge(60*60*24*30);//30일
				}else {
					//쿠키 파일을 안씀
					//기존에 있던 것도 없애야함.
					//기존에 존재하던 쿠키 파일에 유지 시간을 0초로 덮어씌움.
					c.setMaxAge(0);
				}
				c.setPath(req.getContextPath());
				//최상위 주소:/community
				//-> /community로 시작하는 주소에서만 쿠키 적용.
				
				//응답 객체를 이용해서 클라이언트로 전달.
				resp.addCookie(c);
				// forward(요청 위임)
				// - servlet으로 응답 화면 만들기가 불편해서
				//jsp로 req, resp 객체 위임하여
				//요청에 대한 응답화면 대신 만든다.
				
				//ex) 아아 주소 -> 주문 받음 -> 바리스타가 만든 커피
				//		클		->   캐셔    -> 응답 결과(jsp)
				
				//리다이렉트 redirect 재요청.
				//클라이언트 재요청
				// 현재 Servlet에서 응답 페이지를 만들지 않고
				//응답 페이지를 만들 수 있는 수 있는
				//다른 요청의 주소로 클라이언트를 이동시킴(재요청)
				
				//클라이언트 재요청
				// -> 기존 HttpServletRequest/Response 제거
				// = > 새로운 HttpServletRequest/Response 생성
				//만약 같은 걸 쓰고 싶다면 scope를 이용해야한다.
				
				resp.sendRedirect(req.getContextPath());
				//리다이렉트할 장소를 적어
//				req.getRequestDispatcher("../index.jsp").forward(req, resp);
			}else {
				//session.setAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
