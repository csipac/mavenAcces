/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myappsoftware.maccess.controller;

import com.google.gson.Gson;
import java.util.List;
import com.myappsoftware.maccess.model.Location;
import com.myappsoftware.maccess.dao.LocationDAO;
import com.myappsoftware.maccess.util.Util;
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
@RequestMapping(value = "/locations")
public class LocationController {
    
    private LocationDAO locationDAO;
    
    public LocationController(LocationDAO locationDAO) {
    	this.locationDAO = locationDAO;
	}
    
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String index () {
        List<Location> list = locationDAO.list();
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String get(HttpServletRequest request, @PathVariable("id") String id){
        int iID = Integer.parseInt(id);
        Gson gson = new Gson();
        Location location = locationDAO.get(iID);
        return gson.toJson(location, Location.class);
    }
    
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String add(HttpServletRequest request){
        Util util = new Util();
        Gson gson = new Gson();
        String response = "{'estado':0}";
        int result = 0;
        Location location = gson.fromJson(util.getJSON(request), Location.class);
        System.out.println(location.toString());
        result = locationDAO.insert(location);
        if(result == 1){
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
        Location location = gson.fromJson(util.getJSON(request), Location.class);
        System.out.println(location.toString());
        result = locationDAO.update(location);
        if(result == 1){
            response = "{'estado':"+String.valueOf(result)+"}";
        }
        return gson.toJson(response);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String delete(HttpServletRequest request, @PathVariable("id") String id){
        Gson gson = new Gson();
        String response = "{'estado':0}";
        int iID = Integer.parseInt(id);
        int result = 0;
        result = locationDAO.delete(iID);
        if(result == 1){
            response = "{'estado':"+String.valueOf(result)+"}";
        }
        return gson.toJson(response);
    }
}
