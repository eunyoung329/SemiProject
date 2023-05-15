package semi.Project.muktopia.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import semi.Project.muktopia.common.wrapper.EncryptWrapper;



@WebFilter(filterName="encryptFilter", urlPatterns={"/member/login",
													"/member/signUp",
													"/member/board",
													"/member/pwChange",
													"/member/searchPage",													"/member/myPage/changePw",
													"/member/myPage/secession",
													"/member/myPage/changePwFirst",
													"/member/myPage/secessionPw",
													"/admin/adminLogin"
													})
public class EncryptFilter extends HttpFilter implements Filter{
	public EncryptFilter() {
        super();
        
    }
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		EncryptWrapper wrapper = new EncryptWrapper(req);
		chain.doFilter(wrapper, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}
}
