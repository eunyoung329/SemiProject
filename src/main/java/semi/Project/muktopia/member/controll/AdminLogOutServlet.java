package semi.Project.muktopia.member.controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/admin/adminLogOut")
public class AdminLogOutServlet extends HttpServlet{
 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Session 얻어오기
		HttpSession session = req.getSession();
		
		
		
		// Session 전체를 없애고 새로운 Session 만들기(더 많이 사용되는 방법)
		session.invalidate(); // 세션 무효화 -> 현재세션을 없앰 -> 자동으로 새로운 세션이 생성됨
		
		
		// 메인 페이지로 돌아가기
		resp.sendRedirect(req.getContextPath());
	}
}
