package org.demo.user.service.impl;

import org.demo.user.bean.User;
import org.demo.user.dao.UserDao;
import org.demo.user.service.IUserService;

public class UserServiceImpl implements IUserService
{
    private UserDao userDao;
	/**
	 * @return the userDao
	 */
	public UserDao getUserDao() {
		return userDao;
	}

	/**
	 * @param userDao the userDao to set
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public User getUser(String username) {
		return userDao.getUser(username);
	}

	@Override
	public String updUser(User user) {
		userDao.updUser(user);
		return "true";
	}

	@Override
	public String insUser(User user) {
		userDao.insUser(user);
		return "true";
	}

	@Override
	public String delUser(String username) {
		userDao.delUser(username);
		return "true";
	}
}
