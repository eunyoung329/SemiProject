package semi.Project.muktopia.member.controll;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;

import semi.Project.muktopia.common.MyRenamePolicy;
import semi.Project.muktopia.member.model.service.AdminService;

import semi.Project.muktopia.member.model.vo.Member;
import semi.Project.muktopia.member.model.vo.ReportStore;

@WebServlet("/admin/adminRegisterRest")
public class AdminRegisterRestServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/admin/adminRegisterRest.jsp").forward(req, resp);
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {

		System.out.println("지금 이거 실행되는거야?");
		AdminService service=new AdminService();
		HttpSession session = req.getSession();
		int report_index = Integer.parseInt(req.getParameter("report_index"));
		
		ReportStore reportStore = service.adminRegisterRest(report_index);
		
		if(reportStore != null) {//성공
//			session.setAttribute("message", "레스토랑이 등록되었습니다");
			session.setAttribute("reportStore",reportStore);
			
			String path = req.getContextPath() + "/admin/adminRegisterRest";
			new Gson().toJson(reportStore, resp.getWriter());
		}else {
//			session.setAttribute("message", "레스토랑 등록실패");
			resp.sendRedirect("reportAdmin");
			
		}
	
	
	}catch(Exception e) {
	e.printStackTrace();
	}
	}
				
}
	
	
	
	
