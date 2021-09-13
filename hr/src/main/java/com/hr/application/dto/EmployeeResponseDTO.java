package com.hr.application.dto;


import com.hr.adapter.persistence.AccountInfo;
import com.hr.adapter.persistence.Company;
import com.hr.adapter.persistence.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class EmployeeResponseDTO {
    private String name;
    private Company company;
    private List<AccountInfo> accountInfo;

    private EmployeeResponseDTO(String name, Company company, List<AccountInfo> accountInfoList) {
        this.name = name;
        this.company = company;
        this.accountInfo = accountInfoList;
    }

    public static EmployeeResponseDTO from(Employee employee) {
        return new EmployeeResponseDTO(
                employee.getName(),
                employee.getCompany(),
                new ArrayList<>(employee.getAccountInfoList())
        );
    }

}
