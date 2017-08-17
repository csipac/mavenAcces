package com.myappsoftware.maccess.dao;

import com.myappsoftware.dbutil.DBConnection;
import com.myappsoftware.maccess.model.Company;
import com.myappsoftware.maccess.model.Role;
import com.myappsoftware.maccess.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO {
    
    private final String FIELDS = "user_id, role_id, company_id, face_id, nickname, email, pass, face_type,"+
                                "r_role_id, role, c_company_id, company_name, phone, c_email";
    private final String SELECT_FIELDS = "u.idUsers AS user_id," +
                                        "u.idRole AS role_id," +
                                        "u.idCompany AS company_id," +
                                        "u.faceID AS face_id," +
                                        "u.nameUser AS nickname," +
                                        "u.email AS email," +
                                        "u.pass AS pass," +
                                        "u.faceType AS face_type," +
                                        "r.idRole AS r_role_id," +
                                        "r.roleType AS role," +
                                        "c.idCompany AS c_company_id," +
                                        "c.nameCompany AS company_name," +
                                        "c.phone AS phone," +
                                        "c.email AS c_email ";
    private final String CRUD_FIELDS = "idRole, idCompany, faceID, nameUser, email, pass, faceType";
    private final String ID_COLUMN = "idUsers";
    private final String TABLE = "users";
    private final String TABLEJ1 = "role";
    private final String TABLEJ2 = "company";
    
    public List<User> list(){
        List<User> list = new ArrayList<>();
        String query = "SELECT "+SELECT_FIELDS+" FROM "+TABLE+" u " +
                        "INNER JOIN "+TABLEJ1+" r " +
                            "ON u.idRole = r.idRole " +
                        "INNER JOIN "+TABLEJ2+" c " +
                            "ON u.idCompany = c.idCompany " +
                        "WHERE u.deleted = 0";
        String[] fields = FIELDS.split(",");
        try{
            DBConnection.getInstance().getConn();
            ResultSet result = DBConnection.getInstance().executeSelect(query);
            while(result.next()){
                User user = new User(
                        result.getInt(fields[0]),
                        result.getInt(fields[1]),
                        result.getInt(fields[2]),
                        result.getString(fields[3]),
                        result.getString(fields[4]),
                        result.getString(fields[5]),
                        result.getString(fields[6]),
                        result.getInt(fields[7]),
                        new Role (
                        		result.getInt(fields[8]),
                        		result.getString(fields[9])
                        		),
                        new Company (
                        		result.getInt(fields[10]),
                        		result.getString(fields[11]),
                        		result.getString(fields[12]),
                        		result.getString(fields[13])
                        		)
                );
                list.add(user);
            }
        } catch(SQLException ex){
         Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public User get(int id){
        User user = null;
        String query = "SELECT "+SELECT_FIELDS+" FROM "+TABLE+" u " +
                        "INNER JOIN "+TABLEJ1+" r " +
                            "ON u.idRole = r.idRole " +
                        "INNER JOIN "+TABLEJ2+" c " +
                            "ON u.idCompany = c.idCompany " +
                        "WHERE u.deleted = 0 AND c.idUsers = %d";
        String[] fields = FIELDS.split(",");
        try{
        	query = String.format(query, id);
            DBConnection.getInstance().getConn();
            ResultSet result = DBConnection.getInstance().executeSelect(query);
            while(result.next()){
               user = new User(
                        result.getInt(fields[0]),
                        result.getInt(fields[1]),
                        result.getInt(fields[2]),
                        result.getString(fields[3]),
                        result.getString(fields[4]),
                        result.getString(fields[5]),
                        result.getString(fields[6]),
                        result.getInt(fields[7]),
                        new Role (
                        		result.getInt(fields[8]),
                        		result.getString(fields[9])
                        		),
                        new Company (
                        		result.getInt(fields[10]),
                        		result.getString(fields[11]),
                        		result.getString(fields[12]),
                        		result.getString(fields[13])
                        		)
                );
            }
        } catch(SQLException ex){
         Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public int insert(User user) {
    	int result = 0;
    	String insert = "INSERT INTO " + TABLE + "("+CRUD_FIELDS+") VALUES (?,?,?,?,?,?,?)";
    	try {
    		result = DBConnection.getInstance().executeStament(insert,
    				user.getIdRole(),
    				user.getIdCompany(),
    				user.getFaceID(),
    				user.getNameUser(),
    				user.getEmail(),
    				user.getEmail(),
    				user.getPassword(),
    				user.getFaceType());
    	} catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public int update(User user){
    	int result = 0;
    	String[] fields = CRUD_FIELDS.split(",");
    	String update = "UPDATE "+TABLE+
    					" SET "+fields[0]+"=?, "+fields[1]+"=?, "+fields[2]+"=?, "+
						fields[3]+"=?, "+fields[4]+"=?, "+fields[5]+"=?,"+fields[6]+"=? "+
    					"WHERE "+ID_COLUMN+"=?";
    	try {
    		result = DBConnection.getInstance().executeStament(update,
    				user.getIdRole(),
    				user.getIdCompany(),
    				user.getFaceID(),
    				user.getNameUser(),
    				user.getEmail(),
    				user.getEmail(),
    				user.getPassword(),
    				user.getFaceType(),
    				user.getIdUser());
    	} catch (SQLException ex) {
    		Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
    	}
    	return result;
    }
    
    public int delete(int id) {
    	int result = 0;
    	String[] fields = CRUD_FIELDS.split(",");
    	String update = "UPDATE "+TABLE+
    					" SET deleted=0 WHERE "+ID_COLUMN+"=?";
    	try {
    		result = DBConnection.getInstance().executeStament(update,id);
    	} catch (SQLException ex) {
    		Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
    	}
    	return result;
    }
}
