package com.spring.board.persistent;

import java.util.List;

import com.spring.board.domain.ReplyVO;

public interface ReplyDAO {
	void insert(ReplyVO replyVO) throws Exception;
	void delete(int rNum) throws Exception;
	List<ReplyVO> list(int bNum) throws Exception;
	int selectMaxRnum() throws Exception;
}
