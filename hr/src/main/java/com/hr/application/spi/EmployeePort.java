package com.hr.application.spi;

import com.hr.application.dto.EmployeeResponseDTO;

public interface EmployeePort {
    EmployeeResponseDTO findById(String id);
}
