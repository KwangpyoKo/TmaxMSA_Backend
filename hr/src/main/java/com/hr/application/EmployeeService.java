package com.hr.application;

import com.hr.application.dto.EmployeeResponseDTO;
import com.hr.application.spi.EmployeePort;
import com.hr.domain.BadRequestException;
import com.hr.domain.ErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {
    private final EmployeePort employeePort;

    public EmployeeService(EmployeePort employeePort){
        this.employeePort = employeePort;
    }

    @Transactional(readOnly = true)
    public EmployeeResponseDTO findById(String id){
        return this.employeePort.findById(id).orElseThrow(
                ()-> new BadRequestException(ErrorCode.ROW_DOES_NOT_EXIST,"Invalid employee id: "+id)); }
}