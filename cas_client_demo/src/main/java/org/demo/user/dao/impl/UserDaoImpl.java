package org.demo.user.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.demo.user.bean.User;
import org.demo.user.dao.UserDao;

public class UserDaoImpl implements UserDao
{
    private SqlSession sqlSession;

    public SqlSession getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

	@Override
	public User getUser(String username) {
		return sqlSession.selectOne("USER.getUser", username);
	}

	@Override
	public void insUser(User user) {
		sqlSession.insert("USER.insUser", user);
	}

	@Override
	public void delUser(String username) {
		sqlSession.delete("USER.delUser", username);
	}

	@Override
	public void updUser(User user) {
		// TODO Auto-generated method stub
		sqlSession.update("USER.updUser", user);
	}
}
