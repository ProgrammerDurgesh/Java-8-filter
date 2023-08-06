package com.durgesh.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeFilter {
    private String name;
    private String companyName;
    private String zipCode;
    private String stateName;
    private boolean ascending;
    private boolean descending;
    private boolean delete;


}
