package com.myappsoftware.maccess.controller;

import com.google.gson.Gson;
import com.myappsoftware.maccess.util.Util;
import com.myappsoftware.maccess.dao.RoleDAO;
import com.myappsoftware.maccess.model.Role;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

/**
 *
 * @author cristhian
 */

@RestController
@RequestMapping(value = "/roles")
public class RoleController {
    private RoleDAO roleDAO;

    public RoleController(RoleDAO roleDAO){
        this.roleDAO = roleDAO;
    }

    @RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)

    public String index(){
        List<Role> list = roleDAO.list();
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)

    public  String get(HttpServletRequest request, @PathVariable("id") String id){
        int iId = Integer.parseInt(id);
        Gson gson = new Gson();
        Role role = roleDAO.get(iId);
        return gson.toJson(role, Role.class);
    }

    @RequestMapping(method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)

    public String add(HttpServletRequest request){
        Util util = new Util();
        Gson gson = new Gson();
        String respuesta = "{'estado':0}";
        int re = 0;
        Role role = gson.fromJson(util.getJSON(request),Role.class);
        System.out.println(role.toString());
        re = roleDAO.insert(role);
        if (re == 1){
            respuesta = "{'estado':"+String.valueOf(re)+"}";
        }
        return gson.toJson(respuesta);

    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)

    public String edit (HttpServletRequest request){
        Util util = new Util();
        Gson gson = new Gson();
        String respuesta = "{'estado':0}";
        int r = 0;
        Role role = gson.fromJson(util.getJSON(request),Role.class);
        r = roleDAO.update(role);
        if (r == 1){
            respuesta = "{'estado':"+String.valueOf(r)+"}";
        }
        return gson.toJson(respuesta);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)

    public  String delete( @PathVariable("id") String id){
        Gson gson = new Gson();
        int iId = Integer.parseInt(id);
        String respuesta = "{'estado':0}";
        int re = 0;
        re = roleDAO.delete(iId);
        if (re == 1){
            respuesta = "{'estado':"+String.valueOf(re)+"}";
        }
        return gson.toJson(respuesta);
    }

}


