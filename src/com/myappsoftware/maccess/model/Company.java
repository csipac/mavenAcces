/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myappsoftware.maccess.model;

/**
 *
 * @author erick
 */
public class Company {
    private Integer idCompany;
    private String nameCompany;
    private String phone;
    private String email;
    private int deleted;

    public Company() {
    }

    public Company(Integer idCompany, String nameCompany, String phone, String email, int deleted) {
        this.idCompany = idCompany;
        this.nameCompany = nameCompany;
        this.phone = phone;
        this.email = email;
        this.deleted = deleted;
    }
    
    public Company(Integer idCompany, String nameCompany, String phone, String email) {
        this.idCompany = idCompany;
        this.nameCompany = nameCompany;
        this.phone = phone;
        this.email = email;
    }

    public Company(String nameCompany, String phone, String email) {
        this.nameCompany = nameCompany;
        this.phone = phone;
        this.email = email;
    }
    
    public Integer getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Company{" + "idCompany=" + idCompany + ", nameCompany=" + nameCompany + ", phone=" + phone + ", email=" + email + ", deleted=" + deleted + '}';
    }
    
}
