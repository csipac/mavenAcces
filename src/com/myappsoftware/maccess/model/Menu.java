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
public class Menu {
    private Integer idMenu;
    private Integer idRole;
    private String idParentMenu;
    private String menuText;
    private String url;
    private int menuIndex;
    private String typeURL;
    private int deleted;
    private Role role;

    public Menu(){}

    public Menu(Integer idMenu, Integer idRole, String idParentMenu, String menuText, 
                String url, int menuIndex, String typeURL, int deleted, Role role) {
        this.idMenu = idMenu;
        this.idRole = idRole;
        this.idParentMenu = idParentMenu;
        this.menuText = menuText;
        this.url = url;
        this.menuIndex = menuIndex;
        this.typeURL = typeURL;
        this.deleted = deleted;
        this.role = role;
    }
    
    public Menu(Integer idMenu, Integer idRole, String idParentMenu, String menuText, 
                String url, int menuIndex, String typeURL) {
        this.idMenu = idMenu;
        this.idRole = idRole;
        this.idParentMenu = idParentMenu;
        this.menuText = menuText;
        this.url = url;
        this.menuIndex = menuIndex;
        this.typeURL = typeURL;
    }
    
    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getIdParentMenu() {
        return idParentMenu;
    }

    public void setIdParentMenu(String idParentMenu) {
        this.idParentMenu = idParentMenu;
    }

    public String getMenuText() {
        return menuText;
    }

    public void setMenuText(String menuText) {
        this.menuText = menuText;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getMenuIndex() {
        return menuIndex;
    }

    public void setMenuIndex(int menuIndex) {
        this.menuIndex = menuIndex;
    }

    public String getTypeURL() {
        return typeURL;
    }

    public void setTypeURL(String typeURL) {
        this.typeURL = typeURL;
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

    @Override
    public String toString() {
        return "Menu{" + "idMenu=" + idMenu + ", idRole=" + idRole + ", idParentMenu=" + idParentMenu + ", menuText=" + menuText + ", url=" + url + ", menuIndex=" + menuIndex + ", typeURL=" + typeURL + ", deleted=" + deleted + ", role=" + role + '}';
    }
    
    
    
}
