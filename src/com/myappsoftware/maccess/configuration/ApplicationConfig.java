/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myappsoftware.maccess.configuration;

import com.myappsoftware.maccess.dao.CompanyDAO;
import com.myappsoftware.maccess.dao.LocationDAO;
import com.myappsoftware.maccess.dao.MenuDAO;
import com.myappsoftware.maccess.dao.RoleDAO;
import com.myappsoftware.maccess.controller.RoleController;
import com.myappsoftware.maccess.dao.UserDAO;
import com.myappsoftware.maccess.controller.CompanyController;
import com.myappsoftware.maccess.controller.LocationController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.myappsoftware.maccess.controller.MainController;
import com.myappsoftware.maccess.controller.MenuController;
import com.myappsoftware.maccess.controller.UserController;

@Configuration
@ComponentScan({"com.myappsoftware.maccess.configuration"})
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

    @Value("${maccess.SiteName}")
    private String siteName;

    @Bean
    public MainController main(){
        return new MainController();
    }

    @Bean
    public MenuController menu(){
        return new MenuController(new MenuDAO());
    }

    @Bean
    public CompanyController company(){
        return new CompanyController(new CompanyDAO());
    }

    @Bean
    public RoleController roleController(){
        return new RoleController(new RoleDAO());
    }
  
    @Bean LocationController location() {
    	return new LocationController(new LocationDAO());
    }
    
    @Bean UserController user() {
    	return new UserController(new UserDAO());
    }
    
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer()
    {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
