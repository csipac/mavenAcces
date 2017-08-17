package com.myappsoftware.maccess.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myappsoftware.dbutil.DBConnection;
import com.myappsoftware.maccess.model.Menu;
import com.myappsoftware.maccess.model.Role;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erick
 */
public class MenuDAO {
    private final String FULL_FIELDS = "menu_id,role_id_m,parent_menu_id,menu,url,menu_index,url_type";
    private final String FULL_FIELDS_ROLE = "role_id,role";
    private final String SELECT_FIELDS = "m.idMenu AS menu_id, m.idRole AS role_id_m,m.idParentMenu AS parent_menu_id,m.menuText AS menu,m.url AS url,m.menuIndex AS menu_index,m.typeURL AS url_type";
    private final String SELECT_FIELDS_ROLE ="r.idRole AS  role_id,r.roleType AS role";
    private final String UPDATE_FIEDLS = "idMenu,idRole,idParentMenu,menuText,url,menuIndex,typeURL";
    private final String CREATE_FIELDS = "idMenu,idRole,idParentMenu,menuText,url,menuIndex,typeURL";
    private final String TABLE = "menu";
    
    public List<Menu> list(){
        List<Menu> menuList = new ArrayList<>();
        String query = "";
        try {
            query = "SELECT " + SELECT_FIELDS +","+ SELECT_FIELDS_ROLE + 
                    " FROM "+ TABLE+ " m " +
                    "INNER JOIN role r "+
                    "ON m.idRole = r.idRole";
            String[] menuFields = FULL_FIELDS.split(",");
            String[] roleFields = FULL_FIELDS_ROLE.split(",");      
            
            query = String.format(query);
            
            DBConnection.getInstance().getConn();
            ResultSet result = DBConnection.getInstance().executeSelect(query);
            
            while(result.next()){
                Menu menu = new Menu(result.getInt(menuFields[0]),
                    result.getInt(menuFields[1]),
                    result.getString(menuFields[2]),
                    result.getString(menuFields[3]),
                    result.getString(menuFields[4]),
                    result.getInt(menuFields[5]),
                    result.getString(menuFields[6]));
                    
                    menu.setRole(new Role(result.getInt(roleFields[0]), 
                                            result.getString(roleFields[1])));
                menuList.add(menu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return menuList;
    }
    
    public List<Menu> listByRole(String role){
        List<Menu> list = new ArrayList<>();
        String query = "SELECT " + SELECT_FIELDS +","+ SELECT_FIELDS_ROLE + 
                    "FROM "+ TABLE+ "m " +
                    "INNER JOIN role r "+
                    "ON m.idRole = r.idRole "+
                    "AND m.idRole = %s";
               
        return list;
    }
    
    public int insert(Menu menu){
        int result = 0;
        String insert = "INSERT INTO "+TABLE+"("+CREATE_FIELDS+") VALUES (?,?,?,?,?,?,?)";
        try {
            result = DBConnection.getInstance().executeStament(insert,
                    menu.getIdMenu(),
                    menu.getIdRole(),
                    menu.getIdParentMenu(),
                    menu.getMenuText(),
                    menu.getUrl(),
                    menu.getMenuIndex(),        
                    menu.getTypeURL());
        } catch (SQLException ex) {
            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public int update(Menu menu){
        int result = 0;
        String[] fields = UPDATE_FIEDLS.split(",");
        String update = "UPDATE "+TABLE+" " +
                        "SET "+fields[1]+"=?, "+fields[2]+"=?, "+fields[3]+"=?, "+fields[4]+"=?, "+fields[5]+"=?, " + fields[6]+"=? "+
                        "WHERE "+fields[0]+"=?";
        try {
            result = DBConnection.getInstance().executeStament(update,menu.getIdRole(),
                    menu.getIdParentMenu(),
                    menu.getMenuText(),
                    menu.getUrl(),
                    menu.getMenuIndex(),
                    menu.getTypeURL(),
                    menu.getIdMenu());
        } catch(SQLException ex){
            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public int delete(String menu){
        int result = 0;
        String delete = "UPDATE "+TABLE + " SET deleted=0 WHERE idMenu=?";
        try {
            result = DBConnection.getInstance().executeStament(delete, menu);
        } catch(SQLException ex){
            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return result;
    }
}
