package net.javaguides.ems.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Employee;
import net.javaguides.ems.exception.ResourceNotFoundException;
import net.javaguides.ems.mapper.EmployeeMapper;
import net.javaguides.ems.repository.EmployeeRepository;
import net.javaguides.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
      Employee employee= EmployeeMapper.mapToEntity(employeeDto);
      Employee savedEmployee=employeeRepository.save(employee);
      return EmployeeMapper.mapToDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee=employeeRepository.findById(employeeId).orElseThrow(
                ()-> new ResourceNotFoundException("Employee Not Found")
        );
        return EmployeeMapper.mapToDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees=employeeRepository.findAll();
        return employees.stream().map((employee)->EmployeeMapper.mapToDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployeeById(Long employeeId,EmployeeDto employeeDto) {
        Employee employee=employeeRepository.findById(employeeId).orElseThrow(
                ()->new ResourceNotFoundException("Employee with ID not found")
        );
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        Employee savedEmployee=employeeRepository.save(employee);
        return EmployeeMapper.mapToDto(savedEmployee);
    }

    @Override
    public void DeleteById(Long employeeId) {
        Employee employee=employeeRepository.findById(employeeId).orElseThrow(
                ()->new ResourceNotFoundException("Employee with ID not found")
        );

        employeeRepository.deleteById(employeeId);
    }
}
