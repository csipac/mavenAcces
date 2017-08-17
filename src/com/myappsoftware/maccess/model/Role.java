/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myappsoftware.maccess.model;

import com.myappsoftware.dbutil.annotation.Column;
import com.myappsoftware.dbutil.annotation.Table;

/**
 *
 * @author erick
 */

public class Role {
    private Integer idRole;
    private String roleType;
    private Integer deleted;

    public Role() {
    }

    public Role(Integer idRole, String roleType, Integer deleted) {
        this.idRole = idRole;
        this.roleType = roleType;
        this.deleted = deleted;
    }
    
    public Role(Integer idRole, String roleType) {
        this.idRole = idRole;
        this.roleType = roleType;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}
