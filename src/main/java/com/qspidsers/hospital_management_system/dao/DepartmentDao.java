package com.qspidsers.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qspidsers.hospital_management_system.entity.Department;
import com.qspidsers.hospital_management_system.repository.DepartmentRepository;



@Repository
public class DepartmentDao {

    @Autowired
    private DepartmentRepository departmentRepo;

    // Save a new department
    public List<Department> saveDepartmentDao(List<Department> department) {
        return departmentRepo.saveAll(department);
    }

    // Get all departments
    public List<Department> getAllDepartmentsDao() {
        return departmentRepo.findAll();
    }

    // Get a department by ID
    public Department getDepartmentByIdDao(int id) {
        return departmentRepo.findById(id).orElse(null);
    }

    // Get a department by name
    public Department getDepartmentByNameDao(String name) {
        return departmentRepo.findByDepartmentName(name).orElse(null);
    }

    // Update an existing department
   
    public Department updateDepartmentDao(int id, Department updatedDepartment) {
        Optional<Department> optional = departmentRepo.findById(id);
        if (optional.isPresent()) {
            Department department = optional.get();
            department.setDepartmentName(updatedDepartment.getDepartmentName());
            department.setDescription(updatedDepartment.getDescription());
//            department.setHeadDoctor(updatedDepartment.getHeadDoctor());
            return departmentRepo.save(department);
        }
        return null;
    }

    // Delete a department by ID
    public boolean deleteDepartmentDao(int id) {
        if (departmentRepo.existsById(id)) {
            departmentRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
