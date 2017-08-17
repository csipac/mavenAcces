/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myappsoftware.maccess.configuration;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 *
 * @author erick
 */
public class CharsetFilter implements Filter{
    private String encoding;
    
    @Override
    public void init(FilterConfig config) throws ServletException{
        this.encoding = config.getInitParameter("requestEncoding");
        if(this.encoding == null) encoding = "UTF-8";
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
         if (null == sr.getCharacterEncoding()) {
            sr.setCharacterEncoding(encoding);
        }
        sr1.setContentType("text/html; charset=UTF-8");
        sr1.setCharacterEncoding("UTF-8");

        fc.doFilter(sr, sr1);
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
