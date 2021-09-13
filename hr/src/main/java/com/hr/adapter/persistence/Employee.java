package com.hr.adapter.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import java.util.Set;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "employee")
public class Employee{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column(name="name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @JsonIgnore
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<AccountInfo> accountInfoList;

    private Employee(String name, Company company, Set<AccountInfo> accountInfoList) {
        this.name = name;
        this.company = company;
        this.accountInfoList = accountInfoList;
    }

    public static Employee from(String name, Company company, Set<AccountInfo> accountInfo){
        return new Employee(name,company,accountInfo);
    }


}
