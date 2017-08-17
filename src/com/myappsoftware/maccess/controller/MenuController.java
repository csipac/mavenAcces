package com.myappsoftware.maccess.controller;

import com.google.gson.Gson;
import com.myappsoftware.maccess.dao.MenuDAO;
import com.myappsoftware.maccess.model.Menu;
import com.myappsoftware.maccess.util.Util;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author erick
 */
@Controller
@RequestMapping(value="/menus")
public class MenuController {
    
    private MenuDAO menuDAO;
    
    public MenuController(MenuDAO menuDAO){
        this.menuDAO = menuDAO;
    }
    
    @RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String index(){
        List<Menu> list = menuDAO.list();
        Gson gson = new Gson();
        return gson.toJson(list);
    }
    
    @RequestMapping(method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String add(HttpServletRequest request){
        Gson gson = new Gson();
        Util util = new Util();
        String response = "{'estado':0}";
        int result = 0;
        Menu menu = gson.fromJson(util.getJSON(request), Menu.class);
        System.out.println(menu);
        result = menuDAO.insert(menu);
        if(result ==1){
            response = "{'estado':"+String.valueOf(result)+"}";
        }
        return gson.toJson(response);
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String edit(HttpServletRequest request){
        Util util = new Util();
        Gson gson = new Gson();
        String response = "{'estado':0}";
        int result = 0;
        Menu menu = gson.fromJson(util.getJSON(request), Menu.class);
        System.out.println(menu);
        result = menuDAO.update(menu);
        if(result ==1){
            response = "{'estado':"+String.valueOf(result)+"}";
        }
        return response;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String delete(HttpServletRequest request,@PathVariable("id") String id){
        Gson gson = new Gson();
        String response = "{'estado':0}";
        int result = 0;
        result = menuDAO.delete(id);
        response = "{\"estado\":"+String.valueOf(result)+"}";
        return response;
    }
}
