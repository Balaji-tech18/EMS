package net.javaguides.ems.service;

import net.javaguides.ems.dto.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto updateEmployeeById(Long employeeId,EmployeeDto employeeDto);
    void DeleteById(Long employeeId);
}
