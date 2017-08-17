/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myappsoftware.maccess.controller;

import com.google.gson.Gson;
import com.myappsoftware.maccess.util.Util;
import com.myappsoftware.maccess.dao.CompanyDAO;
import com.myappsoftware.maccess.model.Company;
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
@RequestMapping(value = "/companies")
public class CompanyController {
    
    private CompanyDAO companyDAO;
    
    public CompanyController(CompanyDAO companyDAO){
        this.companyDAO = companyDAO;
    }
    
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String index(){
        List<Company> list = companyDAO.list();
        Gson gson = new Gson();
        return gson.toJson(list);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String get(HttpServletRequest request, @PathVariable("id") String id){
        int iId = Integer.parseInt(id);
        Gson gson = new Gson();
        Company company = companyDAO.get(iId);
        return gson.toJson(company,Company.class);
    }
    
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String add(HttpServletRequest request){
        Util util = new Util();
        Gson gson = new Gson();
        String respuesta = "{'estado':0}";
        int resultado = 0;
        Company company = gson.fromJson(util.getJSON(request), Company.class);
        System.out.println(company.toString());
        resultado = companyDAO.insert(company);
        if(resultado == 1){
            respuesta = "{'estado':"+String.valueOf(resultado)+"}";
        }
        return gson.toJson(respuesta);
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String edit(HttpServletRequest request){
        Util util = new Util();
        Gson gson = new Gson();
        String respuesta = "{'estado':0}";
        int resultado = 0;
        Company company = gson.fromJson(util.getJSON(request), Company.class);
        resultado = companyDAO.update(company);
        if(resultado == 1){
            respuesta = "{'estado':"+String.valueOf(resultado)+"}";
        }
        return gson.toJson(respuesta);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String delete(HttpServletRequest request, @PathVariable("id") String id){
        Gson gson = new Gson();
        int iId = Integer.parseInt(id);
        String respuesta = "{'estado':0}";
        int resultado = 0;
        resultado = companyDAO.delete(iId);
        if(resultado == 1){
            respuesta = "{'estado':"+String.valueOf(resultado)+"}";
        }
        return gson.toJson(respuesta);
    }
}
