package com.hr.adapter.web;

import com.hr.adapter.persistence.Employee;
import com.hr.application.EmployeeService;
import com.hr.application.dto.EmployeeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v0/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public EmployeeDTO findById(@PathVariable String id){
        return this.employeeService.findById(id);
    }
}
