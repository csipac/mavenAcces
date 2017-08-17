/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myappsoftware.maccess.configuration;

import javax.servlet.Filter;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author erick
 */
public class SessionFilter implements Filter{
    
    @Override
    public void destroy() {
    }
    
    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
                    FilterChain chain) throws IOException, ServletException {

            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) res;
            HttpSession session = request.getSession();
            Boolean isLogged = session.getAttribute("isLogged") == null? false : (Boolean)session.getAttribute("isLogged");
            isLogged = isLogged && session.getAttribute("isLogged") != null; 
            String url = request.getServletPath();

            if(isLogged || url.contains("login") || url.contains("css") || 
                            url.contains("js") || url.contains("fonts") || url.contains("img") || url.contains("register") || url.contains("/log/mail/update")){

                            chain.doFilter(request, response);			
            }else{

                    response.setHeader("Refresh", "0; URL="+request.getContextPath()+"/account/login");
            }
            return;
    }

	public void init(FilterConfig config) throws ServletException {
	}
}
