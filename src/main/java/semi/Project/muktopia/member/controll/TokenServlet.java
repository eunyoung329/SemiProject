package semi.Project.muktopia.member.controll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/tokenServlet")
public class TokenServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String access_token = req.getParameter("access_token");
		HttpSession session = req.getSession();
		System.out.println(access_token);
		String name = getkakaoName(access_token);
		session.setAttribute("name", name);
		resp.getWriter().write(name+"");
	}
	
	public String getkakaoName(String access_token) {
		String name = "";
		
		final String AUTH_HOST = "https:/kauth.kakao.com";
		final String tokenRequestUrl = AUTH_HOST + "/oauth/token";
		
		String CLIENT_ID = "";
		String redirect_URI = "";
		String code = "";
		String getPersonalInfoUri = "https:/kapi.kakao.com/v2/user/me";
		String token_type = "token_type";
		
		HttpsURLConnection conn = null;
		OutputStreamWriter writer =null;
		BufferedReader reader = null;
		InputStreamReader isr =null;
		URL url = null;
		
		try {
			url = new URL(getPersonalInfoUri);
			conn =(HttpsURLConnection) url.openConnection();
			conn.setRequestProperty("Authorization", "Bearer " +access_token.trim());
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded ");
			conn.setRequestProperty("charset","utf-8");
			
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			
			writer = new OutputStreamWriter(conn.getOutputStream());
			writer.flush();
			
			int responseCode = conn.getResponseCode();
			
			isr = new InputStreamReader(conn.getInputStream());
			reader =new BufferedReader(isr);
			final StringBuffer buffer = new StringBuffer();
			String line;
			while((line = reader.readLine()) != null){
				buffer.append(line);
			}
			String responseParam = buffer.toString();
			System.out.println(responseParam);
			name = responseParam.substring(responseParam.indexOf("nickname")+11, responseParam.indexOf("profile_image")-3);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return name;
		
	}
}
