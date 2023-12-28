package com.keelient.springboot.tutorial.service;

import com.keelient.springboot.tutorial.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Optional<Department> fetchDepartmentById(Long departmentId);

    public void deleteDepartmentByid(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);
}
