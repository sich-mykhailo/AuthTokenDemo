package com.authtokendemo.service.mapper.employee;

import com.authtokendemo.model.Employee;
import com.authtokendemo.model.dto.EmployeeResponseDto;
import com.authtokendemo.service.mapper.ResponseDtoMapper;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class EmployeeResponseMapper implements ResponseDtoMapper<EmployeeResponseDto, Employee> {
    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public EmployeeResponseDto mapToDto(Employee employee) {
        EmployeeResponseDto responseDto = new EmployeeResponseDto();
        responseDto.setId(employee.getId());
        responseDto.setEmail(employee.getEmail());
        responseDto.setAddress(employee.getAddress());
        responseDto.setGender(employee.getGender());
        responseDto.setLastName(employee.getLastName());
        responseDto.setFirstName(employee.getFirstName());
        responseDto.setPosition(employee.getPosition());
        responseDto.setPhone(employee.getPhone());
        responseDto.setStatus(employee.getStatus());
        return responseDto;
    }
}
