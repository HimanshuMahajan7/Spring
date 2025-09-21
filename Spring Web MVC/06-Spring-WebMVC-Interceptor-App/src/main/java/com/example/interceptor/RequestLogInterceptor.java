package com.example.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.example.config.AppConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class RequestLogInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("preHandle() method called....");
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle() method called....");
		long startTime = (long)request.getAttribute("startTime");
		long endTime = System.currentTimeMillis();
		long timeTaken = endTime - startTime;
		System.out.println("Total time taken: " + timeTaken + " milli seconds"); 
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

}
