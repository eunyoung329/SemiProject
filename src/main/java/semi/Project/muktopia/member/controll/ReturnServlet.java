package semi.Project.muktopia.member.controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/returnHome")
public class ReturnServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String path = "/WEB-INF/views/member/index.jsp";
	req.getRequestDispatcher(path).forward(req, resp);
}
}
