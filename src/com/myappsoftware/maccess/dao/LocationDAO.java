/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myappsoftware.maccess.dao;

import com.myappsoftware.dbutil.DBConnection;
import com.myappsoftware.maccess.model.Company;
import com.myappsoftware.maccess.model.Location;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

/**
 *
 * @author erick
 */
@Component
public class LocationDAO {
    private final String FIELDS = "location_id,company_id,location_name,location_phone,location_email,"+
                            "c_id,company_name,company_phone,company_email";
    private final String CRUD_FIELDS = "idCompany, nameLocation, phone, email,deleted";
    private final String INSERT_FIELDS = "nameLocation, phone, email";
    private final String SELECT_FIELDS = "l.idLocation AS location_id, l.idCompany AS company_id, l.nameLocation AS location_name," +
                                  "l.phone AS location_phone,l.email AS location_email,c.idCompany AS c_id," +
                                  "c.nameCompany AS company_name,c.phone AS company_phone,c.email AS company_email";
    private final String TABLE = "location";
    private final String TABLEJ = "company";
    
    public List<Location> list(){
        List<Location> list = new ArrayList<>();
        String query = "";
        try {
            String[] fields = FIELDS.split(",");
            query = "SELECT "+ SELECT_FIELDS + 
                    " FROM "+ TABLE + 
                    " l INNER JOIN "+ TABLEJ+ " c "+
                    "ON l.idCompany = c.idCompany "+
                    "WHERE l.deleted=0";
            DBConnection.getInstance().getConn();
            ResultSet result = DBConnection.getInstance().executeSelect(query);
            while(result.next()){
                Location location = new Location(result.getInt(fields[0]),
                                                result.getInt(fields[1]),
                                                result.getString(fields[2]),
                                                result.getString(fields[3]),
                                                result.getString(fields[4]),
                                                new Company(
                                                        result.getInt(fields[5]),
                                                        result.getString(fields[6]),
                                                        result.getString(fields[7]),
                                                        result.getString(fields[8])
                                                ));
                list.add(location);
            }
        }catch(SQLException ex){
            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);   
        }
        return list;
    }
    
    public Location get(int id){
        Location location = null;
        String query = "";
        try {
            String[] fields = FIELDS.split(",");
            query = "SELECT "+ SELECT_FIELDS + 
                    " FROM "+ TABLE + 
                    " l INNER JOIN "+ TABLEJ+ " c"+
                    "ON l.idCompany = c.idCompany "+
                    "WHERE l.deleted=0 AND l.idLocation = %d";
            query = String.format(query, id);
            DBConnection.getInstance().getConn();
            ResultSet result = DBConnection.getInstance().executeSelect(query);
            while(result.next()){
                location = new Location(result.getInt(fields[0]),
                                                result.getInt(fields[1]),
                                                result.getString(fields[2]),
                                                result.getString(fields[3]),
                                                result.getString(fields[4]),
                                                new Company(
                                                        result.getInt(fields[5]),
                                                        result.getString(fields[6]),
                                                        result.getString(fields[7]),
                                                        result.getString(fields[8])
                                                ));
            }
        }catch(SQLException ex){
            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);   
        }
        return location;
    }
    
    public int insert(Location location){
        int result = 0;
        String insert = "INSERT INTO "+TABLE+" ("+INSERT_FIELDS+") VALUES (?, ?, ?)";
        try {
            result = DBConnection.getInstance().executeStament(insert, 
                    location.getNameLocation(),
                    location.getPhone(),
                    location.getEmail());
        } catch (SQLException ex) {
            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public int update(Location location){
        int result = 0;
        String update = "UPDATE location SET nameLocation=?, phone=?, email=? WHERE idLocation=?";
        try {
            result = DBConnection.getInstance().executeStament(update, 
                    location.getNameLocation(),
                    location.getPhone(),
                    location.getEmail(),
                    location.getIdLocation());
        } catch (SQLException ex) {
            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public int delete(int id){
        int result = 0;
        String update = "UPDATE location SET deleted=0 WHERE idLocation=?";
        try {
            result = DBConnection.getInstance().executeStament(update, id);
        } catch (SQLException ex) {
            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
