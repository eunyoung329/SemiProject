package semi.Project.muktopia.member.control;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import semi.Project.muktopia.member.model.service.MemberService;
import semi.Project.muktopia.member.model.vo.Member;

@WebServlet("/member/findEmail")
public class SelectOneServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//인코딩 안해도 된다.
		String memberEmail = req.getParameter("memberEmail");
		System.out.println(memberEmail+"이다");
		try {
		MemberService service = new MemberService();
		Member member = service.selectOne(memberEmail);//java객체상태.->javascript로 바꾸어야 함.
		
		//javascript로 변환하기.
		//1) java - > json - > javascript
		//방법
		//1) json 직접 작성 -> 오타
		//String str = "{\"memberNickname\":\""+member.getMemberNickname()+\}";
		//2) JSON-simple 라이브러리 JSONObject 사용
		System.out.println(member);
		//3) GSON 라이브러리를 이용한 Java 객체 - >json 변환
		//new Gson().toJson(객체, 응답스트림);
		//-> 매개변수에 작성된 객체를 JSON형태로 변환한 후 스트림 통해서 출력
		new Gson().toJson(member, resp.getWriter());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
