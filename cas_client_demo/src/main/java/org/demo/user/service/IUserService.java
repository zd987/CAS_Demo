package org.demo.user.service;

import org.demo.user.bean.User;

public interface IUserService
{
	public String insUser(User user);
	
	public String delUser(String username);
	
	public User getUser(String username);
	
	public String updUser(User user);	
}
