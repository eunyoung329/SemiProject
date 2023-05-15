package semi.Project.muktopia.member.controll;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import semi.Project.muktopia.member.model.service.AdminService;
import semi.Project.muktopia.member.model.vo.Member;


@WebServlet("/admin/deleteReport")
public class DeleteReportServlet extends HttpServlet{

   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      //memberNO받아오기,report_index받아오기
      
      int report_index = Integer.parseInt(req.getParameter("report_index"));
      HttpSession session = req.getSession();
      Member loginMember = (Member) session.getAttribute("loginMember");

      
      //서비스호출
      AdminService service=new AdminService();
      
      try {
         //admin
         int result=service.DeleteReport(report_index);
         System.out.println(result);
         if(result > 0 ) {
        	 session.setAttribute("message", "삭제가 성공하였습니다.");
         }else {
        	 session.setAttribute("message", "삭제가 실패하였습니다.");
         }
          new Gson().toJson(result, resp.getWriter());
          //resp.sendRedirect(req.getContextPath());
         
         
      }catch(Exception e) {
         e.printStackTrace();
      }
      
      
      
   }

   
   
   
   
   
   
}