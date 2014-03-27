package org.demo.user.dao;

import org.demo.user.bean.User;

public interface UserDao {

	public User getUser(String username);

	public void insUser(User user);

	public void delUser(String username);

	public void updUser(User user);
}
