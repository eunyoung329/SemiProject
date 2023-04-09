package semi.Project.muktopia.common.wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncryptWrapper extends HttpServletRequestWrapper {

	public EncryptWrapper(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getParameter(String name) {
		String value = null;
		
		switch(name) {
		case "inputPw":
		case "memberPw":
		case "currentPw":
		case "newPw" :
			value = getSha512(super.getParameter(name));
			break;
		default : value = super.getParameter(name);
			//암호하가 되는 경우가 아니라면 기존 getParameter() 메서드 형태를 유지
		
		}
		return value;
	}
	private String getSha512(String pw) {
		//매개변수 pw : 암호화 되기 전 비밀번호
		String encryptPw = null;
		
		//1. 해시 함수를 수행할 객체를 참조할 변수
		MessageDigest md = null;
		//update라는 것이 존재 이것을 호출할때마다 ㅊ객체에 저장되어있는 값을 갱신.
		//난생처음 보는 error발생
		try {
			//2. SHA-512방식의 해시 함수를 수행할 수 있는 객체를 얻어옴.
			md = MessageDigest.getInstance("SHA-512");
			//3. md를 이용해 암호화를 진행할 수 있도록 pw를 byte[]형태 변환 SHA-512에서 512는 바이트와 관련.
			
			byte[] bytes = pw.getBytes(Charset.forName("UTF-8"));
			
			// 4. 암호화 수행->암호화 결과가 md 내부에 저장됨.
			md.update(bytes);
			
			// 5. 암호화된 비밀번호를 encryptPw에 대입.
			//Base64 : byte코드를 문자열로 변환하는 객체
			encryptPw = Base64.getEncoder().encodeToString(md.digest());//md.digest => byte계열로 hash를 반환하는 것.
			System.out.println("암호화 전 : " + pw);
			System.out.println("암호화 후 : " + encryptPw);
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
			
		}
		//암호화가된 비밀번호 저장 변수
		return encryptPw;
	}
	
}
