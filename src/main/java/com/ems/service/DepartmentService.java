package com.ems.service;

import java.util.List;
import java.util.Optional;

import com.ems.entity.Department;
import com.ems.exception.DepartmentNotEmptyException;
import com.ems.exception.DepartmentNotFoundException;

public interface DepartmentService {
	
	Department createDepartment(Department department);
	List<Department> getAllDepartments();
	Department updateDepartment(Long id,Department department);
	void deleteDepartment(Long id) throws DepartmentNotFoundException, DepartmentNotEmptyException;
	Optional<Department> getDepartmentById(Long id);
}
