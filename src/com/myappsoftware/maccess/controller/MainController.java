/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myappsoftware.maccess.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author erick
 */
@Controller
@RequestMapping
public class MainController {
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView indexView(HttpServletRequest request, ModelAndView model){
        model.setViewName("index");
        return model;
    }
}
