package com.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.entity.Employee;
import com.ems.exception.EmployeeNotFoundException;
import com.ems.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
    private EmployeeRepository employeeRepository;
	
	@Override
	public Employee createEmployee(Employee employee) {
		 return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	public Employee updateEmployee(Long id,Employee employee)throws EmployeeNotFoundException{
	Optional<Employee> optionalEmployee = employeeRepository.findById(id);
	
	if (optionalEmployee.isPresent()) {
        Employee existingEmployee = optionalEmployee.get();
        existingEmployee.setName(employee.getName());
        existingEmployee.setDateOfBirth(employee.getDateOfBirth());
        existingEmployee.setAddress(employee.getAddress());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setRole(employee.getRole());
        existingEmployee.setJoiningDate(employee.getJoiningDate());
        existingEmployee.setBonusPercentage(employee.getBonusPercentage());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setReportingManager(employee.getReportingManager());
        
        return employeeRepository.save(existingEmployee);
    } else {
        throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
      }
	
	}
}
