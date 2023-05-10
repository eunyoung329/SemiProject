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
import semi.Project.muktopia.member.model.vo.Restaurant;

@WebServlet("/admin/restLoad")
public class RestLoadServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			AdminService service = new AdminService();
			
			List<Restaurant> restList = service.restLoad();
			
			new Gson().toJson(restList, resp.getWriter());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
