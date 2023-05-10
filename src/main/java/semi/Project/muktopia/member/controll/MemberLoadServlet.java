package semi.Project.muktopia.member.controll;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import semi.Project.muktopia.member.model.service.AdminService;
import semi.Project.muktopia.member.model.vo.Member;

@WebServlet("/admin/memberLoad")
public class MemberLoadServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
//			System.out.println("관리자 페이지 멤버로드 서블릿 실행중");
			
			AdminService service = new AdminService();
					
			List<Member> memberList = service.memberLoad();
			
//			System.out.println("memberList Servlet::"+memberList);
			new Gson().toJson(memberList, resp.getWriter());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
			
	}

}
