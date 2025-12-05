package net.javaguides.ems.controller;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Employee;
import net.javaguides.ems.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee=employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id){
        EmployeeDto savedEmployee=employeeService.getEmployeeById(id);
        return ResponseEntity.ok(savedEmployee);
    }
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees=employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployeeById(@PathVariable Long id,@RequestBody EmployeeDto employeeDto){
        EmployeeDto updatedEmployee=employeeService.updateEmployeeById(id,employeeDto);
        return ResponseEntity.ok(updatedEmployee);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id){
        employeeService.DeleteById(id);
        return ResponseEntity.ok("Successfully removed the Employee !!!");
    }
}
