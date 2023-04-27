package semi.Project.muktopia.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semi.Project.muktopia.member.model.service.RestaurantService;
import semi.Project.muktopia.member.model.vo.Member;

@WebServlet("/member/wishlistDelete")
public class WishListDeleteServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			RestaurantService service = new RestaurantService();
			HttpSession session = req.getSession();
			Member loginMember = (Member)session.getAttribute("loginMember");
			
			if(loginMember != null) {
				String itemIdStr = req.getParameter("itemId"); // itemId 파라미터 값을 String으로 가져옴
				int itemId = Integer.parseInt(itemIdStr); // String을 int로 변환
				
				int memberNo = loginMember.getMemberNo();
				int result = service.jjimDelete(itemId, memberNo);
				resp.getWriter().print(result);
				System.out.println("삭제 됨");
		}else {
			System.out.println("삭제 안됨");
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
}
