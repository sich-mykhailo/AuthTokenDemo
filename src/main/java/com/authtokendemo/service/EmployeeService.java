package com.authtokendemo.service;

import com.authtokendemo.model.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee save(Employee employee);

    Employee findById(String id);

    Optional<Employee> findEmployeeByEmail(String email);

    void delete(String id);

    List<Employee> findAll();
}
