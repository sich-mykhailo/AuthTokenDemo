package com.authtokendemo.model.dto;

import com.authtokendemo.model.Employee;
import lombok.Data;

@Data
public class EmployeeResponseDto {
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String gender;
    private String phone;
    private String address;
    private String position;
    Employee.Status status;
}
