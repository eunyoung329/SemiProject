package semi.Project.muktopia.member.controll;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import semi.Project.muktopia.common.MyRenamePolicy;
import semi.Project.muktopia.member.model.service.AdminService;

import semi.Project.muktopia.member.model.vo.Member;

@WebServlet("/admin/adminRegisterRest")
public class AdminRegisterRestServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/admin/adminRegisterRest.jsp").forward(req, resp);
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			//업로드되는 파일의 크기를제한
				
			int maxSize = 1024 * 1024 * 20;
			
			
			HttpSession session = req.getSession(); 
			
			String root = session.getServletContext().getRealPath("/");
			//실제 파일이 저장되는 경로
			String folderPath = "resources/img/thumbnail/";
			
			//report폴더까지의 절대경로
			String filePath = root + folderPath;
			
			
			String encoding = "UTF-8";
			
			// MultipartRequest 객체가 생성됨과 동시에 지정된 경로에
			// 지정된 파일명 변경 정책에 맞게 이름이 바뀐 파일이 저장(서버 업로드)된다.
			MultipartRequest mpReq = new MultipartRequest(req, filePath, maxSize, encoding, new MyRenamePolicy());
			
		

		
			String rest_img = folderPath + mpReq.getFilesystemName("rest_img");
			
	    String rest_category = mpReq.getParameter("rest_category");
		String rest_name=mpReq.getParameter("rest_name");
		
		String rest_x=mpReq.getParameter("rest_x");
		String rest_y=mpReq.getParameter("rest_y");
		String rest_tel=mpReq.getParameter("rest_tel");
		String rest_time=mpReq.getParameter("rest_time");
		String rest_sns=mpReq.getParameter("rest_sns");
		String []Addr=mpReq.getParameterValues("rest_Addr");
		
		String rest_Addr = null;
		
		  if(!Addr[0].equals("")) { // 우편번호가 빈칸이 아니라면 == 주소 작성
			  rest_Addr= String.join(",", Addr);
						
		        // String.join("구분자", 배열)
		        // -> 배열 요소를 하나의 문자열로 반환
		        //    요소 사이에 "구분자" 추가
		    } 
		String rest_contents=mpReq.getParameter("rest_contents");
	

		System.out.println(rest_category);
		System.out.println(rest_name);
		System.out.println(rest_img);
		System.out.println(rest_x);
		System.out.println(rest_y);
		System.out.println(rest_tel);
		System.out.println(rest_time);
		System.out.println(rest_sns);
		System.out.println(rest_Addr);
		System.out.println(rest_contents);
		
		AdminService service=new AdminService();
		
		int result=service.adminRegisterRest(rest_category,rest_name,rest_img,rest_x,rest_y,rest_tel,rest_time,rest_sns,rest_Addr,rest_contents);
		
		
		if(result>0) {//성공
			session.setAttribute("message", "레스토랑이 등록되었습니다");
			resp.sendRedirect("reportAdmin");
			
		}else {
			session.setAttribute("message", "레스토랑 등록실패");
			resp.sendRedirect("reportAdmin");
		}
	
	
	}catch(Exception e) {
	e.printStackTrace();
	}
	}
				
}
	
	
	
	
