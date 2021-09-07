package com.hr.application.spi;

import com.hr.application.dto.EmployeeDTO;

public interface EmployeePort {
    EmployeeDTO findById(String id);
}
