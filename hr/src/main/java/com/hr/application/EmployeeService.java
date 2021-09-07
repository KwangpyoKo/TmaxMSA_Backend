package com.hr.application;


import com.hr.application.dto.EmployeeDTO;
import com.hr.application.spi.EmployeePort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {
    private EmployeePort employeePort;

    public EmployeeService(EmployeePort employeePort){
        this.employeePort = employeePort;
    }

    @Transactional(readOnly = true)
    public EmployeeDTO findById(String id){
        return this.employeePort.findById(id);
    }

}
