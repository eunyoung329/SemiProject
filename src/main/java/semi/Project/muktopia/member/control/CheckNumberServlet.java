package semi.Project.muktopia.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.Project.muktopia.member.model.service.*;
@WebServlet("")
public class CheckNumberServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cNumber = req.getParameter("cNumber");
		String inputEmail = req.getParameter("inputEmail");
		int result = 0;
		try {
			result = new MemberService().checkNumber(cNumber, inputEmail);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.getWriter().print(result);
	}
}
