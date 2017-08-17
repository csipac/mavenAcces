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
public class Location {
    private Integer idLocation;
    private Integer idCompany;
    private String nameLocation;
    private String phone;
    private String email;
    private int deleted;
    private Company company;

    public Location() {
    }

    public Location(Integer idLocation, Integer idCompany, String nameLocation, 
            String phone, String email, int deleted, Company company) {
        this.idLocation = idLocation;
        this.idCompany = idCompany;
        this.nameLocation = nameLocation;
        this.phone = phone;
        this.email = email;
        this.deleted = deleted;
        this.company = company;
    }
    
    public Location(Integer idLocation, Integer idCompany, String nameLocation, 
            String phone, String email, Company company) {
        this.idLocation = idLocation;
        this.idCompany = idCompany;
        this.nameLocation = nameLocation;
        this.phone = phone;
        this.email = email;
        this.company = company;
    }

    public Integer getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Integer idLocation) {
        this.idLocation = idLocation;
    }

    public Integer getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
    }

    public String getNameLocation() {
        return nameLocation;
    }

    public void setNameLocation(String nameLocation) {
        this.nameLocation = nameLocation;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Location{" + "idLocation=" + idLocation + ", idCompany=" + idCompany + ", nameLocation=" + nameLocation + ", phone=" + phone + ", email=" + email + ", deleted=" + deleted + ", company=" + company + '}';
    }
}
