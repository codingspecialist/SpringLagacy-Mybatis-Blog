package com.spring.board.persistent;

import com.spring.board.domain.UserVO;

public interface UserDAO {
	void insert(UserVO userVO) throws Exception;
	void delete(int userID) throws Exception;
	int loginCheck(UserVO userVO) throws Exception;
}
