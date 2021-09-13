package com.hr.adapter.persistence.port;

import com.hr.adapter.persistence.EmployeeRepository;
import com.hr.application.dto.EmployeeResponseDTO;
import com.hr.application.spi.EmployeePort;
import com.hr.domain.BadRequestException;
import com.hr.domain.ErrorCode;
import org.springframework.stereotype.Component;

@Component
public class EmployeePortImp implements EmployeePort {
    private final EmployeeRepository employeeRepository;

    public EmployeePortImp(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeResponseDTO findById(String id){
        return EmployeeResponseDTO.from(this.employeeRepository.findById(id).orElseThrow(
                ()-> new BadRequestException(ErrorCode.ROW_DOES_NOT_EXIST,
                        "Invalid Employee id")

        ));
    }

}
