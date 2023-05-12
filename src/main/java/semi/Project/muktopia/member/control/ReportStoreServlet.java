package semi.Project.muktopia.member.control;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.oreilly.servlet.MultipartRequest;

import semi.Project.muktopia.common.MyRenamePolicy;

import semi.Project.muktopia.member.model.service.ReportStoreService;
import semi.Project.muktopia.member.model.vo.Member;
import semi.Project.muktopia.member.model.vo.ReportStore;

@WebServlet("/report/reportStore")
public class ReportStoreServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = "/WEB-INF/views/report/reportStore.jsp";
		req.getRequestDispatcher(path).forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		try {
			
		//업로드되는 파일의 크기를제한
			
		int maxSize = 1024 * 1024 * 20;
		
		
		HttpSession session = req.getSession(); 
		
		String root = session.getServletContext().getRealPath("/");
		//실제 파일이 저장되는 경로
		String folderPath = "/resources/img/report/";
		
		//report폴더까지의 절대경로
		String filePath = root + folderPath;
		
		
		String encoding = "UTF-8";
		
		// MultipartRequest 객체가 생성됨과 동시에 지정된 경로에
		// 지정된 파일명 변경 정책에 맞게 이름이 바뀐 파일이 저장(서버 업로드)된다.
		MultipartRequest mpReq = new MultipartRequest(req, filePath, maxSize, encoding, new MyRenamePolicy());
		
		//service호출시 필요한값 
		Member loginMember = (Member) session.getAttribute("loginMember");
		int memberNo = loginMember.getMemberNo(); // Member 클래스에서 이메일 값을 반환하는 getEmail() 메소드 사용
		
		
		
		String rest_img = folderPath + mpReq.getFilesystemName("rest_img");
		

        String rest_category = mpReq.getParameter("rest_category");
        String rest_name = mpReq.getParameter("rest_name");
        String []Addr=mpReq.getParameterValues("rest_Addr");
        
	    String rest_Addr = null;
				
	    if(!Addr[0].equals("")) { // 우편번호가 빈칸이 아니라면 == 주소 작성
	    	rest_Addr= String.join(",", Addr);
					
	        // String.join("구분자", 배열)
	        // -> 배열 요소를 하나의 문자열로 반환
	        //    요소 사이에 "구분자" 추가
	    } 
		
	    String report_content = mpReq.getParameter("report_content");
		
		
		//Service 호출 후 결과 반환 받기
	    
	    
	    System.out.println(rest_img);
	    System.out.println(rest_category);  
	    System.out.println(rest_name);
	    System.out.println(rest_Addr);
	    System.out.println(memberNo);
	    System.out.println(report_content);
	 
		
	    ReportStoreService service = new ReportStoreService();
		
		int result = service.reportStore(memberNo,rest_category,rest_img,rest_name,rest_Addr,report_content);
		
		
		if( result > 0) { // 성공
			
			session.setAttribute("message", "제보가 제출되었습니다.");
			resp.sendRedirect("reportStore");
		
			
			
		} else { // 실패
			
			session.setAttribute("message", "제보가 실패.");
			resp.sendRedirect("reportStore");
		}
		
		
		
	
		
		
		
	} catch(Exception e) {
		e.printStackTrace();
	}
	
}


}
