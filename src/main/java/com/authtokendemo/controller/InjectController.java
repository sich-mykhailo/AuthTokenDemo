package com.authtokendemo.controller;

import com.authtokendemo.model.Employee;
import com.authtokendemo.service.EmployeeService;
import java.time.LocalDate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inject")
public class InjectController {
    private final EmployeeService employeeService;

    public InjectController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String injectData() {
        Employee employee = new Employee();
        employee.setId("1");
        employee.setHiringDate(LocalDate.now());
        employee.setDateOfBirth(LocalDate.of(1993, 11,21 ));
        employee.setStatus(Employee.Status.ACTIVE);
        employee.setPosition("Java developer");
        employee.setPhone("+380962822014");
        employee.setGender("Male");
        employee.setFirstName("misha");
        employee.setAddress("Mira, 115");
        employee.setLastName("sich");
        employee.setEmail("misha@nerdysoft@gmail.com");
        employeeService.save(employee);
        return "Done!";
    }
}
