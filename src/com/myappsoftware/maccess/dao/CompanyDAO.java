/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myappsoftware.maccess.dao;

import com.myappsoftware.dbutil.DBConnection;
import com.myappsoftware.maccess.model.Company;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erick
 */
public class CompanyDAO {
    
    private final String FULL_FIELDS = "company_id,company_name,phone_number,email";
    private final String SELECT_FIELDS = "c.idCompany AS company_id, c.nameCompany AS company_name,c.phone AS phone_number,c.email AS email";
    private final String CRUD_FIELDS = "idCompany,nameCompany,phone,email,deleted";
    private final String TABLE = "company";
    
    public List<Company> list(){
        List<Company> list = new ArrayList<>();
        String query = "";
        ResultSet result = null;
        try {
            query = "SELECT " + SELECT_FIELDS + " FROM " + TABLE + " c WHERE c.deleted = 0";
            String[] fields = FULL_FIELDS.split(",");
            
            DBConnection.getInstance().getConn();
            result = DBConnection.getInstance().executeSelect(query);
            while(result.next()){
                Company company = new Company(result.getInt(fields[0]), 
                        result.getString(fields[1]), 
                        result.getString(fields[2]), 
                        result.getString(fields[3]));
                list.add(company);
            }
        } catch (SQLException ex){
         Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);   
        }
        return list;
    }    
    
    public Company get(int id){
        Company company = null;
        String query = "";
        try {
            query = "SELECT " + SELECT_FIELDS + " FROM " + TABLE + " c WHERE c.deleted = 0 AND c.idCompany = %d";
            query = String.format(query, id);
            String[] fields = FULL_FIELDS.split(",");
            DBConnection.getInstance().getConn();
            ResultSet result = DBConnection.getInstance().executeSelect(query);
            while(result.next()){
                company = new Company(result.getInt(fields[0]), 
                        result.getString(fields[1]), 
                        result.getString(fields[2]), 
                        result.getString(fields[3]));
            }
        } catch(SQLException ex){
            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);   
        }
        return company;
    }
    
    public Integer insert(Company company){
        int result = 0;
        String[] fields = CRUD_FIELDS.split(",");
        String insert = "INSERT INTO "+TABLE+" ("+fields[1]+","+fields[2]+","+fields[3]+") VALUES(?,?,?)";
        try {
            result = DBConnection.getInstance().executeStament(insert,
                    company.getNameCompany(),
                    company.getPhone(),
                    company.getEmail());
        } catch(SQLException ex){
            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public Integer update(Company company) {
        int result = 0;
        String update = "UPDATE company " +
                        "SET nameCompany=?, phone=?, email=? " +
                        "WHERE idCompany=?";
        try {
            result = DBConnection.getInstance().executeStament(update, 
                    company.getNameCompany(),
                    company.getPhone(),
                    company.getEmail(),
                    company.getIdCompany());
        } catch(SQLException ex){
            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public Integer delete(int id) {
        int result = 0;
        String update = "UPDATE company " +
                        "SET deleted=1 " +
                        "WHERE idCompany=?";
        try {
            result = DBConnection.getInstance().executeStament(update, id);
        } catch(SQLException ex){
            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
