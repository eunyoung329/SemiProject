package semi.Project.muktopia.member.controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import semi.Project.muktopia.member.model.service.AdminService;

@WebServlet("/admin/deleteMember")
public class DeleteMemberAdmin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			System.out.println("관리자 멤버 탈퇴 서블릿 실행중");
			String memberNoStr = req.getParameter("memberNo");
			int memberNo = Integer.parseInt(memberNoStr);

			AdminService service = new AdminService();
			
//			String memberNo = req.getParameter("memberNo");
			
			System.out.println("memberNo::" + memberNo);
			
			HttpSession session = req.getSession();
			
			int result = service.DeleteMember(memberNo);
			System.out.println("result::" + result);
			
			if(result>0) {
				 resp.getWriter().write("success");
				
			}else {
				 resp.getWriter().write("fail");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
