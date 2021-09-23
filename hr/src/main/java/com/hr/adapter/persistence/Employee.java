package com.hr.adapter.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;

import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "employee")
public class Employee extends BaseEntity{
    @Column(name="name", nullable = false)
    private String name;

    @ManyToOne()
    @JoinColumn(name = "company_id")
    private Company company;

    @JsonIgnore
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<AccountInfo> accountInfoList;

    private Employee(String id, String name, Company company) {
        super(id);
        this.name = name;
        this.company = company;
    }

    public static Employee of(String id, String name, Company company){
        return new Employee(id, name,company);
    }
}
