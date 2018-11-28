package com.spring.board.persistent;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.board.domain.UserVO;

@Repository
public class UserDAOImpl implements UserDAO{

	@Inject
	private SqlSession session;
	private static final String namespace = "com.spring.user";
	
	@Override
	public void insert(UserVO userVO) throws Exception {
		session.insert(namespace+".insert", userVO);
	}

	@Override
	public void delete(int userID) throws Exception {
		session.delete(namespace+".delete", userID);
	}
	
	@Override
	public int loginCheck(UserVO userVO) throws Exception {
		return session.selectOne(namespace+".loginCheck", userVO);
	}
}
