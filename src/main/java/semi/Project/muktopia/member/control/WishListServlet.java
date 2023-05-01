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

@WebServlet("/member/wishList")
public class WishListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		req.getRequestDispatcher("/WEB-INF/views/member/wishList.jsp").forward(req, resp);
	}
	
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
				int result0 = service.jjimSelect(itemId, memberNo);
				int result = service.jjim(itemId, memberNo);

				if(result0 >0) {
					System.out.println("중복된 위시리스트!!");
					result = 0;
					resp.getWriter().print(result);
				}else {					
					resp.getWriter().print(result); // 중복 된것이 없을경우 insert 작동!
				}
			}else {
				int result = -1;
				resp.getWriter().print(result); // 로그인 멤버가 없으면 -1을 보냄!
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
