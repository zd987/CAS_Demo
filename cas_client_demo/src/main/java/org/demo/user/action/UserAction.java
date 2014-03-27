/**
 * 
 */
package org.demo.user.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.demo.user.bean.User;
import org.demo.user.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport implements RequestAware {
	private final static Logger logger = LoggerFactory.getLogger(UserAction.class);
	private static final long serialVersionUID = 1377782121025592065L;
	private IUserService userService;
	private User user;
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String addUser() {
		logger.info("add User" + user);
		String result = userService.insUser(user);
		return result;
	}
	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
