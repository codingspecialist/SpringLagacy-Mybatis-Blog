package com.spring.board.controller;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.board.domain.ReplyVO;
import com.spring.board.persistent.ReplyDAO;

@Controller
public class RController {
	
	@Inject
	private ReplyDAO replyDAO;
	
	@RequestMapping(value="/reply/write", method=RequestMethod.POST)
	public @ResponseBody String replyWrite(@RequestBody ReplyVO reply) 
	throws Exception{
		replyDAO.insert(reply);
		int rNum = replyDAO.selectMaxRnum();
		return rNum+"";
	}
	
	@RequestMapping("/reply/delete")
	public String replyDelete(@RequestParam int rNum, 
			@RequestParam int bNum,
			RedirectAttributes redirect) throws Exception{
		replyDAO.delete(rNum);
		redirect.addAttribute("bNum", bNum);
		return "redirect:/board/detail";
	}
}
