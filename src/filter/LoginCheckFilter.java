package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dto.Member;

//@WebFilter("/*")
public class LoginCheckFilter implements Filter {
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("LoginCheckFilter 처리");
		//세션확인
		HttpServletRequest httpRequest=(HttpServletRequest)request;
		HttpSession session=httpRequest.getSession();
		System.out.println(session);
		Object obj=session.getAttribute("logInfo");
		
		if(obj==null) {
			System.out.println("로그인 세션이 존재하지 않습니다, 로그인페이지로 이동");
			//페이지 이동
			String path="/WEB-INF/view/member/login.jsp";
			request.getRequestDispatcher(path).forward(request, response);
			return;
		}
			
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}


}
