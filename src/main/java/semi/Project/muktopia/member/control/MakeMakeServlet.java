package semi.Project.muktopia.member.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import semi.Project.muktopia.member.model.service.RestaurantService;
import semi.Project.muktopia.member.model.vo.Restaurant;

@WebServlet("/member/maker")
public class MakeMakeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			RestaurantService service = new RestaurantService();
			
			List<Restaurant> maker = service.maker();
		
			new Gson().toJson(maker, resp.getWriter());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
