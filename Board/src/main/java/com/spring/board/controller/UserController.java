package com.spring.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.board.domain.UserVO;
import com.spring.board.persistent.UserDAO;

@Controller
public class UserController {

	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping("/user/joinForm")
	public String userJoinForm(){
		return "/user/joinForm";
	}
	
	@RequestMapping("/user/join")
	public String userJoin(UserVO userVO) throws Exception{
		userDAO.insert(userVO);
		return "redirect:/";
	}
	
	@RequestMapping("/user/loginForm")
	public String userLoginForm(){
		return "/user/loginForm";
	}
	
	@RequestMapping(value="/user/login", method=RequestMethod.POST)
	public String userLogin(UserVO userVO,Model model) throws Exception{
		int result = userDAO.loginCheck(userVO);
		model.addAttribute("result", result);
		model.addAttribute("userVO", userVO);
		
		if(result == 1){
			return "redirect:/";
		}else{
			return "/user/loginForm";
		}
	}
	
	@RequestMapping("/user/logout")
	public String userLogout(HttpSession session){
		session.removeAttribute("userEmail");
		return "redirect:/";
	}
	
	
}
