package com.prismatic.leavemanagementsystem.controller;

import com.prismatic.leavemanagementsystem.dto.EmployeeDto;
import com.prismatic.leavemanagementsystem.dto.ResponseDto;
import com.prismatic.leavemanagementsystem.entity.Employee;
import com.prismatic.leavemanagementsystem.exception.ResourceNotFoundException;
import com.prismatic.leavemanagementsystem.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/lms")
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    public EmployeeRepository employeeRepository;

    @GetMapping("/employees-list")
    public List<Employee> getEmployeesList() {
        return employeeRepository.findAll();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {

        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        return ResponseEntity.ok(employee);

    }

    @PutMapping("/employees-update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        employee.setName(employeeDetails.getName());
        employee.setLeaveStartdate(employeeDetails.getLeaveStartdate());
        employee.setleaveEnddate(employeeDetails.getLeaveEnddate());
        employee.setLeavetype(employeeDetails.getLeavetype());
        employee.setNotes(employeeDetails.getNotes());
        Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/employees-delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }





}



































//    @GetMapping("/get-all-employee")
//    public ResponseEntity<ResponseDto> getAllEmployee() {
//        List<Employee> employeePayRollData = employeeService.getAllEmployee();
//        ResponseDto responseDTO = new ResponseDto("Get Call Success", employeePayRollData);
//        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<String> addEmployeePayrollData(
//            @RequestBody EmployeeDto employeePayrollDto) {
//        String employeePayRollData = employeeService.addEmployee(employeePayrollDto);
//        ResponseDto responseDTO = new ResponseDto("Created Employee Payroll Data For ", employeePayRollData);
//        return new ResponseEntity<>("Created Employee Payroll Data For", HttpStatus.OK);
//    }


