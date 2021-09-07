package com.hr.application.dto;


import com.hr.adapter.persistence.AccountInfo;
import com.hr.adapter.persistence.Company;
import com.hr.adapter.persistence.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Getter
@NoArgsConstructor
public class EmployeeDTO {
    private String name;
    private Company company;
    private Set<AccountInfo> accountInfo;

    public EmployeeDTO(String name, Company company, Set<AccountInfo> accountInfoList) {
        this.name = name;
        this.company = company;
        this.accountInfo = accountInfoList;
    }

    public static EmployeeDTO from(Employee employee) {
        return new EmployeeDTO(
                employee.getName(),
                employee.getCompany(),
                employee.getAccountInfoList()
        );
    }

}
