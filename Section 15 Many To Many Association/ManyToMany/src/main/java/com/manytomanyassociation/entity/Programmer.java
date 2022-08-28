package com.manytomanyassociation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Programmer {

    private int id;
    private String name;
    private int sal;
    private Set<Project> projects;

}
