package semi.Project.muktopia.member.controll;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import semi.Project.muktopia.member.model.service.AdminService;

import semi.Project.muktopia.member.model.vo.ReportStore;


@WebServlet("/admin/adminReportAll")
public class AdminReportAllServlet extends HttpServlet{


   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   
   
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      

      try {
      
         // 서비스 객체 생성
           AdminService service = new AdminService();

           // selectAll() 메서드를 사용하여 ReportStore 목록을 가져옴
           
           List<ReportStore> stdList = service.AdminReportAll();
           

           // stdList를 JSON 형식으로 응답으로 전송
           //resp.setContentType("application/json");
           new Gson().toJson(stdList, resp.getWriter());
           
           System.out.println(stdList);

         
           
         
      }catch(Exception e) {
         e.printStackTrace();
      }
      
      
      
      
      
      
   }


}