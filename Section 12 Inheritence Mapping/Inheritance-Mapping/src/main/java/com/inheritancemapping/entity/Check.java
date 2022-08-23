package com.inheritancemapping.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bankcheck")
//@DiscriminatorValue(value = "ch")
@PrimaryKeyJoinColumn(name = "id")
public class Check extends Payment {

    @Column(name = "checknumber")
    private String checkNumber;
}
