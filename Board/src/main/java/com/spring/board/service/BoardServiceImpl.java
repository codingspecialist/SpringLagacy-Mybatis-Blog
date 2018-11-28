package com.spring.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.board.domain.BoardVO;
import com.spring.board.persistent.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	private BoardDAO boardDAO;

	@Override
	public void insert(BoardVO board) throws Exception {
		boardDAO.insert(board);
	}

	@Override
	public void delete(int bNum) throws Exception {
		boardDAO.delete(bNum);
	}

	@Override
	public void update(BoardVO board) throws Exception {
		boardDAO.update(board);	
	}

	@Override
	public List<BoardVO> list(int page) throws Exception {
		return boardDAO.list(page);
	}

	@Transactional
	@Override
	public BoardVO detailService(int bNum) throws Exception {
		boardDAO.updateReadCount(bNum);
		return boardDAO.select(bNum);
	}

	@Override
	public BoardVO select(int bNum) throws Exception {
		return boardDAO.select(bNum);
	}
	
}
