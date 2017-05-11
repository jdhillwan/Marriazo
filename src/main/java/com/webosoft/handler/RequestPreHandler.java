package com.webosoft.handler;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webosoft.exceptions.SessionException;

@Component
@Aspect
public class RequestPreHandler {

	@Autowired
	HttpSession session;

	@Before("execution(* com.webosoft.*.*Controller.*(..))")
	public int beforeServiceImpl(JoinPoint joinPoint) throws SessionException {

		if (session.getAttribute("userName") == null) {
			// throw new SessionException("session is null");
			return 0;
		} else
			return 1;
	}

}
