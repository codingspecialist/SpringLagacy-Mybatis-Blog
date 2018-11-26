package com.spring.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.board.domain.BoardVO;
import com.spring.board.domain.ReplyVO;
import com.spring.board.persistent.BoardDAO;
import com.spring.board.persistent.ReplyDAO;
import com.spring.board.util.MyUtils;

//Controller, Repository, Service, Component
@Controller
public class BController {

	@Autowired
	private BoardDAO boardDAO;
	
	@Autowired
	private ReplyDAO replyDAO;
	
	//dispatcher역활
	//http://localhost:8000/board/
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/board/list")
	public String boardList(Model model, @RequestParam(defaultValue="1") int page) throws Exception{	
		List<BoardVO> list = boardDAO.list(page);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "/board/list";
	}
	
	@RequestMapping("/board/writeForm")
	public String boardWriteForm() throws Exception{	
		return "/board/writeForm";
	}	
	
	//@RequestParam String bTitle
	@RequestMapping(value="/board/write", method= RequestMethod.POST)
	public String boardWrite(BoardVO boardVO) throws Exception{
		boardDAO.insert(boardVO);
		return "redirect:/board/list";
	}
	
	@RequestMapping("/admin/board/delete")
	public String adminBoardDelete(@RequestParam int bNum, HttpSession session) throws Exception{	
		boardDAO.delete(bNum);
		return "redirect:/board/list";
	}
	
	@RequestMapping("/board/delete")
	public String boardDelete(@RequestParam int bNum) throws Exception{	
		boardDAO.delete(bNum);
		return "redirect:/board/list";
	}
	
	@RequestMapping("/board/detail")
	public String boardDetail(@RequestParam int bNum, Model model) throws Exception{	
	    //조회수 증가
		boardDAO.updateReadCount(bNum);
		BoardVO boardVO = boardDAO.select(bNum);
		List<ReplyVO> list = replyDAO.list(bNum);
		String result = MyUtils.getYoutubeMovie(boardVO.getbContent());
		boardVO.setbContent(result);
		model.addAttribute("boardVO", boardVO);
		model.addAttribute("list", list);
		return "/board/detail";
	}		
	
	@RequestMapping("/board/updateForm")
	public String boardUpdateForm
	(@RequestParam int bNum, Model model) throws Exception{	
		BoardVO boardVO = boardDAO.select(bNum);
		model.addAttribute("boardVO", boardVO);
		return "/board/updateForm";
	}	
	
	@RequestMapping(value="/board/update", method= RequestMethod.POST)
	public String boardUpdate(BoardVO boardVO) throws Exception{
		boardDAO.update(boardVO);
		return "redirect:/board/list";
	}
	
}
