package com.spring.board.persistent;

import java.util.List;

import com.spring.board.domain.BoardVO;

public interface BoardDAO {
	void insert(BoardVO board) throws Exception;
	void delete(int bNum) throws Exception;
	void update(BoardVO board) throws Exception;
	void updateReadCount(int bNum) throws Exception;
	List<BoardVO> list(int page) throws Exception;
	BoardVO select(int bNum) throws Exception;
}
