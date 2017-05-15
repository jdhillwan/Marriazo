package com.webosoft.handler;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RequestPreHandler {

	@Autowired
	HttpSession session;

	@Around("execution(* com.webosoft.*.*Controller.*(..))")
	public Object beforeServiceImpl(ProceedingJoinPoint pjp) throws Throwable {

		/*if (session.getAttribute("userName") == null) {
			// throw new SessionException("session is null");
			return 0;
		} else {
			return pjp.proceed();
		}*/
		return pjp.proceed();
	}

}
