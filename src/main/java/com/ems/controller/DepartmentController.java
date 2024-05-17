package com.ems.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ems.entity.Department;
import com.ems.exception.DepartmentNotEmptyException;
import com.ems.exception.DepartmentNotFoundException;
import com.ems.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired
    private DepartmentService departmentService;

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }
    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department updatedDepartment) {
        try {
            Department updated = departmentService.updateDepartment(id, updatedDepartment);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (DepartmentNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable Long id) {
        try {
            departmentService.deleteDepartment(id);
            return ResponseEntity.ok().build();
        } catch (DepartmentNotEmptyException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Cannot delete department with assigned employees");
        } catch (DepartmentNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartment(
            @PathVariable Long id,
            @RequestParam(required = false) String expand) {
        
        Optional<Department> departmentOpt = departmentService.getDepartmentById(id);
        
        if (departmentOpt.isPresent()) {
            Department department = departmentOpt.get();
            if ("employee".equals(expand)) {
                // Load employees if expand=employee
                department.getEmployees().size(); // Trigger loading of employees
            } else {
                // Avoid loading employees if not requested
                department.setEmployees(null);
            }
            return ResponseEntity.ok(department);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    

}
