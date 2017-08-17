/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myappsoftware.maccess.dao;

import com.myappsoftware.maccess.model.Role;
import java.util.ArrayList;
import java.util.List;
import com.myappsoftware.dbutil.DBConnection;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author erick
 */
@Component
public class RoleDAO {
    private final String ROLE_FIELDS = "idRole,roleType";
    private final String CRUD_FIELDS = "idRole,roleType";
    private final String TABLE = "role";
    
    public List<Role> list(){
        List<Role> rolesList = new ArrayList<>();
        String query = "";
        ResultSet result = null;

        try {
            query = "SELECT "+ ROLE_FIELDS + " FROM " + TABLE + " WHERE deleted = 0";
            String[] fields = ROLE_FIELDS.split(",");




            DBConnection.getInstance().getConn();
            result = DBConnection.getInstance().executeSelect(query);
            while(result.next()){
                Role role = new Role(result.getInt(fields[0]),result.getString(fields[1]));
                rolesList.add(role);

            }
        } catch (SQLException e) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBConnection.getInstance().closeConnection();
        }
        return rolesList;
    }
    
    public Role get(Integer id){
        Role role = null;
        String query = "SELECT "+ROLE_FIELDS +" "+
                        "FROM "+ TABLE + " "+
                        "WHERE deleted = 0 AND idRole =%d";
        String[] fields = ROLE_FIELDS.split(",");
        query = String.format(query,id);
        try {
            DBConnection.getInstance().getConn();
            ResultSet result = DBConnection.getInstance().executeSelect(query);
            while(result.next()){
                role = new Role(result.getInt(fields[0]),result.getString(fields[1]));
            }
        } catch(SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.getInstance().closeConnection();
        }
        return role;
    }
    
    public  Integer insert(Role role){
        int result = 0;
        String[] fields = CRUD_FIELDS.split(",");
        String insert = "INSERT INTO "+TABLE+" ("+fields[1]+") VALUES(?)";
        try {
            result = DBConnection.getInstance().executeStament(insert,
                    role.getRoleType());

        } catch(SQLException e){
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }

    public int update(Role role){
        int result = 0;
        String[] fields = CRUD_FIELDS.split(",");
        String update = "UPDATE "+TABLE+" " +
                "SET "+fields[1]+"=? "+
                "WHERE "+fields[0]+"=?";
        try {
            result = DBConnection.getInstance().executeStament(update,
                    role.getRoleType(),
                    role.getIdRole());


        } catch(SQLException e){
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }

    public int delete(Integer role){
        int re = 0;
        String delete = "UPDATE "+TABLE + " SET deleted=1 WHERE idRole=?";
        try{
            re = DBConnection.getInstance().executeStament(delete, role);
        }catch (SQLException e){
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return re;
    }

    
}
