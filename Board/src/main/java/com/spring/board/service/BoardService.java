package com.spring.board.service;

import java.util.List;

import com.spring.board.domain.BoardVO;

public interface BoardService {
	void insert(BoardVO board) throws Exception;
	void delete(int bNum) throws Exception;
	void update(BoardVO board) throws Exception;
	List<BoardVO> list(int page) throws Exception;
	BoardVO detailService(int bNum) throws Exception;
//	void updateReadCount(int bNum) throws Exception;
    BoardVO select(int bNum) throws Exception;
}
