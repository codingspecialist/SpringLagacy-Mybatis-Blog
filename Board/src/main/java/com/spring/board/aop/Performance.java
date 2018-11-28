package com.spring.board.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Performance {
	
	@Before("execution(* com.spring.board.service.BoardServiceImpl.*(..))")
	public void hello(JoinPoint jp){
		System.out.println("안녕!!");
	}
}
