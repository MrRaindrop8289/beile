package cn.gamers.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamers.domain.User;

/**
 * Servlet Filter implementation class EncodeFilter
 */
@WebFilter("/EncodeFilter")
public class EncodingFilter implements Filter {
	private static final String SHOW_LOGIN_PATH = "Client/Login.jsp";    //显示登录页面  
    private static final String DO_LOGIN_PATH = "DO_LOGIN_PATH";        //登录操作不能过滤掉  
    private static final String LOGIN_PERSONID = "LOGIN_PERSONID"; 
    /**
     * Default constructor. 
     */
    public EncodingFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	
	//Only Post!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		// pass the request along the filter chain
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		if(httpRequest.getServletPath().equals("/beile/Client/Login.jsp")){
			chain.doFilter(request, response);
		}else{
			if(httpRequest.getSession().getAttribute("User") == null){
				httpRequest.getSession().setAttribute("User", "login");
				httpResponse.sendRedirect("/beile/Client/Login.jsp");
			}else{
				chain.doFilter(request, response);
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
