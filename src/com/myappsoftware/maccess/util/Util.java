/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myappsoftware.maccess.util;

import com.google.gson.Gson;
import com.myappsoftware.maccess.controller.MenuController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author erick
 */
public class Util {
    public String getJSON(HttpServletRequest request){
        StringBuilder builder = new StringBuilder();
        Gson gson = new Gson();
        String aux = "";
        try {
            while((aux = request.getReader().readLine()) != null){
                builder.append(aux);
            }
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return builder.toString();
    }
}
