package com.prismatic.leavemanagementsystem.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

    @Entity
    @Table(name = "employees")
    public class Employee {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

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

//        @Column(name = "status")
//        private String status;


        public Employee() {

        }

        public Employee(String name,  String leaveStartdate,String leaveEnddate,String leavetype, String notes,String status) {
            super();
            this.name = name;
            this.leaveStartdate = leaveStartdate;
            this.leaveEnddate = leaveEnddate;
//            this.leavedate = leavedate;
            this.leavetype = leavetype;
            this.notes = notes;
//            this.status = status;
        }

        public long getId() {
            return id;
        }
        public void setId(long id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }


        public String getLeaveStartdate() {
            return leaveStartdate;
        }
        public void setLeaveStartdate(String leaveStartdate) {
            this.leaveStartdate = leaveStartdate;
        }

        public String getLeaveEnddate() {
            return leaveEnddate;
        }
        public void setleaveEnddate(String leaveEnddate) {
            this.leaveEnddate = leaveEnddate;
        }

        public String getLeavetype() {
            return leavetype;
        }
        public void setLeavetype(String leavetype) {
            this.leavetype = leavetype;
        }
        public String getNotes() {
            return notes;
        }
        public void setNotes(String notes) {
            this.notes = notes;
        }
//        public String getStatus() {
//            return status;
//        }
//        public void setStatus(String status) {
//            this.status = status;
//        }






    }
