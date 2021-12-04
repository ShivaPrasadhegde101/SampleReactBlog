package com.shiva.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shiva.bean.Employee;

public class EmployeeDao {
	
	private ArrayList<Employee> employees;
	
	public EmployeeDao()
	{
		super();
	}
	
	public EmployeeDao(ArrayList<Employee> e)
	{
		this.employees = e;
	}
	
	
	public ArrayList<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}




}
