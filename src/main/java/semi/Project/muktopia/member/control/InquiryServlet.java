package semi.Project.muktopia.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semi.Project.muktopia.member.model.service.InquiryService;
import semi.Project.muktopia.member.model.vo.Member;

@WebServlet("/inquiry/inquiry")
public class InquiryServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
        String path = "/WEB-INF/views/inquiry/inquiry.jsp";
        req.getRequestDispatcher(path).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        

        String inquiryCategory = req.getParameter("category");
        String inquiryTitle = req.getParameter("inquiryTitle");
        String inquiryContent = req.getParameter("inquiryContent");
    
        //세션 
        HttpSession session=req.getSession();
        //로그인멤버
        Member loginMember = (Member) session.getAttribute("loginMember");
		int memberNo = loginMember.getMemberNo(); // Member 클래스에서 이메일 값을 반환하는 getEmail() 메소드 사용
		
       
        
        try {
            
             System.out.print(inquiryCategory+memberNo+inquiryTitle+inquiryContent);
            
           int result = new InquiryService().inquiry(memberNo,inquiryCategory,inquiryTitle,inquiryContent);
            
            System.out.println();
            
            if(result>0) {
                System.out.println("1대1문의 성공");
                        
                resp.sendRedirect(req.getContextPath());
            }else {
                System.out.println("1대1문의 실패.");
                resp.sendRedirect(req.getContextPath());
            }
            
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
        

      
    
	
	
	
	
	
	
}
