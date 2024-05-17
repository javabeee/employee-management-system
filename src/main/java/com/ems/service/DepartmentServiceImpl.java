package com.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.entity.Department;
import com.ems.exception.DepartmentNotEmptyException;
import com.ems.exception.DepartmentNotFoundException;
import com.ems.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Department createDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override


	public Department updateDepartment(Long id,Department department)throws DepartmentNotFoundException{
		Optional<Department> optionalDepartment = departmentRepository.findById(id);
		
		if (optionalDepartment.isPresent()) {
			Department existingDepartment = optionalDepartment.get();
			existingDepartment.setDepartmentName(department.getDepartmentName());
			existingDepartment.setCreationDate(department.getCreationDate());
			existingDepartment.setDepartmentHead(department.getDepartmentHead());
	       
	        
	        return departmentRepository.save(existingDepartment);
	    } else {
	        throw new DepartmentNotFoundException("Department with ID " + id + " not found");
	      }
		
		}

	@Override
	public void deleteDepartment(Long id) throws DepartmentNotFoundException, DepartmentNotEmptyException {
		Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException("Department with ID " + id + " not found"));

        // Check if there are any employees assigned to the department
        if (!department.getEmployees().isEmpty()) {
            throw new DepartmentNotEmptyException("Cannot delete department with assigned employees");
        }

        departmentRepository.delete(department);
    }

	@Override
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public Optional<Department> getDepartmentById(Long id) {
		return departmentRepository.findById(id);
	}
		
}


