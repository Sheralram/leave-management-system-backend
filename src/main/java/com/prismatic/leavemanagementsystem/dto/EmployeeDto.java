package com.prismatic.leavemanagementsystem.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class EmployeeDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;

    @Column(name = "name")
    private String name;

//        @Column(name = "leavedate")
//        private String leavedate;

    @Column(name = "leavetype")
    private String leavetype;

    @Column(name = "notes")
    private String notes;

    @Column(name = "leaveStartdate")
    private String leaveStartdate;

    @Column(name = "leaveEnddate")
    private String leaveEnddate;

}
