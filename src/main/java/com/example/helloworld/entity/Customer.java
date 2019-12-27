package com.example.helloworld.entity;

public class Customer {
    private Long id;

    private Long customerId;

    private String name;

    private String sex;

    private Long poinsts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Long getPoinsts() {
        return poinsts;
    }

    public void setPoinsts(Long poinsts) {
        this.poinsts = poinsts;
    }
}