package semi.Project.muktopia.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName = "encodingFilter", urlPatterns="/*")
public class EncodingFilter extends HttpFilter implements Filter{
	public void init(FilterConfig fConfig) throws ServletException{//기본 형태 때에 따라 많은 것을 구현할 수 있음.
		System.out.println("문자 인코딩 필터 초기화");
	}
	
	/**
	 *서버 실행 중 필터 코드가 변경되어
	 *기존 필터를 없애야 할 때 수행되는 메서드
	 */
	public void destroy() {
		System.out.println("문자 인코딩 필터 파괴");
		
	}
	
	/**
	 * 필터 역할을 수행하는 메서드
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
		//ServletRequest == HttpServletRequest의 부모타입
		//ServletResponse == HttpServletResponse의 부모타입
		// -> 필요 시 다운 캐스팅
		
		// 모든 요청의 문자 인코딩을 UTF-8로 설정
		request.setCharacterEncoding("UTF-8");
		
		// 모든 응답의 문자 인코딩을 UTF-8로 설정
		response.setCharacterEncoding("UTF-8");
		
		//--------------------------------------------------------------------------------------------------------------------
		
		//application scope로 최상위 경로를 얻어올 수 있는 값 세팅
		
		// 1) application 내장 객체 얻어오기
		ServletContext application = request.getServletContext();
		// 2) 최상위 주소 얻어오기
		String contextPath = ((HttpServletRequest)request).getContextPath();
		// 3) 세팅
		System.out.println(contextPath);
		application.setAttribute("contextPath", contextPath);
		// 연결된 다음 필터 수행(없으면 Servlet 수행)
		chain.doFilter(request, response);
		}
	

}
