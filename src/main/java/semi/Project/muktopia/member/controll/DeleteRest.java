package semi.Project.muktopia.member.controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.Project.muktopia.member.model.service.AdminService;

@WebServlet("/deleteRest")
public class DeleteRest extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String restId = req.getParameter("restid");
			AdminService service = new AdminService();
			
			int result = service.deleteRest(restId);
			resp.getWriter().print(result);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
