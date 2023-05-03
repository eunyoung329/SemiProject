package semi.Project.muktopia.member.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semi.Project.muktopia.member.model.service.MemberService;
import semi.Project.muktopia.member.model.vo.Member;

@WebServlet("/member/infoChange")
public class infoChangeServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/member/infoChange.jsp";
		req.getRequestDispatcher(path).forward(req, resp);

	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		try {
			// 로그인 회원 번호 
			HttpSession session = req.getSession();
			Member loginMember = (Member)session.getAttribute("loginMember");
			int memberNo = loginMember.getMemberNo();
			
			// 파라미터 
			String inputNickname = req.getParameter("memberNickname");
			String inputTel = req.getParameter("memberTel");
			String inputBirth = req.getParameter("memberBirth");
			String[] inputAddr = req.getParameterValues("memberAddress");
			
			int result = new MemberService().updateInfo(memberNo,inputNickname,inputTel, inputBirth, inputAddr);
			
			if(result > 0) {
				
				loginMember.setMemberNick(inputNickname);
				loginMember.setMemberTel(inputTel);
				loginMember.setMemberBirth(inputBirth);
				
				String address = String.join(",,", inputAddr);
				loginMember.setMemberAddress(address);		
			}
			
			
			resp.sendRedirect("infoChange");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
