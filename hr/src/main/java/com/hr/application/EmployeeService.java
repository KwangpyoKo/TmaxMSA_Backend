package com.hr.application;


import com.hr.application.dto.EmployeeResponseDTO;
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
    public EmployeeResponseDTO findById(String id){
        return this.employeePort.findById(id);
    }

}
