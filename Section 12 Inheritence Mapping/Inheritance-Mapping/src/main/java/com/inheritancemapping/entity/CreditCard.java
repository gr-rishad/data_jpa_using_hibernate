package com.inheritancemapping.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "card")
//@DiscriminatorValue(value = "cc")
@PrimaryKeyJoinColumn(name = "id")
public class CreditCard extends Payment{


    @Column(name = "cardnumber")
    private String cardNumber;
}
