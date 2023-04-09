package semi.Project.muktopia.member.control;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import semi.Project.muktopia.member.model.service.*;

@WebServlet("")
public class EmailDupCheckServlet extends HttpServlet{
	//이메일 중복 검사 (비동기 통신)
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memberEmail = req.getParameter("memberEmail");
		try {
			//이메일 중복 검사 서비스 호출
			MemberService service = new MemberService();
			
			int result = service.emailDupCheck(memberEmail);
			
			//보통 동기식 코드 작성시
			//forward 또는 redirect를 이용해서 새로운 페이지가 보이게 동작함.
			
			//*** 비동기 통신시 응답은 화면이 아닌 데이터
			//-> 응답용 스트림을 이용해서 단순 데이터 전달만 하면 된다.
			System.out.println(result);
			resp.getWriter().print(result);
			//응답용 스트림을 이용해 result를 출력
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
