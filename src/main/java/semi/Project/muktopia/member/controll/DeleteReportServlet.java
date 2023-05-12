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

@WebServlet("/admin/deleteReport")
public class DeleteReportServlet extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//memberNO받아오기
		String memberNo=req.getParameter("memberNo");
		
		//서비스호출
		AdminService service=new AdminService();
		
		try {
			//admin
			int result=service.DeleteReport(memberNo);
			System.out.println(result);
			
			 new Gson().toJson(result, resp.getWriter());
			 resp.sendRedirect(req.getContextPath());
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	
	
	
	
	
	
}
