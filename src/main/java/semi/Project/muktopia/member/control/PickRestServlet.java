package semi.Project.muktopia.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import semi.Project.muktopia.member.model.service.RestaurantService;
import semi.Project.muktopia.member.model.vo.Restaurant;

@WebServlet("/member/pick")
public class PickRestServlet extends HttpServlet {
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String X = req.getParameter("X");
			String Y = req.getParameter("Y");
			
			RestaurantService service = new RestaurantService();
			
			Restaurant pick = service.pickRest(X, Y);
			
			new Gson().toJson(pick, resp.getWriter());			
		}catch(Exception e) {
			e.printStackTrace();
		}
	 }
}
