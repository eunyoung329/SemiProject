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
import semi.Project.muktopia.member.model.service.MemberService;
import semi.Project.muktopia.member.model.vo.*;

@WebServlet("/member/profileImg")
public class ProfileImgServlet extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			// 이미지 크기의 전체 합 
			int maxSize = 1024 * 1024 * 20;
			
			// profileImg 폴더까지의 절대 경로 
			HttpSession session = req.getSession();
			
			// 최상위 경로의 컴퓨터상 실제 절대 경로 
			String root = session.getServletContext().getRealPath("/");
			
			// 실제 파일이 저장되는 폴더의 경로 
			String folderPath = "resources/img/profileImg/";
			
			// profileImg까지의 절대 경로 조합 
			String filePath = root + folderPath;
			
			// 파일 이외의 파라미터 문자 인코딩 지정 
			String encoding = "UTF-8";
			
			// MultipartRequest 생성 
			MultipartRequest mpReq = new MultipartRequest(req, filePath, maxSize, encoding, new MyRenamePolicy()); 
			
			
			
			//----Service 호출
			Member loginMember = (Member)session.getAttribute("loginMember");
			int memberNo = loginMember.getMemberNo();
			System.out.println("servlet: " + memberNo);
			
			//db에 삽입될 프로필 이미지 경로 
			String profileImage = folderPath + mpReq.getFilesystemName("profileImage");
			System.out.println("profileImage: " + profileImage);
			
			
			
			//---- 삭제 버튼 누리면 null 가져옴 
			int delete = Integer.parseInt(mpReq.getParameter("info_img_delete"));
			
			if(delete == 1) {
				profileImage = null;
			}
			
			
			//---- 프로필 이미지 변경 서비스 호출 후 결과 반환 
			MemberService service = new MemberService();
			
			int result = service.updateProfileImage(memberNo, profileImage);
			
			if(result > 0) {
				session.setAttribute("message", "프로필 이미지가 변경되었습니다.");
				loginMember.setProfileImage(profileImage);
			} else {
				session.setAttribute("message", "프로필 이미지 변경에 실패하였습니다. 다시 시도해주세요.");
			}
			
			
			// 성공 실패 상관 없이 프로필 화면 재요청 
			resp.sendRedirect("infoChange");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} 
	
}
