package com.hr.adapter.persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "company")
public class Company extends BaseEntity{
    @Column(name="name", nullable = false)
    private String name;

    private Company(String name){
        this.name = name;
    }

    public static Company create(String name){
        return new Company(name);
    }
}
