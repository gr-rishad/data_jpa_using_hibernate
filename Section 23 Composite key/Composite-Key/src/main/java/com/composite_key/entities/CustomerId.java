package com.composite_key.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CustomerId implements Serializable {

    private static final long serialVersionUID=1L;
    private Integer id;
    private String email;
}
