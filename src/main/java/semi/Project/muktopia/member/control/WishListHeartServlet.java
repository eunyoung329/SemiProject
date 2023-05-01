package semi.Project.muktopia.member.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import semi.Project.muktopia.member.model.service.RestaurantService;
import semi.Project.muktopia.member.model.vo.Member;

@WebServlet("/member/heart")
public class WishListHeartServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			RestaurantService service = new RestaurantService();
			HttpSession session = req.getSession();
			Member loginMember = (Member)session.getAttribute("loginMember");
			System.out.println("memeber: " + (loginMember != null));
			if(loginMember != null) {
				int memberNo = loginMember.getMemberNo();
				List<Integer> restIds = service.heart(memberNo);
				System.out.println("restid: " + restIds);
				new Gson().toJson(restIds, resp.getWriter());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
}
