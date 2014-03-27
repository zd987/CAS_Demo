package org.demo.user.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.demo.user.bean.User;
import org.demo.user.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IdentityInfoFilter implements Filter{
	private final static Logger logger = LoggerFactory.getLogger(IdentityInfoFilter.class);
	private IUserService userService = null;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,   
            FilterChain chain) throws IOException, ServletException { 
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        String path = ((HttpServletRequest) request).getRequestURI();
        if (session.getAttribute("identity") == null 
        		&& !path.startsWith("/app/user!addUser.action") 
        		&& !path.startsWith("/app/pages/firstLogin.jsp") ) {
            try{
            	String username = req.getRemoteUser();
                User user = userService.getUser(username);
                if(user == null) {
                	logger.info(username + "is first login");
                	String contextPath = req.getContextPath();
                	res.sendRedirect(contextPath + "/pages/firstLogin.jsp"); 
                	return;
                } else {
                	session.setAttribute("identity", user);
                }
            }catch(Exception e){
                e.printStackTrace();
            }            
        }
        chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
        @SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:config/spring/beans.xml");
        userService = (IUserService)context.getBean("userService");
	}

}
