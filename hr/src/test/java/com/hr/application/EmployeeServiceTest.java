package com.hr.application;

import com.hr.adapter.persistence.AccountInfo;
import com.hr.adapter.persistence.Company;
import com.hr.adapter.persistence.Employee;
import com.hr.application.dto.EmployeeResponseDTO;
import com.hr.application.spi.EmployeePort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;
import java.util.HashSet;
import java.util.Optional;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @Mock
    private EmployeePort employeePort;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    void findEmployeeByIdSuccessfully(){
        final Company company = Company.create("company_name");
        final AccountInfo accountInfo = AccountInfo.create("account_number",null);
        final Set<AccountInfo> accountInfoList = new HashSet<AccountInfo>();
        accountInfoList.add(accountInfo);
        final Employee employee = Employee.create("employee_id", "name",  company, accountInfoList);
        final EmployeeResponseDTO employeeDTO = EmployeeResponseDTO.from(employee);

        given(employeePort.findById(employee.getId())).willReturn(Optional.of(employeeDTO));
        EmployeeResponseDTO findEmployee = employeeService.findById(employee.getId());
        Assertions.assertEquals(employee.getName(),findEmployee.getName(),"Find employee by id test fail");
    }

}
