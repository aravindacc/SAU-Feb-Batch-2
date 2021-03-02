package com.aop.Assignment2.models;

import org.springframework.stereotype.Component;

@Component
public class Organization {
    public String getCompany() {
        return "Accolite Digital Pvt Ltd";
    }
    public String getWorkBranch() {
        return "Hyderabad";
    }
}