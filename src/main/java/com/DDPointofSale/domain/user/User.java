package com.DDPointofSale.domain.user;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "employee")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empid", nullable = false)
    private Integer empID;

    @Column(name = "fname", nullable = false)
    private String fName;

    @Column(name = "lname", nullable = false)
    private String lName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "job", nullable = false)
    private String job;

    @Column(name = "manager")
    private String manager;

    @Column(name = "phone")
    private String phone;

    @Column(name = "hiredate")
    private Date hiredate;

    @Column(name = "createdAt", nullable = false)
    @CreationTimestamp
    private Instant createdAt = Instant.now();


    public Integer getEmpID() {
        return empID;
    }

    public void setEmpID(Integer empID) {
        this.empID = empID;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }


    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }


}