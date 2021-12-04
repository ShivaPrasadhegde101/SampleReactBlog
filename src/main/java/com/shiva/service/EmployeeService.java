package com.shiva.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.shiva.bean.Employee;
import com.shiva.dao.EmployeeDao;
import com.shiva.dao.IEmployeeRepository;
import com.shiva.exception.GlobalException;

@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	IEmployeeRepository repo;

	@Override
	public List<Employee> finalAllEmployee() {
		
		return repo.findAll();
	}

	@Override
	public List<Employee> createEmployee(Employee emp) throws GlobalException{
		Optional<Employee> e = repo.findById(emp.getEmpid());
		if(e.isPresent())
		{
			throw new GlobalException("Employee with Id "+emp.getEmpid()+" Already exists");
		}
		
		repo.save(emp);
		
		return finalAllEmployee();
		}

	@Override
	public Employee findEmployee(int empid) {
		Optional<Employee> op=repo.findById(empid);
		if(op.isPresent())
			return op.get();
		else
			return null;
	}



	@Override
	public List<Employee> deleteEmployee(int empid) {
		Employee emp=findEmployee(empid);
		if(emp!=null) {
			repo.delete(emp);
		}
		return finalAllEmployee();
	}
	
	@Override
	public List<Employee> updateEmployee(Employee newEmployee)
	{
		Optional<Employee>opt =  repo.findById(newEmployee.getEmpid()).map(employee -> {
			employee.setName(newEmployee.getName());
			employee.setDob(newEmployee.getDob());
			employee.setSalary(newEmployee.getSalary());
		
			return repo.save(employee);
		});
		if(opt.isPresent())
		{
			return finalAllEmployee();
		}
		throw new GlobalException("Employee with Id "+newEmployee.getEmpid()+ " is not avaliable for update");
	}

	@Override
	public ArrayList<Employee> getEmployeebean()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml",EmployeeDao.class);
		return (ArrayList)context.getBean("edao");
	}
}
