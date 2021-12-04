package com.shiva.exception;


	import org.springframework.web.bind.annotation.ResponseStatus;
	import org.springframework.http.HttpStatus; 

	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public class GlobalException extends RuntimeException {
		public GlobalException(String s)
		{
			super(s);
		}

	}
