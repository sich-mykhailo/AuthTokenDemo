package com.authtokendemo.controller;

import com.authtokendemo.model.Employee;
import com.authtokendemo.model.dto.EmployeeRequestDto;
import com.authtokendemo.model.dto.EmployeeResponseDto;
import com.authtokendemo.service.EmployeeService;
import com.authtokendemo.service.GoogleService;
import com.authtokendemo.service.mapper.employee.EmployeeRequestMapper;
import com.authtokendemo.service.mapper.employee.EmployeeResponseMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employers")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeRequestMapper employeeRequestMapper;
    private final EmployeeResponseMapper employeeResponseMapper;

    public EmployeeController(EmployeeService employeeService,
                              EmployeeRequestMapper employeeRequestMapper,
                              EmployeeResponseMapper employeeResponseMapper) {
        this.employeeService = employeeService;
        this.employeeRequestMapper = employeeRequestMapper;
        this.employeeResponseMapper = employeeResponseMapper;
    }

    @GetMapping("/{id}")
    public EmployeeResponseDto findById(@PathVariable String id) {
        return employeeResponseMapper.mapToDto(employeeService.findById(id));
    }

    @GetMapping
    public List<EmployeeResponseDto> getAll() {
        return employeeService.findAll()
                .stream()
                .map(employeeResponseMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public EmployeeResponseDto create(@RequestBody EmployeeRequestDto requestDto) {
        return employeeResponseMapper.mapToDto(employeeService
                .save(employeeRequestMapper.mapToModel(requestDto)));
    }

    @PutMapping("/{id}")
    public EmployeeResponseDto update(
            @PathVariable String id, @RequestBody EmployeeRequestDto requestDto) {
        Employee employee = employeeRequestMapper.mapToModel(requestDto);
        employee.setId(id);
        return employeeResponseMapper.mapToDto(employeeService.save(employee));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        employeeService.delete(id);
    }
}
