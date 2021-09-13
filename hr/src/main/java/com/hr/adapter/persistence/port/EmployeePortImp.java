package com.hr.adapter.persistence.port;

import com.hr.adapter.persistence.EmployeeRepository;
import com.hr.application.dto.EmployeeResponseDTO;
import com.hr.application.spi.EmployeePort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmployeePortImp implements EmployeePort {
    private final EmployeeRepository employeeRepository;

    public EmployeePortImp(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Optional<EmployeeResponseDTO> findById(String id){
        return this.employeeRepository.findById(id).map(EmployeeResponseDTO::from);
    }

}
