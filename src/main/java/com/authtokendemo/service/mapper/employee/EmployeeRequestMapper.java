package com.authtokendemo.service.mapper.employee;

import com.authtokendemo.model.Employee;
import com.authtokendemo.model.dto.EmployeeRequestDto;
import com.authtokendemo.service.mapper.RequestDtoMapper;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class EmployeeRequestMapper implements RequestDtoMapper<EmployeeRequestDto, Employee> {
    @Override
    public Employee mapToModel(EmployeeRequestDto dto) {
        Employee employee = new Employee();
        employee.setEmail(dto.getEmail());
        employee.setAddress(dto.getAddress());
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setGender(dto.getGender());
        employee.setPhone(dto.getPhone());
        employee.setPosition(dto.getPosition());
        employee.setStatus(dto.getStatus());
        return employee;
    }
}
