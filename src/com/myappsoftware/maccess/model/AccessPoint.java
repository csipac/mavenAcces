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
public class AccessPoint {
    private String idAP;
    private String idLocation;
    private String idParent;
    private String nameAP;
    private int typeAP;
    private int deleted;
    private Location location;
    private AccessPoint ap;

    public AccessPoint() {
    }

    public AccessPoint(String idAP, String idLocation, String idParent, String nameAP, int typeAP, int deleted, Location location, AccessPoint ap) {
        this.idAP = idAP;
        this.idLocation = idLocation;
        this.idParent = idParent;
        this.nameAP = nameAP;
        this.typeAP = typeAP;
        this.deleted = deleted;
        this.location = location;
        this.ap = ap;
    }

    public String getIdAP() {
        return idAP;
    }

    public void setIdAP(String idAP) {
        this.idAP = idAP;
    }

    public String getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(String idLocation) {
        this.idLocation = idLocation;
    }

    public String getIdParent() {
        return idParent;
    }

    public void setIdParent(String idParent) {
        this.idParent = idParent;
    }

    public String getNameAP() {
        return nameAP;
    }

    public void setNameAP(String nameAP) {
        this.nameAP = nameAP;
    }

    public int getTypeAP() {
        return typeAP;
    }

    public void setTypeAP(int typeAP) {
        this.typeAP = typeAP;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public AccessPoint getAp() {
        return ap;
    }

    public void setAp(AccessPoint ap) {
        this.ap = ap;
    }
}
