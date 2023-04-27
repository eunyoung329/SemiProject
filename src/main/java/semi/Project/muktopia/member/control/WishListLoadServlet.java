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
import semi.Project.muktopia.member.model.vo.Restaurant;
import semi.Project.muktopia.member.model.vo.WishList;

@WebServlet("/member/wishListLoad")
public class WishListLoadServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
		   HttpSession session = req.getSession();
	       Member loginMember = (Member)session.getAttribute("loginMember");
	       int memberNoparam = loginMember.getMemberNo();
	       System.out.println("memberNoparam::"+memberNoparam);
  

			
			RestaurantService service = new RestaurantService();
			
			List<WishList> wishList = service.wishListLoad(memberNoparam);
			
			new Gson().toJson(wishList, resp.getWriter());
			System.out.println("서블릿");
			System.out.println("화면 로드" + wishList);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
