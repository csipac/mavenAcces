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
public class User {
    private Integer idUser;
    private Integer idRole;
    private Integer idCompany;
    private String faceID;
    private String nameUser;
    private String email;
    private String password;
    private int faceType;
    private int deleted;
    private Role role;
    private Company company;

    public User() {
    }

    public User(Integer idUser, Integer idRole, Integer idCompany, String faceID, String nameUser, 
            String email, String password, int faceType, int deleted, Role role, Company company) {
        this.idUser = idUser;
        this.idRole = idRole;
        this.idCompany = idCompany;
        this.faceID = faceID;
        this.nameUser = nameUser;
        this.email = email;
        this.password = password;
        this.faceType = faceType;
        this.deleted = deleted;
        this.role = role;
        this.company = company;
    }
    
    public User(Integer idUser, Integer idRole, Integer idCompany,String faceID, String nameUser, 
            String email, String password, int faceType, Role role, Company company) {
        this.idUser = idUser;
        this.idRole = idRole;
        this.idCompany = idCompany;
        this.faceID = faceID;
        this.nameUser = nameUser;
        this.email = email;
        this.password = password;
        this.faceType = faceType;
        this.role = role;
        this.company = company;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getFaceID() {
        return faceID;
    }

    public void setFaceID(String faceID) {
        this.faceID = faceID;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getFaceType() {
        return faceType;
    }

    public void setFaceType(int faceType) {
        this.faceType = faceType;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

	public Integer getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(Integer idCompany) {
		this.idCompany = idCompany;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", idRole=" + idRole + ", idCompany=" + idCompany + ", faceID=" + faceID
				+ ", nameUser=" + nameUser + ", email=" + email + ", password=" + password + ", faceType=" + faceType
				+ ", deleted=" + deleted + ", role=" + role + ", company=" + company + "]";
	}    
}
