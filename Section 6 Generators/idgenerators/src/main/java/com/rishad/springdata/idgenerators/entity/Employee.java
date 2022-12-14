package com.rishad.springdata.idgenerators.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Employee {

    //  @TableGenerator(name = "employee_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 100)
    @Id
    @GenericGenerator(name = "emp_id", strategy = "com.rishad.springdata.idgenerators.entity.CustomRandomIDGenerator")
    @GeneratedValue(generator = "emp_id")
    // @GeneratedValue(strategy = GenerationType.TABLE, generator = "employee_gen")
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
