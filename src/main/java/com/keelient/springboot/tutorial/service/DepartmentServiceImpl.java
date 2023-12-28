package com.keelient.springboot.tutorial.service;

import com.keelient.springboot.tutorial.entity.Department;
import com.keelient.springboot.tutorial.error.DepartmentNotFoundException;
import com.keelient.springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<Department> fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department>  department = departmentRepository.findById(departmentId);
        if (!department.isPresent()) {
            throw new DepartmentNotFoundException("Department not found");
        }
        return department;
    }

    @Override
    public void deleteDepartmentByid(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Optional<Department> departmentDb = departmentRepository.findById(departmentId);

        if(Objects.nonNull(department.getDepartmentName()) &&
                !"".equalsIgnoreCase(department.getDepartmentName())){
            departmentDb.get().setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())){
            departmentDb.get().setDepartmentCode(department.getDepartmentCode());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())){
            departmentDb.get().setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(departmentDb.get());
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
