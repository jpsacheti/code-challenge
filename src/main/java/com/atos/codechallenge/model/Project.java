package com.atos.codechallenge.model;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class Project {
    private String name;
    private String customer;
    private BigDecimal valueOfProject;
    private ZonedDateTime dtBegin;
    private ZonedDateTime dtEnd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public BigDecimal getValueOfProject() {
        return valueOfProject;
    }

    public void setValueOfProject(BigDecimal valueOfProject) {
        this.valueOfProject = valueOfProject;
    }

    public ZonedDateTime getDtBegin() {
        return dtBegin;
    }

    public void setDtBegin(ZonedDateTime dtBegin) {
        this.dtBegin = dtBegin;
    }

    public ZonedDateTime getDtEnd() {
        return dtEnd;
    }

    public void setDtEnd(ZonedDateTime dtEnd) {
        this.dtEnd = dtEnd;
    }

    @Override
    public String toString() {
        return "Project{" + "name='" + name + '\'' +
                ", customer='" + customer + '\'' +
                '}';
    }
}
