package semi.Project.muktopia.member.controll;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import semi.Project.muktopia.member.model.service.AdminService;
import semi.Project.muktopia.member.model.vo.Admin;
import semi.Project.muktopia.member.model.vo.Member;




@WebServlet("/admin/AdminSelectOne")
public class AdminSelectOneServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//파라미터 멤버이메일 가져오기
		
		String memberEmail=req.getParameter("memberEmail");
		
		try {
            AdminService service = new AdminService();
			
			Admin admin = service.selectOne(memberEmail);
			System.out.println(admin);
			
			// 3) GSON 라이브러리를 이용한 Java 객체 -> JSON 변환
						// new Gson().toJson(객체, 응답스트림);
						// -> 매개변수에 작성된 객체를 JSON형태로 변환한 후 스트림 통해서 출력
			new Gson().toJson(admin, resp.getWriter());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	}

	
	
	
	
}
