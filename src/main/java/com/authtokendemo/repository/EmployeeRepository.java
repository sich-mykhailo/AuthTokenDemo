package com.authtokendemo.repository;

import com.authtokendemo.model.Employee;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Optional<Employee> findEmployeeByEmail(String email);
}
