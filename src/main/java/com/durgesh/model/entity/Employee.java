package com.durgesh.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "T_Employee")
public class Employee extends Identity {

    private String companyName;
    private String zipCode;
    private String stateName;
}
