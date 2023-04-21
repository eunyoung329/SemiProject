package semi.Project.muktopia.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member/infoChange")
public class InfoChangeServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String memberBirth = req.getParameter("memberBirth"); // forward 이전에 파라미터 수신
	    req.setAttribute("memberBirth", memberBirth); // 수신된 파라미터를 JSP로 전달하기 위해 속성 값으로 설정
	    
	    String path = "/WEB-INF/views/member/infoChange.jsp";
	    req.getRequestDispatcher(path).forward(req, resp);
	}


	
	
}
