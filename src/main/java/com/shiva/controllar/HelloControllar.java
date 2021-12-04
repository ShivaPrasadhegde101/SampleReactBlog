package com.shiva.controllar;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shiva.bean.Employee;
import com.shiva.service.IEmployeeService;


@CrossOrigin
@RestController 
@RequestMapping("employee")
public class HelloControllar {
	@Autowired
	private IEmployeeService eService;
	
	@GetMapping(value="/viewEmployee",produces={"application/json"})
	public List<Employee> allEmployee() {
		return eService.finalAllEmployee();
	}
	@GetMapping("/{eid}")
	public Employee findEmployee(@PathVariable("eid") int empid) {
		return eService.findEmployee(empid);
	}
	@PostMapping(value="/addEmployee")
	public List<Employee> createEmployee(@RequestBody Employee emp) {
		System.out.println("add employee");
		return eService.createEmployee(emp);
	}
	@DeleteMapping(value="/deleteEmployee/{empid}")
	public List<Employee> deleteEmployee(@PathVariable int empid) {
		System.out.println("delete");
		return eService.deleteEmployee(empid);
	}
	
	
	@PutMapping("/update")
	public List<Employee> updateEmployee(@RequestBody Employee emp)
	{
		return eService.updateEmployee(emp);
	}
	
	
	@GetMapping("/getemployees")
	public List<Employee> getEmployees()
	{
		return eService.getEmployeebean();
	}
}
