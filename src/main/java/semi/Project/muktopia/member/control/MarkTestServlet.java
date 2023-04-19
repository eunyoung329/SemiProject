package semi.Project.muktopia.member.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import semi.Project.muktopia.member.model.service.MemberService;
import semi.Project.muktopia.member.model.vo.Restaurant;

@WebServlet("/member/getShop")
public class MarkTestServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("storeName");
		List<Restaurant> rest_list = new ArrayList();
		try {
			rest_list = new MemberService().getMark(name);
			resp.setCharacterEncoding("UTF-8");
			System.out.println();
			new Gson().toJson(rest_list, resp.getWriter());
			//resp.getWriter().print(rest_list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
