package com.shiva.exception;
import java.time.LocalDate;

public class ErrorMapper {

	String url;
	String message;
	LocalDate date;
	public ErrorMapper(String url, String message,LocalDate date) {
		super();
		this.url = url;
		this.message = message;
		this.date = date;
	}
	
	public ErrorMapper()
	{
		super();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ErrorMapper [url=" + url + ", message=" + message + ", date=" + date + "]";
	}
	
	
	
	
	
}
