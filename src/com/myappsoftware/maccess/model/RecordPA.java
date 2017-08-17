/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myappsoftware.maccess.model;

import java.sql.Timestamp;

/**
 *
 * @author erick
 */
public class RecordPA {
    private String idrecordAP;
    private String idUser;
    private String idAP;
    private Timestamp dateHour;
    private int actionRecord;
    private int deleted;
    private User user;
    private AccessPoint ap;

    public RecordPA() {
    }

    public RecordPA(String idrecordAP, String idUser, String idAP, Timestamp dateHour, int actionRecord, int deleted, User user, AccessPoint ap) {
        this.idrecordAP = idrecordAP;
        this.idUser = idUser;
        this.idAP = idAP;
        this.dateHour = dateHour;
        this.actionRecord = actionRecord;
        this.deleted = deleted;
        this.user = user;
        this.ap = ap;
    }

    public String getIdrecordAP() {
        return idrecordAP;
    }

    public void setIdrecordAP(String idrecordAP) {
        this.idrecordAP = idrecordAP;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdAP() {
        return idAP;
    }

    public void setIdAP(String idAP) {
        this.idAP = idAP;
    }

    public Timestamp getDateHour() {
        return dateHour;
    }

    public void setDateHour(Timestamp dateHour) {
        this.dateHour = dateHour;
    }

    public int getActionRecord() {
        return actionRecord;
    }

    public void setActionRecord(int actionRecord) {
        this.actionRecord = actionRecord;
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
