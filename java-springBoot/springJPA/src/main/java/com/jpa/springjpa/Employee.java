package com.jpa.springjpa;


import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Employee {


    @Id
    @GeneratedValue
    private int id;
    private String firstN;
    private String LastN;

    public Employee(){

    }

    public Employee(int id, String firstN, String lastN) {
        this.id = id;
        this.firstN = firstN;
        this.LastN = lastN;
    }

    public String getFirstN() {
        return firstN;
    }


    public String getLastN() {
        return LastN;
    }

    public void setFirstN(String firstN) {
        this.firstN = firstN;
    }

    public void setLastN(String lastN) {
        LastN = lastN;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstN='" + firstN + '\'' +
                ", LastN='" + LastN + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
