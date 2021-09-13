package com.hr.application.spi;

import com.hr.application.dto.EmployeeResponseDTO;

import java.util.Optional;

public interface EmployeePort {
    Optional<EmployeeResponseDTO> findById(String id);
}
