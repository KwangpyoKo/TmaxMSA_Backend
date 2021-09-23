package com.hr.application;

import com.hr.adapter.persistence.AccountInfo;
import com.hr.adapter.persistence.Company;
import com.hr.adapter.persistence.Employee;
import com.hr.application.dto.EmployeeResponseDTO;
import com.hr.application.spi.EmployeePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @Mock
    private EmployeePort employeePort;

    @InjectMocks
    private EmployeeService employeeService;

    private Company company;
    private AccountInfo accountInfo;
    private Employee employee;
    private EmployeeResponseDTO employeeResponse;

    @BeforeEach
    public void setUp(){
        this.company = Company.from("test_company");
        this.employee = Employee.of("employee_id", "name",  this.company);
        this.accountInfo = AccountInfo.of("test_account", this.employee);
        this.employee.setAccountInfoList(Set.of(accountInfo));
        this.employeeResponse = EmployeeResponseDTO.from(this.employee);
    }

    @Test
    void findEmployeeByIdSuccessfully() throws Exception{
        //given
        given(employeePort.findById(this.employee.getId())).willReturn(Optional.of(employeeResponse));

        //when
        EmployeeResponseDTO findEmployee = employeeService.findById(this.employee.getId());

        //then
        assertEquals(this.employee.getName(),findEmployee.getName(),"Find employee by id test fail");
        verify(employeePort).findById(this.employee.getId());
    }

}
