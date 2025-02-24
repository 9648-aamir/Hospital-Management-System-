package com.qspidsers.hospital_management_system.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.qspidsers.hospital_management_system.dao.DepartmentDao;
import com.qspidsers.hospital_management_system.entity.Department;

@RestController
@RequestMapping(value = "/departmentController")
public class DepartmentController {

    @Autowired
    private DepartmentDao departmentDao;

    // Save a new department
    @PostMapping(value = "/saveDepartment")
    public List<Department> saveDepartmentController(@RequestBody  List<Department> department) {
        return departmentDao.saveDepartmentDao(department);
    }
    
    
    

    
    
    

    // Get all departments
    @GetMapping(value = "/getAllDepartments")
    public List<Department> getAllDepartments() {
        return departmentDao.getAllDepartmentsDao();
    }

    // Get a department by ID
    @GetMapping(value = "/getDepartmentById/{id}")
    public Department getDepartmentByIdController(@PathVariable Integer id) {
        return departmentDao.getDepartmentByIdDao(id);
    }

    // Get a department by name
    @GetMapping(value = "/getDepartmentByName/{name}")
    public Department getDepartmentByNameController(@PathVariable String name) {
        return departmentDao.getDepartmentByNameDao(name);
    }

    // Update an existing department
    @PostMapping(value = "/updateDepartment/{id}")
    public Department updateDepartmentController(@PathVariable Integer id, @RequestBody Department updatedDepartment) {
        return departmentDao.updateDepartmentDao(id, updatedDepartment);
    }

    // Delete a department by ID
    @DeleteMapping(value = "/deleteDepartment/{id}")
    public boolean deleteDepartmentController(@PathVariable Integer id) {
        return departmentDao.deleteDepartmentDao(id);
    }
}
