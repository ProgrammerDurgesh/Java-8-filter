package com.durgesh.model.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "T_Employee")
public class Employee extends Identity {

    private String companyName;
    private String zipCode;
    private String stateName;
    private Integer orderId;
}
