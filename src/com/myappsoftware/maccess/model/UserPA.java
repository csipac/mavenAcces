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
public class UserPA {
    private String idUserPA;
    private String idUser;
    private String idAccessPoint;
    private int deleted;
    private User user;
    private AccessPoint ap;

    public UserPA() {
    }

    public UserPA(String idUserPA, String idUser, String idAccessPoint, int deleted, User user, AccessPoint ap) {
        this.idUserPA = idUserPA;
        this.idUser = idUser;
        this.idAccessPoint = idAccessPoint;
        this.deleted = deleted;
        this.user = user;
        this.ap = ap;
    }

    public String getIdUserPA() {
        return idUserPA;
    }

    public void setIdUserPA(String idUserPA) {
        this.idUserPA = idUserPA;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdAccessPoint() {
        return idAccessPoint;
    }

    public void setIdAccessPoint(String idAccessPoint) {
        this.idAccessPoint = idAccessPoint;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AccessPoint getAp() {
        return ap;
    }

    public void setAp(AccessPoint ap) {
        this.ap = ap;
    }
}
