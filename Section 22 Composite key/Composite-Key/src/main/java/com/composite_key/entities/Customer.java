package com.composite_key.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_composite")
//@IdClass(CustomerId.class)
public class Customer {


//    @Id
//    private Integer id;
//    @Id
//    private String email;
    @EmbeddedId
    private CustomerId id;
    @Column(name = "name")
    private String customerName;

}
