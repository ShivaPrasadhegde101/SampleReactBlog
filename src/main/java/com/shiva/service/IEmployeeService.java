package com.shiva.service;

import java.util.ArrayList;
import java.util.List;

import com.shiva.bean.Employee;

public interface IEmployeeService {
	List<Employee> finalAllEmployee();
	List<Employee> createEmployee(Employee emp);
	Employee findEmployee(int empid);
	List<Employee> updateEmployee(Employee emp);
	List<Employee> deleteEmployee(int empid);
	public ArrayList<Employee> getEmployeebean();
}
