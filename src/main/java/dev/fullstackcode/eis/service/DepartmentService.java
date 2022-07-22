package dev.fullstackcode.eis.service;


import dev.fullstackcode.eis.entity.Department;
import dev.fullstackcode.eis.repository.DepartmentRepository;
import dev.fullstackcode.eis.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentService {


    DepartmentRepository departmentRepository;


    EmployeeRepository employeeRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Integer id) {
        return departmentRepository.findById(id).orElseThrow(() ->  new RestClientException("Department with id "+id+" not found"));
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }
}
