package com.shiva.exception;

import java.time.LocalDate;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DemoException {
	
	@ResponseBody
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(value= {Exception.class})
	public ErrorMapper  handleError(Exception e,HttpServletRequest req)
	{
		return new ErrorMapper(req.getRequestURI(),e.getMessage(),LocalDate.now());
	}

}
