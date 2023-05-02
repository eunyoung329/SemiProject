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

@WebServlet("/member/load")
public class LoadServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			RestaurantService service = new RestaurantService();
			
			//레스토랑 정보를 받는 변수
			List<Restaurant> resList = service.loadResList();
			System.out.println(resList);
			new Gson().toJson(resList, resp.getWriter());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
