package com.hr.adapter.persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "account_info")
public class AccountInfo extends BaseEntity{
    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @ManyToOne(optional = false)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private AccountInfo(String accountNumber, Employee employee){
        this.accountNumber = accountNumber;
        this.employee = employee;
    }

    public static AccountInfo of(String accountNumber, Employee employee){
        return new AccountInfo(accountNumber,employee);
    }

}
